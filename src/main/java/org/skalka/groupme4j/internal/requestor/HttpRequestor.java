package org.skalka.groupme4j.internal.requestor;

import java.util.Map;

public interface HttpRequestor {
  
  public String get(String url, Map<String, Object> queries);
  
  public String post(String url, Map<String, Object> headers, String body);
  
}
