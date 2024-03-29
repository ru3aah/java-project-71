package hexlet.code.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;

/**
 * parse data String to Map.
 */
public interface Parser {
    /**
     * parse data String to Map.
     * @param data String
     * @return Map
     * @throws JsonProcessingException Exceptiom
     */
    Map<String, Object> parce(String data) throws JsonProcessingException;
}

