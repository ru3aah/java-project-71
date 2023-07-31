package hexlet.code.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public final class JsonParser implements hexlet.code.Parser {
    /**
     * JSON parser.
     * @param data String
     * @return Map <String, Object>
     * @throws JsonProcessingException
     */
    @Override
    public Map<String, Object> parceIt(final String data)
            throws JsonProcessingException {
        return new ObjectMapper().readValue(data, Map.class);
    }
}
