package hexlet.code.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * Json parser.
 */
public final class JsonParser implements hexlet.code.Parser {
    /**
     * JSON parser.
     * @param data String
     * @return Map
     */
    @Override
    public Map<String, Object> parce(final String data)
            throws JsonProcessingException, JsonMappingException {
        return new ObjectMapper().readValue(data, Map.class);
    }
}
