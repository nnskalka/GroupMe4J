package org.skalka.groupme4j.converter;

public interface ResponseConverter<T> {
    
    public T parse(String json);
    
}
