package hexlet.code;

import hexlet.code.parsers.Parser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

import static hexlet.code.parsers.ParserFactory.getParser;
import static java.nio.file.Files.readString;
import static java.nio.file.Paths.get;
import static org.apache.commons.io.FilenameUtils.getExtension;

/**
 * Data supplier.
 */
public final class DataSupplier {
    /**
     * getAbsPath.
     * @param filePath String
     * @return Path
     */
    public static Path getAbsolutePath(final String filePath) {
        return get(filePath).toAbsolutePath().normalize();
    }

    /**
     * get.
     * @param filePath Patb
     * @return String file extention
     */
    private static String getDataType(final String filePath) {
        return getExtension(get(filePath).toFile().getName());
    }

    /**
     * get.
     * @param absolutePath Path
     * @return String
     * @throws IOException IO
     */

    public static String readFile(final Path absolutePath) throws IOException {
        return readString(absolutePath);
    }

    /**
     * get.
     * @param filePath String
     * @return Map
     * @throws IOException IO
     */
    public static Map<String, Object> getData(final String filePath)
            throws IOException {
        final Parser parser = getParser(getDataType(filePath));
        return parser.parce(readFile(getAbsolutePath(filePath)));
    }
}
