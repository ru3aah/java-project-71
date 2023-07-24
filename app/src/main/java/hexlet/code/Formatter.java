package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.Json;

import java.io.IOException;
import java.util.List;
import java.util.Map;

class Formatter {
    public static String format(final List<Map<String, Object>> diffMap,
                                final String formatName) throws IOException {
        switch (formatName) {
            case "stylish":
                return Stylish.stylish(diffMap);
            case "plain":
                return Plain.plain(diffMap);
            case "json": return Json.json(diffMap);
            default: System.out.println("Weird format has been requested.");
        }
        return Stylish.stylish(diffMap);
    }
}
