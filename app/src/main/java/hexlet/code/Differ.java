package hexlet.code;

import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public final class Differ {

    private Differ() {
        throw new UnsupportedOperationException(
                "This is a utility class and cannot be instantiated");
    }

    static String generate(final String filepath1,
                                  final String filepath2,
                                  final String format)
            throws Exception {
        Map<String, Object> file1 = Parser.parser(filepath1);
        Map<String, Object> file2 = Parser.parser(filepath2);
        //System.out.println(file1 + "\n");
        //System.out.println(file2 + "\n");
        SortedSet<String> keySet = new TreeSet<>();
        file1.forEach((key, value) -> keySet.add(key));
        file2.forEach((key, value) -> keySet.add(key));
        StringBuilder resultList = new StringBuilder();
        resultList.append("{\n");
        for (String key : keySet) {
            StringBuilder result = new StringBuilder();
            if (file1.containsKey(key) && file2.containsKey(key)) {
                if (file1.get(key).equals(file2.get(key))) {
                    result
                            .append("  ")
                            .append(key)
                            .append(": ")
                            .append(file1.get(key));
                    resultList
                            .append(result)
                            .append("\n");
                } else {
                    result
                            .append("- ")
                            .append(key)
                            .append(": ")
                            .append(file1.get(key));
                    resultList
                            .append(result)
                            .append("\n");
                    result = new StringBuilder();
                    result
                            .append("+ ")
                            .append(key)
                            .append(": ")
                            .append(file2.get(key));
                    resultList
                            .append(result)
                            .append("\n");
                }
            } else if (file1.containsKey(key) && !file2
                    .containsKey(key)) {
                result
                        .append("- ")
                        .append(key)
                        .append(": ")
                        .append(file1.get(key));
                resultList
                        .append(result)
                        .append("\n");
            } else if (!file1.containsKey(key) && file2
                    .containsKey(key)) {
                result
                        .append("+ ")
                        .append(key)
                        .append(": ")
                        .append(file2.get(key));
                resultList
                        .append(result)
                        .append("\n");
            }
        }
        return resultList.append("}").toString();
    }
}
