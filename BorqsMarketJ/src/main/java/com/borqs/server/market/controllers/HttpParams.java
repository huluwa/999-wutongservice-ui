package com.borqs.server.market.controllers;


import com.borqs.server.market.ServiceException;
import com.borqs.server.market.log.Logger;
import com.borqs.server.market.utils.FileUtils2;
import com.borqs.server.market.utils.Params;
import org.apache.commons.collections.EnumerationUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import static com.borqs.server.market.Errors.E_ILLEGAL_PARAM;

public class HttpParams extends Params {

    private static final Logger L = Logger.get(HttpParams.class);

    private static final String PARAMS_ATTR = "$$httpParams$$";

    private static final String templateDirectory = FileUtils2.homePath("tmp/bm_upload_tmp");
    private static ServletFileUpload fileUpload;

    static {
        try {
            FileUtils2.ensureDirectory(templateDirectory);
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setRepository(new File(templateDirectory));
            fileUpload = new ServletFileUpload(factory);
        } catch (IOException e) {
            L.fatal(null, "Create upload directory error", e);
            System.err.println("Setup file upload error " + templateDirectory);
        }
    }

    public HttpParams() {
    }

    @SuppressWarnings("unchecked")
    public static HttpParams create(HttpServletRequest req) throws ServiceException {
        Object o = req.getAttribute(PARAMS_ATTR);
        if (o != null) {
            return (HttpParams) o;
        }

        try {
            HttpParams params = new HttpParams();
            for (String paramName : (List<String>) EnumerationUtils.toList(req.getParameterNames())) {
                params.put(paramName, req.getParameter(paramName));
            }

            if (ServletFileUpload.isMultipartContent(req)) {
                List<FileItem> fileItems = fileUpload.parseRequest(req);
                if (fileItems != null) {
                    for (FileItem fi : fileItems) {
                        if (fi == null)
                            continue;
                        if (fi.isFormField()) {
                            params.put(fi.getFieldName(), fi.getString());
                        } else {
                            params.put(fi.getFieldName(), fi);
                        }
                    }
                }
            }

            req.setAttribute(PARAMS_ATTR, params);
            return params;
        } catch (FileUploadException e) {
            throw new ServiceException(E_ILLEGAL_PARAM, "Parse upload error");
        }
    }

    public void close() {
        for (Object val : this.paramsValues()) {
            if (val instanceof FileItem) {
                try {
                    ((FileItem) val).delete();
                } catch (Exception ignored) {
                }
            }
        }
    }

    public static class CleanerInterceptor extends HandlerInterceptorAdapter {
        public CleanerInterceptor() {
        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
            HttpParams params = (HttpParams) request.getAttribute(PARAMS_ATTR);
            if (params != null) {
                try {
                    params.close();
                } catch (Exception ignored) {
                }
            }
            request.removeAttribute(PARAMS_ATTR);
        }
    }
}
