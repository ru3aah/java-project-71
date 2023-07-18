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
    public void testGenerate() {
        System.out.println("Test generate");
        final String relatieTestPath = "src/test/resources/";
        final String expectedPath = relatieTestPath + "testFileExpected.txt";
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
            //System.out.println("expected\n" + expected);
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
}
