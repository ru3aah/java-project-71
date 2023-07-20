package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Formatter {
    static String format(final List<Map<String, Object>> diffMap,
                                 final String formatName) throws IOException {
        switch (formatName) {
            case "stylish": return Stylish.stylish(diffMap);
            case "plain": return Plain.plain(diffMap);
            default : return Stylish.stylish(diffMap);
        }
    }
}
