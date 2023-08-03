package hexlet.code.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * Json parser.
 */
public final class JsonParser implements Parser {
    /**
     * JSON parser.
     * @param data String
     * @return Map
     */
    @Override
    public Map<String, Object> parce(final String data)
            throws JsonProcessingException {
        return new ObjectMapper().readValue(data, Map.class);
    }
}
