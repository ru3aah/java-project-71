package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.nio.file.Path;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "1.0",
        description = "Compares two configuration files and shows a difference.", showDefaultValues = true)


class App implements Callable<Integer> {

    @Parameters(index = "0", paramLabel = "filepath1", description = "path to the first file") private Path filepath1;
    @Parameters(index = "1", paramLabel = "filepath1", description = "path to the second file") private Path filepath2;
@CommandLine.Option(names = {"-f", "--format"}, paramLabel = "format", description = "output format", defaultValue = "stylish")
String format;

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
        return null;
    }
}
