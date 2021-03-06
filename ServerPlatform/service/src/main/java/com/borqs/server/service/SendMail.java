/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.borqs.server.service;

@SuppressWarnings("all")
public interface SendMail {
  public static final org.apache.avro.Protocol PROTOCOL = org.apache.avro.Protocol.parse("{\"protocol\":\"SendMail\",\"namespace\":\"com.borqs.server.service\",\"types\":[{\"type\":\"error\",\"name\":\"ResponseError\",\"namespace\":\"com.borqs.server.base\",\"fields\":[{\"name\":\"code\",\"type\":\"int\"},{\"name\":\"message\",\"type\":\"string\"}]}],\"messages\":{\"sendEmail\":{\"request\":[{\"name\":\"title\",\"type\":\"string\"},{\"name\":\"to\",\"type\":\"string\"},{\"name\":\"username\",\"type\":\"string\"},{\"name\":\"content\",\"type\":\"string\"},{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"lang\",\"type\":\"string\"}],\"response\":\"boolean\",\"errors\":[\"com.borqs.server.base.ResponseError\"]},\"sendCustomEmail\":{\"request\":[{\"name\":\"title\",\"type\":\"string\"},{\"name\":\"to\",\"type\":\"string\"},{\"name\":\"username\",\"type\":\"string\"},{\"name\":\"content\",\"type\":\"string\"},{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"lang\",\"type\":\"string\"}],\"response\":\"boolean\",\"errors\":[\"com.borqs.server.base.ResponseError\"]},\"sendEmailHTML\":{\"request\":[{\"name\":\"title\",\"type\":\"string\"},{\"name\":\"to\",\"type\":\"string\"},{\"name\":\"username\",\"type\":\"string\"},{\"name\":\"content\",\"type\":\"string\"},{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"lang\",\"type\":\"string\"}],\"response\":\"boolean\",\"errors\":[\"com.borqs.server.base.ResponseError\"]},\"sendEmailElearningHTML\":{\"request\":[{\"name\":\"title\",\"type\":\"string\"},{\"name\":\"to\",\"type\":\"string\"},{\"name\":\"username\",\"type\":\"string\"},{\"name\":\"content\",\"type\":\"string\"},{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"lang\",\"type\":\"string\"}],\"response\":\"boolean\",\"errors\":[\"com.borqs.server.base.ResponseError\"]}}}");
  boolean sendEmail(java.lang.CharSequence title, java.lang.CharSequence to, java.lang.CharSequence username, java.lang.CharSequence content, java.lang.CharSequence type, java.lang.CharSequence lang) throws org.apache.avro.AvroRemoteException, com.borqs.server.base.ResponseError;
  boolean sendCustomEmail(java.lang.CharSequence title, java.lang.CharSequence to, java.lang.CharSequence username, java.lang.CharSequence content, java.lang.CharSequence type, java.lang.CharSequence lang) throws org.apache.avro.AvroRemoteException, com.borqs.server.base.ResponseError;
  boolean sendEmailHTML(java.lang.CharSequence title, java.lang.CharSequence to, java.lang.CharSequence username, java.lang.CharSequence content, java.lang.CharSequence type, java.lang.CharSequence lang) throws org.apache.avro.AvroRemoteException, com.borqs.server.base.ResponseError;
  boolean sendEmailElearningHTML(java.lang.CharSequence title, java.lang.CharSequence to, java.lang.CharSequence username, java.lang.CharSequence content, java.lang.CharSequence type, java.lang.CharSequence lang) throws org.apache.avro.AvroRemoteException, com.borqs.server.base.ResponseError;

  @SuppressWarnings("all")
  public interface Callback extends SendMail {
    public static final org.apache.avro.Protocol PROTOCOL = com.borqs.server.service.SendMail.PROTOCOL;
    void sendEmail(java.lang.CharSequence title, java.lang.CharSequence to, java.lang.CharSequence username, java.lang.CharSequence content, java.lang.CharSequence type, java.lang.CharSequence lang, org.apache.avro.ipc.Callback<java.lang.Boolean> callback) throws java.io.IOException;
    void sendCustomEmail(java.lang.CharSequence title, java.lang.CharSequence to, java.lang.CharSequence username, java.lang.CharSequence content, java.lang.CharSequence type, java.lang.CharSequence lang, org.apache.avro.ipc.Callback<java.lang.Boolean> callback) throws java.io.IOException;
    void sendEmailHTML(java.lang.CharSequence title, java.lang.CharSequence to, java.lang.CharSequence username, java.lang.CharSequence content, java.lang.CharSequence type, java.lang.CharSequence lang, org.apache.avro.ipc.Callback<java.lang.Boolean> callback) throws java.io.IOException;
    void sendEmailElearningHTML(java.lang.CharSequence title, java.lang.CharSequence to, java.lang.CharSequence username, java.lang.CharSequence content, java.lang.CharSequence type, java.lang.CharSequence lang, org.apache.avro.ipc.Callback<java.lang.Boolean> callback) throws java.io.IOException;
  }
}