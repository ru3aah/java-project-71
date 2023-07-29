package hexlet.code;

import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

final class DataSupplier {

    private DataSupplier() {
    }

    /**
     * getAbsPath.
     * @param filePath String
     * @return Path
     */
    static Path getAbsolutePath(final String filePath) {
        return Paths.get(filePath).toAbsolutePath().normalize();
    }

    /**
     * get.
     * @param absolutePath Patb
     * @return String file extention
     */
    static String getDataType(final Path absolutePath) {
        return FilenameUtils.getExtension(absolutePath.toFile().getName());
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
                getDataType(getAbsolutePath(filePath)));
    }
}
