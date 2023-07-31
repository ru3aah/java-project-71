package hexlet.code;

import static hexlet.code.DataSupplier.getData;

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

        return hexlet.code.Formatter
                .format(hexlet.code.DiffBuilder
                                .build(getData(filepath1),
                                        getData(filepath2)),
                        format);
    }
}
