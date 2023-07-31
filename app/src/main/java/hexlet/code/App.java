package hexlet.code;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

import static java.lang.System.exit;

@Command(name = "gendiff",
        mixinStandardHelpOptions = true, version = "1.0",
        description = "Compares 2 configuration files and shows a difference.",
        showDefaultValues = true)
class App implements Callable<Integer> {
    /**
     * javadoc.
     */
    private static final int SUCCESS_EXIT_CODE = 0;
    /**
     * one more java doc.
     */
    private static final int FAIL_EXIT_CODE = 1;

    /**
     * filepath1, filepath2 - files for matching
     * optinal format - yet've no idea what it might be.
     */
    @Parameters(index = "0", paramLabel = "filepath1",
            description = "path to the first file")
    private String filepath1;

    /**
     * filepath1, filepath2 - files for matching
     * optinal format - yet've no idea what it might be.
     */
    @Parameters(index = "1", paramLabel = "filepath2",
            description = "path to the second file")
    private String filepath2;
    /**
     * filepath1, filepath2 - files for matching
     * optinal format - yet've no idea what it might be.
     */
    @Option(names = {"-f", "--format"},
            paramLabel = "format",
            description = "output format: stylish, plain, json, "
                    + "no-format [default: ${DEFAULT-VALUE}]",
            defaultValue = "stylish")
    private String format = "stylish";

    App() {
    }

    public static void main(final String[] args) {
        int exitCode = new picocli.CommandLine(new App()).execute(args);
        exit(exitCode);
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     */
    @Override
    public Integer call() {

        try {
            System.out.println(Differ.generate(filepath1, filepath2, format));
            return SUCCESS_EXIT_CODE;
        } catch (Exception e) {
            System.out.println("Something went wrong");
            return FAIL_EXIT_CODE;
        }
    }
}
