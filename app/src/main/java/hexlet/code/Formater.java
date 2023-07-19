package hexlet.code;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Formater {
    static String format(final List<Map<String, Object>> diffMap,
                                 final String formatName) throws IOException {
        switch (formatName) {
            default : return stylish(diffMap);
        }
    }
    static String stylish(final List<Map<String, Object>> diffMap) {
        StringBuilder result = new StringBuilder("{\n");
        for (Map<String, Object> element : diffMap) {
            switch (element.get("status").toString()) {
                case "-" -> result.append("  - ").append(element.get("key"))
                        .append(": ").append(element.get("oldValue")).append(
                                "\n");
                case "+" -> result.append("  + ").append(element.get("key"))
                        .append(": ").append(element.get("newValue")).append(
                                "\n");
                case " " -> result.append("    ").append(element.get("key"))
                        .append(": ").append(element.get("oldValue")).append(
                                "\n");
                default -> {
                    result.append("  - ").append(element.get("key")).append(
                            ": ").append(element.get("oldValue")).append("\n");
                    result.append("  + ").append(element.get("key")).append(
                            ": ").append(element.get("newValue")).append("\n");
                }
            }
        }
        result.append("}");
        return result.toString();
    }
}
