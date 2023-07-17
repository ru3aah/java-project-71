package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.nio.file.Files.lines;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @Test
    public void testParser() {
        Map<String, Object> expectedMap1 = new TreeMap<>();
        expectedMap1.put("host", "hexlet.io");
        expectedMap1.put("timeout", 1);
        expectedMap1.put("proxy", "123.234.53.22");
        expectedMap1.put("follow", false);
        Map<String, Object> recievedMap1;
        try {
            recievedMap1 = Parser.parser(
                    "src/test"
                            + "/resources/testFile1.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(expectedMap1, recievedMap1);
    }

    @Test
    public void testGenerate() {
        final String relatieTestPath = "src/test/resources/";
        final String expectedPath = relatieTestPath + "testFileExpected.txt";
        Path absoluteTestPath =
                Paths.get(relatieTestPath).toAbsolutePath().normalize();
        String expected;
        try {
            expected = lines(Paths.get(expectedPath)
                    .toAbsolutePath().normalize())
                    .collect(Collectors.joining(System.lineSeparator()));
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
