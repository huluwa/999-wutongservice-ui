/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.borqs.server.service.platform;

@SuppressWarnings("all")
public interface Statistics {
  public static final org.apache.avro.Protocol PROTOCOL = org.apache.avro.Protocol.parse("{\"protocol\":\"Statistics\",\"namespace\":\"com.borqs.server.service.platform\",\"types\":[{\"type\":\"error\",\"name\":\"ResponseError\",\"namespace\":\"com.borqs.server.base\",\"fields\":[{\"name\":\"code\",\"type\":\"int\"},{\"name\":\"message\",\"type\":\"string\"}]}],\"messages\":{\"save\":{\"request\":[{\"name\":\"statistics\",\"type\":\"bytes\"}],\"response\":\"boolean\",\"errors\":[\"com.borqs.server.base.ResponseError\"]}}}");
  boolean save(java.nio.ByteBuffer statistics) throws org.apache.avro.AvroRemoteException, com.borqs.server.base.ResponseError;

  @SuppressWarnings("all")
  public interface Callback extends Statistics {
    public static final org.apache.avro.Protocol PROTOCOL = com.borqs.server.service.platform.Statistics.PROTOCOL;
    void save(java.nio.ByteBuffer statistics, org.apache.avro.ipc.Callback<java.lang.Boolean> callback) throws java.io.IOException;
  }
}