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
                case "removed" -> result.append(String
                        .format("Property '%s' was removed%n",
                                element.get("key")));
                case "added" -> result.append(String
                        .format("Property '%1$s' was added with value: %2$s%n",
                                element.get("key"),
                                complexValue(element.get("newValue"))));
                case "changed" -> result
                        .append(String.format(
                                "Property %1$s was changed. From %2$s to "
                                        + "%3$s%n",
                                complexValue(element.get("key")),
                                complexValue(element.get("oldValue")),
                                complexValue(element.get("newValue"))));

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
        } else {
            return String.valueOf(data);
        }
    }

    private Plain() {
    }
}
