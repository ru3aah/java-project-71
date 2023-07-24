package hexlet.code;

import java.io.IOException;
import java.util.Map;


public class Differ {
    /**
     * generate differense.
     * @param filepath1 String
     * @param filepath2 Streing
     * @param format String
     * @return String
     */
    public static String generate(final String filepath1,
                                  final String filepath2,
                                  final String format) throws IOException {
        Map<String, Object> fileData1 = Parser.parser(filepath1);
        Map<String, Object> fileData2 = Parser.parser(filepath2);

        try {
            return Formatter.format(DiffBuilder.build(fileData1, fileData2),
                    format);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
