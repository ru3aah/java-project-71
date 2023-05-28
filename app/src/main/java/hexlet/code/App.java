package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "1.0",
        description = "Compares two configuration files and shows a difference.", showDefaultValues = true)

class App implements Callable<Integer> {
    @Parameters(index = "0", paramLabel = "filepath1", description = "path to the first file")
    private String filepath1;
    @Parameters(index = "1", paramLabel = "filepath2", description = "path to the second file")
    private String filepath2;
    @CommandLine.Option(names = {"-f", "--format"}, paramLabel = "format", description = "output format",
            defaultValue = "stylish")
    private String format;


    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        System.out.println("Hello world");
        Map<String, String> json1 = readJsonFile(filepath1);
        Map<String, String> json2 = readJsonFile(filepath2);
        return null;
    }

    public static Map<String, String> readJsonFile(String filepath) throws IOException {
        return new ObjectMapper().readValue(Paths.get(filepath).toFile(), Map.class);
    }
}