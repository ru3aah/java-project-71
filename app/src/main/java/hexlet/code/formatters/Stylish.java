package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

/**
 * Stylish formatter.
 */
public final class Stylish {
    /**
     * stylish formatter.
     *
     * @param diffMap incoming Map
     * @return formatted String
     */
    public static String stylish(final List<Map<String, Object>> diffMap)
            throws RuntimeException {
        StringBuilder result = new StringBuilder("{\n");
        for (Map<String, Object> element : diffMap) {
            switch (String.valueOf(element.get("status"))) {
                case "removed" -> result.append("  - ").append(element.get(
                                "key"))
                        .append(": ").append(element.get("oldValue")).append(
                                "\n");
                case "added" -> result.append("  + ").append(element.get("key"))
                        .append(": ").append(element.get("newValue")).append(
                                "\n");
                case "unchanged" -> result.append("    ").append(element.get(
                                "key"))
                        .append(": ").append(element.get("oldValue")).append(
                                "\n");
                case "changed" -> {
                    result.append("  - ").append(element.get("key")).append(
                            ": ").append(element.get("oldValue")).append("\n");
                    result.append("  + ").append(element.get("key")).append(
                            ": ").append(element.get("newValue")).append("\n");
                }
                default -> throw new RuntimeException("Unknown status "
                        + element.get("status"));

            }
        }
        result.append("}");
        return result.toString();
    }
}
