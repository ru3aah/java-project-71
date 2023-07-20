package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    /**
     * stylish formatter.
     *
     * @param diffMap incoming Map
     * @return formatted String
     */
    public static String stylish(final List<Map<String, Object>> diffMap) {
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
