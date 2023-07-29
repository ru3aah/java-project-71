package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static java.nio.file.Paths.get;
import static org.apache.commons.io.FilenameUtils.getExtension;

final class DataSupplier {

    private DataSupplier() {
    }

    /**
     * getAbsPath.
     * @param filePath String
     * @return Path
     */
    static Path getAbsolutePath(final String filePath) {
        return get(filePath).toAbsolutePath().normalize();
    }

    /**
     * get.
     * @param filePath Patb
     * @return String file extention
     */
    static String getDataType(final String filePath) {
        return getExtension(get(filePath).toFile().getName());
    }

    /**
     * get.
     * @param absolutePath Path
     * @return String
     * @throws IOException IO
     */

    static String readFile(final Path absolutePath) throws IOException {
        return Files.readString(absolutePath);
    }

    static Map<String, Object> getData(final String filePath)
            throws IOException {
        return Parser.parceIt(Files.readString(getAbsolutePath(filePath)),
                getDataType(filePath));
    }
}
