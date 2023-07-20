package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {
    private final String plainJson1 = "src/test/resources/testFile1.json";
    private final String plainJson2 = "src/test/resources/testFile2.json";
    private final String plainYml1 = "src/test/resources/testFile1.yml";
    private final String plainYml2 = "src/test/resources/testFile2.yml";
    private final String recursiveJson1 = "src/test/resources/testFile3.json";
    private final String recursiveJson2 = "src/test/resources/testFile4.json";
    private final Path testExpectedPlain = Paths
            .get("src/test/resources/testFileExpectedPlain.txt")
            .toAbsolutePath().normalize();
    private final Path testExpectedRecursive = Paths
            .get("src/test/resources/testExpectedStylish.txt")
            .toAbsolutePath().normalize();
    private final Path testFormatPlain = Paths
            .get("src/test/resources/testExpectedPlainFormat.txt")
            .toAbsolutePath().normalize();
    DifferTest() throws IOException {
    }
    @Test
    public void testGeneratePlainJson() throws Exception {
        System.out.println("Test generate for plain json");
        String expected = Files.readString(testExpectedPlain);
        assertEquals(expected, Differ.generate(plainJson1, plainJson2,
                "stylish"));
    }

    @Test
    public void testGeneratePlainYml() throws Exception {
        System.out.println("Test generate for plain yaml");
        String expected = Files.readString(testExpectedPlain);
        assertEquals(expected, Differ
                .generate(plainYml1, plainYml2, "stylish"));
    }
    @Test
    public void testStylishFormatter() throws Exception {
        System.out.println("Test generate for stylish format");
        String expected = Files.readString(testExpectedRecursive);
        assertEquals(expected, Differ
                .generate(recursiveJson1, recursiveJson2, "stylish"));
    }

    @Test
    public void testPlainFormat() throws Exception {
        System.out.println("Test generate for plain format");
        String expected = Files.readString(testFormatPlain);
        assertEquals(expected, Differ
                .generate(recursiveJson1,
                        recursiveJson2, "plain"));
    }
}
