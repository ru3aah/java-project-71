package hexlet.code;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * test.
 */

public class DifferTest {
    /**
     * recursive json file1.
     */
    private final String recursiveJson1 = "src/test/resources/testFile3.json";
    /**
     * recursive json file2.
     */
    private final String recursiveJson2 = "src/test/resources/testFile4.json";
    /**
     * recursive yml file1.
     */
    private final String recursiveYml1 = "src/test/resources/testFile3.yml";
    /**
     * recursive yml file2.
     */
    private final String recursiveYml2 = "src/test/resources/testFile4.yml";
    /**
     * expected result for two recursive jsons formatted Stylish.
     */
    private final Path testExpectedStylish = Paths
            .get("src/test/resources/testExpectedStylish.txt")
            .toAbsolutePath().normalize();
    /**
     * expected result for two recursive jsons formatted Plain.
     */
    private final Path testExpectedPlain = Paths
            .get("src/test/resources/testExpectedPlain.txt")
            .toAbsolutePath().normalize();
    /**
     * expected result for two recursive jsons formatted Json.
     */
    private final Path testExpectedJson = Paths
            .get("src/test/resources/testExpectedJson.txt")
            .toAbsolutePath().normalize();

    /**
     * expected result for two recursive jsons formatted Json.
     */

    DifferTest() throws IOException {
    }

    /**
     * test for 2 recursive json @ stylish.
     * @throws Exception exception
     */
    @Test
    @DisplayName("Test generate() for 2 json @stylish format")
    public void testJsonStylish() throws Exception {
        final String format = "stylish";
        String expected = Files.readString(testExpectedStylish);
        String generated = Differ.generate(recursiveJson1,
                recursiveJson2, format);
        assertEquals(expected, generated);
    }

    /**
     * test for 2 json @ plain.
     * @throws Exception exception
     */
    @Test
    @DisplayName("Test generate() for 2 json @plain format")
    public void testJsonPlain() throws Exception {
        final String format = "plain";
        String expected = Files.readString(testExpectedPlain);
        String generated = Differ
                .generate(recursiveJson1, recursiveJson2, format);
        assertEquals(expected, generated);
    }

    /**
     * test for 2 json @ json.
     * @throws Exception exception
     */
    @Test
    @DisplayName("Test generate() for 2 json @json format")
    public void testJsonJson() throws Exception {
        final String format = "json";
        String expected = Files.readString(testExpectedJson);
        String generated = Differ
                .generate(recursiveJson1, recursiveJson2, format);
        assertEquals(expected, generated);
    }

    /**
     * test for 2 yml @ stylish.
     * @throws Exception exception
     */
    @Test
    @DisplayName("Test generate() for 2 yml @stylish format")
    public void testYmlStylish() throws Exception {
        final String format = "stylish";
        String expected = Files.readString(testExpectedStylish);
        String generated = Differ.generate(recursiveYml1, recursiveYml2,
                format);
        assertEquals(expected, generated);
    }

    /**
     * test for 2 yml @ plain.
     * @throws Exception exception
     */
    @Test
    @DisplayName("Test generate() for 2 yml @plain format")
    public void testYmlPlain() throws Exception {
        final String format = "plain";
        String expected = Files.readString(testExpectedPlain);
        String generated = Differ
                .generate(recursiveYml1, recursiveYml2, format);
        assertEquals(expected, generated);
    }

    /**
     * test for 2 yml @ json.
     * @throws Exception exception
     */
    @Test
    @DisplayName("Test generate() for 2 yml @json format")
    public void testYmlJson() throws Exception {
        final String format = "json";
        String expected = Files.readString(testExpectedJson);
        String generated = Differ
                .generate(recursiveYml1, recursiveYml2, format);
        assertEquals(expected, generated);
    }
}
