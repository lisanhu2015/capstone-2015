package org.lsh.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by lsh on 15/3/4.
 */
public class HelperFunctions {

    /**
     * Convert a POJO to JSON using Jackson libs
     * @param object    The POJO to be converted
     * @return  null if failed to convert, otherwise the result
     */
    public static String ObjectToJsonString(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        String result = null;
        try {
            result = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
//            e.printStackTrace();
        }
        return result;
    }
}
