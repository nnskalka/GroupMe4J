package org.skalka.groupme4j.internal.requestor;

public final class HttpRequestorFactory {
    
    public static HttpRequestor getDefaultRequestor() {
        return new OkHttpRequestor();
    }
    
}
