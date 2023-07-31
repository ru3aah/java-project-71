package hexlet.code;

import static hexlet.code.DiffBuilder.build;
import static hexlet.code.Formatter.format;


public final class Differ {
    private Differ() {
    }

    /**
     * generate differense.
     * @param filepath1 String
     * @param filepath2 String
     * @param format String
     * @return String
     */
    public static String generate(final String filepath1,
                                  final String filepath2,
                                  final String format) throws Exception {

        return format(build(getData(filepath1), getData(filepath2)), format);
    }
}
