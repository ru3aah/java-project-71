package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

/**
 * formatter.
 */
public final class Formatter {

    /**
     * format.
     * @param diffMap dif
     * @param formatName String
     * @return return
     * @throws Exception exception
     */
    public static String format(final List<Map<String, Object>> diffMap,
                                final String formatName) throws Exception {
        switch (formatName) {
            case "stylish":
                return Stylish.stylish(diffMap);
            case "plain":
                return Plain.plain(diffMap);
            case "json":
                return Json.json(diffMap);
            default:
                throw new Exception("Weird format has been requested.");
        }
    }
}
