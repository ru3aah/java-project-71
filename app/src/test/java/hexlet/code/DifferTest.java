package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;
//import static java.nio.file.Files.writeString;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {
    @Test
    public void testGeneratePlain() {
        System.out.println("Test generate plain");
        final String relatieTestPath = "src/test/resources/";
        final String expectedPath = relatieTestPath + "testFileExpectedPlain"
                + ".txt";
        Path absoluteTestPath =
                Paths.get(relatieTestPath).toAbsolutePath().normalize();
        String expected;
        try {
            try (Stream<String> stream =
                         lines(Paths.get(expectedPath).toAbsolutePath()
                                 .normalize())) {
                expected = stream.collect(Collectors
                        .joining(System.lineSeparator()));
            }
            /*expected = lines(Paths.get(expectedPath)
                    .toAbsolutePath().normalize())
                    .collect(Collectors.joining(System.lineSeparator()));
            */
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String recieved;
        try {
            recieved = Differ.generate(absoluteTestPath
                            .toString() + "/testFile1.json",
                    absoluteTestPath.toString() + "/testFile2.json",
                    "stylish");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(expected, recieved);
    }

    @Test
    public void testGenerateRecursive() {
        System.out.println("Test generate recursive");
        final String relatieTestPath = "src/test/resources/";
        final String expectedPath = relatieTestPath
                + "testFileExpectedRecursive" + ".txt";
        Path absoluteTestPath =
                Paths.get(relatieTestPath).toAbsolutePath().normalize();
        String expected;
        try {
            try (Stream<String> stream =
                         lines(Paths.get(expectedPath).toAbsolutePath()
                                 .normalize())) {
                expected = stream.collect(Collectors
                        .joining(System.lineSeparator()));
            }
            /*expected = lines(Paths.get(expectedPath)
                    .toAbsolutePath().normalize())
                    .collect(Collectors.joining(System.lineSeparator()));
            */
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String recieved;
        try {
            recieved = Differ.generate(absoluteTestPath
                            .toString() + "/testFile3.json",
                    absoluteTestPath.toString() + "/testFile4.json",
                    "stylish");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(expected, recieved);
    }
}
