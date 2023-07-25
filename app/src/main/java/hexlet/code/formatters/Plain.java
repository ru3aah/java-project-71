package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * plain formatter.
 */
public final class Plain {
    /**
     * plain formatter.
     * @param diffMap incoming Map.
     * @return formatted String
     */
    public static String plain(final List<Map<String, Object>> diffMap) {
        StringBuilder result = new StringBuilder();
        for (Map<String, Object> element : diffMap) {
            switch (element.get("status").toString()) {
                case "removed" -> result.append("Property ").append("'")
                        .append(element.get("key")).append("'").append(" was "
                                + "removed").append("\n");
                case "added" -> result.append("Property ").append("'")
                        .append(element.get("key")).append("'")
                        .append(" was added with value: ")
                        .append(complexValue(element.get("newValue")))
                        .append("\n");
                case "changed" -> result.append("Property ")
                        .append(complexValue(element.get("key")))
                        .append(" was changed. From ")
                        .append(complexValue(element.get("oldValue")))
                        .append(" to ").append(complexValue(element.get(
                                "newValue"))).append("\n");
                case "unchanged" -> result.append("");
                default -> {
                    System.out.println("smth wrong with plain");
                    System.exit(1);

                }
            }
        }
        return result.toString().trim();
    }

    /**
     * handle recursive values.
     * @param data incoming data
     * @return String
     */
    private static String complexValue(final Object data) {
        if (data instanceof Object[] || data instanceof Collections
                || data instanceof Map || data instanceof ArrayList<?>) {
            return "[complex value]";
        } else if (data instanceof String) {
            return "'" + data + "'";
        } else if (null == data) {
            return null;
        }
        return data.toString();
    }

    private Plain() {
    }
}
