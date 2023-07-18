package hexlet.code;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParserTest extends Assertions {
    /**
     * expectedMap.
     */
    private final Map<String, Object> expectedMap1 = new TreeMap<>();
    /**
     * recievedMap.
     */
    private Map<String, Object> recievedMap1 = new TreeMap<>();

    /**
     * fill expectedMap with data.
     */
    @BeforeAll
    public void initExpectedMap() {
        expectedMap1.put("host", "hexlet.io");
        expectedMap1.put("timeout", 1);
        expectedMap1.put("proxy", "123.234.53.22");
        expectedMap1.put("follow", false);
    }
    /**
     * clear recievedMap from previouse test.
     */
    @BeforeEach
    public void initrecievedMap() {
        recievedMap1.clear();
    }

    /**
     * clean all test data.
     */
    @AfterAll
    public void wasteTestData() {
        expectedMap1.clear();
        recievedMap1.clear();
    }
    /**
     * test for Json file parsing.
     */
    @Test
    public void testParserJson() {
        try {
            recievedMap1 = Parser.parser(
                    "src/test"
                            + "/resources/testFile1.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(expectedMap1, recievedMap1);
    }
    /**
     * test for yaml file parsing.
     */
    @Test
    public void testParserYaml() {
        try {
            recievedMap1 = Parser.parser(
                    "src/test"
                            + "/resources/testFile1.yml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(expectedMap1, recievedMap1);
    }
}
