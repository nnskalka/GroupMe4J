package org.skalka.groupme4j.converter;

public interface ResponseConverter<E> {
    
    public E parse(String json);
    
}