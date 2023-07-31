package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.util.Map;

public final class Parser {
    private Parser() {
    }

    /**
     * choose right parser.
     * @param data String
     * @param dataType DataType enum
     * @return ObjectMapper
     */
    public static Map<String, Object> parceIt(final String data,
                                              final String dataType)
            throws JsonProcessingException {
        ObjectMapper parser = getParser(dataType);
        return parser.readValue(data, new MapTypeReference());
    }

    private static class MapTypeReference extends TypeReference<Map<String,
            Object>> {
    }

    private static ObjectMapper getParser(final String dataType) {
        ObjectMapper parcer = switch (dataType) {
            case "json" -> new ObjectMapper();
            case "yml" -> new ObjectMapper(new YAMLFactory());
            default -> throw new IllegalStateException("Unexpected value: "
                    + dataType);
        };
        return parcer;
    }
}

