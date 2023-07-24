package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * test.
 */

public class DifferTest {
    /**
     * plain json file1.
     */
    private final String plainJson1 = "src/test/resources/testFile1.json";
    /**
     * plain json file2.
     */
    private final String plainJson2 = "src/test/resources/testFile2.json";
    /**
     * plain yaml file1.
     */
    private final String plainYml1 = "src/test/resources/testFile1.yml";
    /**
     * plain yaml file2.
     */
    private final String plainYml2 = "src/test/resources/testFile2.yml";
    /**
     * recursive json file1.
     */
    private final String recursiveJson1 = "src/test/resources/testFile3.json";
    /**
     * recursive json file2.
     */
    private final String recursiveJson2 = "src/test/resources/testFile4.json";
    /**
     * expected result for two plain jsons with default format [stylish].
     */
    private final Path testExpectedPlain = Paths
            .get("src/test/resources/testFileExpectedPlain.txt")
            .toAbsolutePath().normalize();
    /**
     * expected result for two recursive jsons formatted Stylish.
     */
    private final Path testExpectedRecursive = Paths
            .get("src/test/resources/testExpectedStylish.txt")
            .toAbsolutePath().normalize();
    /**
     * expected result for two recursive jsons formatted Plain.
     */
    private final Path testFormatPlain = Paths
            .get("src/test/resources/testExpectedPlainFormat.txt")
            .toAbsolutePath().normalize();
    /**
     * expected result for two recursive jsons formatted Json.
     */
    private final Path testFormatJson = Paths
            .get("src/test/resources/testExpectedJson.txt")
            .toAbsolutePath().normalize();

    /**
     * expected result for two recursive jsons formatted Json.
     */

    DifferTest() throws IOException {
    }

    /**
     * test.
     * @throws Exception exception
     */

    @Test
    public void testGeneratePlainJson() throws Exception {
        System.out.println("Test generate for plain json");
        final String expected = Files.readString(testExpectedPlain);
        final String format = "stylish";
        Assertions.assertEquals(expected, Differ.generate(plainJson1,
                plainJson2, format));
    }

    /**
     * test.
     * @throws Exception exception
     */
    @Test
    public void testGeneratePlainYml() throws Exception {
        System.out.println("Test generate for plain yaml");
        final String expected = Files.readString(testExpectedPlain);
        final String format = "stylish";
        Assertions.assertEquals(expected, Differ
                .generate(plainYml1, plainYml2, format));
    }

    /**
     * test.
     * @throws Exception exception
     */
    @Test
    public void testStylishFormatter() throws Exception {
        System.out.println("Test generate for stylish format");
        final String expected = Files.readString(testExpectedRecursive);
        final String format = "stylish";
        Assertions.assertEquals(expected, Differ
                .generate(recursiveJson1, recursiveJson2, format));
    }
    /**
     * test.
     * @throws Exception exception
     */
    @Test
    public void testPlainFormat() throws Exception {
        System.out.println("Test generate for plain format");
        final String expected = Files.readString(testFormatPlain);
        final String format = "plain";
        Assertions.assertEquals(expected, Differ
                .generate(recursiveJson1,
                        recursiveJson2, format));
    }

    /**
     * test.
     * @throws Exception exception
     */
    @Test
    public void testJsonFormat() throws Exception {
        System.out.println("Test generate for json format");

        String expected = Files.readString(testFormatJson);
        final String format = "json";
        Assertions.assertEquals(expected, Differ
                .generate(recursiveJson1, recursiveJson2, format));
    }

    @Test
    void generate() {
    }
}
