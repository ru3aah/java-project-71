package hexlet.code;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

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
     * inString.
     */
    private String inString1;
    /**
     * inString.
     */
    private String inString2;
    /**
     * inString.
     */
    private String inString3;
    /**
     * inString.
     */
    private String inString4;

    /**
     * parcer test.
     * @throws IOException
     */

    public ParserTest() throws IOException {
    }

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
     * fills inString.
     * @throws IOException
     */

    @BeforeAll
    public void initInString() throws IOException {
        inString1 = DataSupplier.readFile(DataSupplier.getAbsolutePath(
                "src/test/resources/testFile1.json"));
        inString2 = DataSupplier.readFile((DataSupplier.getAbsolutePath(
                "src/test/resources/testFile1.yml")));
        inString3 = DataSupplier.readFile((DataSupplier.getAbsolutePath(
                "src/test/resources/testEmpty.yml")));
        inString4 = DataSupplier.readFile((DataSupplier.getAbsolutePath(
                "src/test/resources/testEmpty.json")));
    }

    /**
     * clear recievedMap from previouse test.
     */
    @BeforeEach
    public void initRecievedMap() {
        recievedMap1.clear();
    }

    /**
     * clean all test data.
     */
    @AfterAll
    public void wasteTestData() {
        expectedMap1.clear();
    }

    /**
     * test for Json file parsing.
     */
    @Test
    public void testJson() {
        System.out.println("test Json parsing");
        try {
            recievedMap1 = Parser.parceIt(
                    inString1, "json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(expectedMap1, recievedMap1);
    }

    /**
     * test for yaml file parsing.
     */
    @Test
    public void testYaml() {
        System.out.println("test Yaml parsing");
        try {
            recievedMap1 = Parser.parceIt(
                    inString2, "yml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(expectedMap1, recievedMap1);
    }

    /**
     * test for empty Yaml file parsing.
     */
    @Test
    public void testEmptyYaml() {
        System.out.println("test empty Yaml parsing");
        try {
            recievedMap1 = Parser.parceIt(
                    inString3, "yml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(null, recievedMap1);
    }

    /**
     * test for empty Json file parsing.
     */
    @Test
    public void testEmptyJson() {
        System.out.println("test empty Json parsing");
        expectedMap1.clear();
        try {
            recievedMap1 = Parser.parceIt(
                    inString4, "json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(expectedMap1, recievedMap1);
    }
}
