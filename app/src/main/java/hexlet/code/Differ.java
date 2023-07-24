package hexlet.code;

import java.io.IOException;
import java.util.Map;

import static hexlet.code.DataSupplier.getAbsolutePath;
import static hexlet.code.DataSupplier.readFile;


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
                                  final String format) throws IOException {
        String data1 = readFile(getAbsolutePath(filepath1));
        String data2 = readFile(getAbsolutePath(filepath2));
        String dataType1 = DataSupplier.getDataType(getAbsolutePath(filepath1));
        String dataType2 = DataSupplier.getDataType(getAbsolutePath(filepath2));

        Map<String, Object> fileData1 = Parser.parceIt(data1, dataType1);
        Map<String, Object> fileData2 = Parser.parceIt(data2, dataType2);

        try {
            return Formatter.format(DiffBuilder.build(fileData1, fileData2),
                    format);
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
}
