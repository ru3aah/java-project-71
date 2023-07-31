package hexlet.code.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import hexlet.code.Parser;

import java.util.Map;

/**
 * YmlParser.
 */
public class YmlParser implements Parser {
    /**
     * YML parser.
     * @param data String
     * @return Map
     */

    @Override
    public Map<String, Object> parceIt(final String data)
            throws JsonProcessingException, JsonMappingException {
        return new YAMLMapper().readValue(data, Map.class);
    }
}


