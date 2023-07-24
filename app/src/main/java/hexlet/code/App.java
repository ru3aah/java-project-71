package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "1.0",
        description = "Compares two configuration "
                + "files and shows a difference.",
        showDefaultValues = true)
class App implements Callable<Integer> {
    /**
     * filepath1, filepath2 - files for matching
     * optinal format - yet've no idea what it might be.
     */
    @Parameters (index = "0", paramLabel = "filepath1",
            description = "path to the first file")
    private String filepath1;
    /**
     * filepath1, filepath2 - files for matching
     * optinal format - yet've no idea what it might be.
     */
    @Parameters (index = "1", paramLabel = "filepath2",
            description = "path to the second file")
    private String filepath2;
    /**
     * filepath1, filepath2 - files for matching
     * optinal format - yet've no idea what it might be.
     */
    @Option (names = {"-f", "--format"},
            paramLabel = "format",
            description = "output format: stylish, plain, json, "
                    + "no-format [default: ${DEFAULT-VALUE}]",
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
        //System.out.println("----> FORMAT IS: " + format);
        try {
            System.out.println(Differ.generate(filepath1, filepath2, format));
            return 0;
        } catch (Exception e) {
            System.out.println("Something went wrong");
            return 1;
        }
    }
}
