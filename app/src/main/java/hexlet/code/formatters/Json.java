package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Json formatter.
 */
public class Json {
    /**
     * formatter for Json.
     * @param diffMap incoming Map
     * @return String in Json
     * @throws IOException shit happens
     */
    public static String json(final List<Map<String, Object>> diffMap)
            throws IOException {
        ObjectMapper formattedDiffMap  = new ObjectMapper();
        return formattedDiffMap.writerWithDefaultPrettyPrinter()
                .writeValueAsString(diffMap);
    }
}
