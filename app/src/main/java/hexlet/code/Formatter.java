package hexlet.code;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static hexlet.code.formatters.Stylish.stylish;

public class Formatter {
    static String format(final List<Map<String, Object>> diffMap,
                                 final String formatName) throws IOException {
        switch (formatName) {
            default : return stylish(diffMap);
        }
    }
}
