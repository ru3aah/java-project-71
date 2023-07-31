package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

/**
 * Data supplier.
 */
public final class DataSupplier {

    private DataSupplier() {
    }

    /**
     * getAbsPath.
     * @param filePath String
     * @return Path
     */
    public static Path getAbsolutePath(final String filePath) {
        return java.nio.file.Paths.get(filePath).toAbsolutePath().normalize();
    }

    /**
     * get.
     * @param filePath Patb
     * @return String file extention
     */
    private static String getDataType(final String filePath) {
        return org.apache.commons.io.FilenameUtils
                .getExtension(java.nio.file.Paths
                        .get(filePath).toFile().getName());
    }

    /**
     * get.
     * @param absolutePath Path
     * @return String
     * @throws IOException IO
     */

    public static String readFile(final Path absolutePath) throws IOException {
        return Files.readString(absolutePath);
    }

    /**
     * get.
     * @param filePath String
     * @return Map
     * @throws IOException IO
     */
    public static Map<String, Object> getData(final String filePath)
            throws IOException {
        final Parser parser = new ParserFactory()
                .getParser(getDataType(filePath));
        return parser.parceIt(readFile(getAbsolutePath(filePath)));
    }
}
