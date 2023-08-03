package hexlet.code;

import java.util.List;
import java.util.Map;

import static hexlet.code.DataSupplier.getData;
import static hexlet.code.DiffBuilder.build;
import static hexlet.code.Formatter.format;

/**
 * class Differ.
 */
public final class Differ {
    private Differ() {
    }

    /**
     * generate.
     * @param filepath1 filepath1
     * @param filepath2 filepath2
     * @return String
     * @throws Exception Exception
     */
    public static String generate(final String filepath1,
                                  final String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    /**
     * generate differense.
     * @param filepath1 String
     * @param filepath2 String
     * @param format String
     * @return String
     * @throws Exception Exception
     */
    public static String generate(final String filepath1,
                                  final String filepath2,
                                  final String format)
            throws Exception {
        Map<String, Object> data1 = getData(filepath1);
        Map<String, Object> data2 = getData(filepath2);
        final List<Map<String, Object>> diff = build(data1, data2);
        return format(diff, format);
    }
}
