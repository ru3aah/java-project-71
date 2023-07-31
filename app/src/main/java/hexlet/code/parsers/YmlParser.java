package hexlet.code.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import hexlet.code.Parser;

import java.util.Map;

public class YmlParser implements Parser {
    /**
     * YML parser.
     * @param data String
     * @return Map
     * @throws JsonProcessingException
     */

    @Override
    public Map<String, Object> parceIt(final String data)
            throws JsonProcessingException {
        return new YAMLMapper().readValue(data, Map.class);
    }
}


