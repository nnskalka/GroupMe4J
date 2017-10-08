package org.skalka.groupme4j.internal.request;

public final class HttpRequestorFactory {
    
    public static HttpRequestor getDefaultRequestor() {
        return new OkHttpRequestor();
    }
    
}
