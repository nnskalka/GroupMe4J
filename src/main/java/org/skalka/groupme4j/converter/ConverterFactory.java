package org.skalka.groupme4j.converter;

import java.util.List;
import org.skalka.groupme4j.response.RestfulResponse;

public class ConverterFactory {
    public static <TYPE> ResponseConverter<RestfulResponse<List<TYPE>>> getMERC(Class<TYPE> clazz) {
        return new MultipleEntryResponseConverter<>(clazz);
    }
    
    public static <TYPE> ResponseConverter<RestfulResponse<TYPE>> getSERC(Class<TYPE> clazz) {
        return new SingleEntryResponseConverter<>(clazz);
    }
}
