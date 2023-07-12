package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public final class Differ {

    private Differ() {
        throw new UnsupportedOperationException(
                "This is a utility class and cannot be instantiated");
    }

    static Map<String, Object> parser(final String filepath)
            throws IOException {
        final Map map = new ObjectMapper()
                .readValue(Paths.get(filepath).toFile(), Map.class);
        return map;
    }

    static String generate(final String filepath1,
                                  final String filepath2,
                                  final String format)
            throws Exception {
        Map<String, Object> json1 = parser(filepath1);
        Map<String, Object> json2 = parser(filepath2);
        SortedSet<String> keySet = new TreeSet<>();
        json1.forEach((key, value) -> keySet.add(key));
        json2.forEach((key, value) -> keySet.add(key));
        StringBuilder resultList = new StringBuilder();
        resultList.append("{\n");
        for (String key : keySet) {
            StringBuilder result = new StringBuilder();
            if (json1.containsKey(key) && json2.containsKey(key)) {
                if (json1.get(key).equals(json2.get(key))) {
                    result
                            .append("  ")
                            .append(key)
                            .append(": ")
                            .append(json1.get(key));
                    resultList
                            .append(result)
                            .append("\n");
                } else {
                    result
                            .append("- ")
                            .append(key)
                            .append(": ")
                            .append(json1.get(key));
                    resultList
                            .append(result)
                            .append("\n");
                    result = new StringBuilder();
                    result
                            .append("+ ")
                            .append(key)
                            .append(": ")
                            .append(json2.get(key));
                    resultList
                            .append(result)
                            .append("\n");
                }
            } else if (json1.containsKey(key) && !json2
                    .containsKey(key)) {
                result
                        .append("- ")
                        .append(key)
                        .append(": ")
                        .append(json1.get(key));
                resultList
                        .append(result)
                        .append("\n");
            } else if (!json1.containsKey(key) && json2
                    .containsKey(key)) {
                result
                        .append("+ ")
                        .append(key)
                        .append(": ")
                        .append(json2.get(key));
                resultList
                        .append(result)
                        .append("\n");
            }
        }
        return resultList.append("}").toString();
    }
}
