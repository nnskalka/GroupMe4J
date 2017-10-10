package org.skalka.groupme4j.internal.requestor;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OkHttpRequestor implements HttpRequestor {

    private final static Logger LOGGER = LoggerFactory.getLogger(OkHttpRequestor.class);

    private final OkHttpClient client = new OkHttpClient();

    @Override
    public String get(String url, Map<String, Object> queries) {
        String query = "";
        if (queries != null) {
            final List<String> pairedQueries = new LinkedList<String>();

            queries.forEach((String key, Object value) -> {
                pairedQueries.add(key + "=" + value.toString());
            });

            query = pairedQueries.stream().collect(Collectors.joining("&"));
        }

        HttpUrl uri = HttpUrl.parse(url).newBuilder().query(query).build();
        Request request = (new Request.Builder()).url(uri).build();
        
        LOGGER.debug("Connecting to: '{}'", request.url().toString());
        return executeRequest(request);
    }

    @Override
    public String post(String url, Map<String, Object> headers, String body) {
        RequestBody postBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), body);
        HttpUrl uri = HttpUrl.parse(url).newBuilder().build();

        Request.Builder builder = new Request.Builder().url(uri).post(postBody);

        if (headers != null) {
            headers.forEach((String key, Object value) -> {
                builder.addHeader(key, value.toString());
            });
        }

        Request request = builder.build();
        
        LOGGER.debug("Connecting to: '{}'; With body: '{}'", request.url().toString(), body);
        return executeRequest(request);
    }

    private String executeRequest(Request request) {
        String response = null;

        try {
            response = client.newCall(request).execute().body().string();
        } catch (Exception E) {
            LOGGER.error(E.toString());
        }

        return response;
    }

}
