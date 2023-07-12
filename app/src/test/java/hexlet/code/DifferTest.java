package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

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
            recievedMap1 = Differ.parser(
                    "/Users/papanda"
                            + "/IdeaProjects/java-project-71/app/src/test"
                            + "/resources/testFile1.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(expectedMap1, recievedMap1);
    }

    @Test
    public void testGenerate() {
        String expected = "{\n"
                + "- follow: false\n"
                + "  host: hexlet.io\n"
                + "- proxy: 123.234.53.22\n"
                + "- timeout: 1\n"
                + "+ timeout: 20\n"
                + "+ verbose: true\n"
                + "}";
        String recieved;
        try {
            recieved = Differ.generate("/Users/papanda/IdeaProjects"
                            + "/java-project-71/app/src/test/resources"
                            + "/testFile1.json",
                    "/Users/papanda/IdeaProjects/java-project-71/app"
                            + "/src/test/resources/testFile2.json",
                    "format");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(expected, recieved);
    }
}
