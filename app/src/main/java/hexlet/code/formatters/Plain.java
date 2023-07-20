package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * plain formatter.
 */
public class Plain {

    /**
     * plain formatter.
     * @param diffMap incoming Map.
     * @return formatted String
     */
    public static String plain(final List<Map<String, Object>> diffMap) {
        StringBuilder result = new StringBuilder();
        for (Map<String, Object> element : diffMap) {
            switch (element.get("status").toString()) {
                case "-" -> result.append("Property ").append("'")
                        .append(element.get("key")).append("'").append(" was "
                                + "removed").append("\n");
                case "+" -> result.append("Property ").append("'")
                        .append(element.get("key")).append("'")
                        .append(" was added with value: ")
                        .append(complexValue(element.get("newValue")))
                        .append("\n");
                case "*" -> result.append("Property ")
                        .append(complexValue(element.get("key")))
                        .append(" was updated. From ")
                        .append(complexValue(element.get("oldValue")))
                        .append(" to ").append(complexValue(element.get(
                                "newValue"))).append("\n");
                default -> result.append(" ");
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
        } else if (data == null) {
            return null;
        }
        return data.toString();
        }
    }
