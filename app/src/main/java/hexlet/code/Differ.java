package hexlet.code;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Differ {

    public static class Result {
        String status;
        Map<String, Object> json;

        public Result(String status, Map<String, Object> json) {
            this.status = status;
            this.json = json;
        }

        public Result() {

        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Map<String, Object> getJson() {
            return json;
        }

        public void setJson(Map<String, Object> json) {
            this.json = json;
        }

        public String resultToString() {
            return status + " " + json;
        }
    }

    public static Map<String, Object> parser(String filepath) throws IOException {
        return new ObjectMapper().readValue(Paths.get(filepath).toFile(), Map.class);
    }

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        TreeMap<String, Object> json1 = (TreeMap<String, Object>) parser(filepath1);
        TreeMap<String, Object> json2 = (TreeMap<String, Object>) parser(filepath2);
        SortedSet<String> keySet = new TreeSet<>();
        json1.forEach((key, value) -> keySet.add(key));
        json2.forEach((key, value) -> keySet.add(key));
        List<Result> resultList = new ArrayList<>();
        for (String key : keySet) {
            Result result = new Result();
            if (json1.containsKey(key) && json2.containsKey(key)){
                if (json1.equals(json2)){
                    result.setStatus("  ");
                    result.setJson(json1);
                    resultList.add(result);
                } else {
                    result.setStatus("- ");
                    result.setJson(json1);
                    resultList.add(result);
                    result.setStatus("+ ");
                    result.setJson(json2);
                    resultList.add(result);
                }
            } else if (json1.containsKey(key) && !json2.containsKey(key)) {
                result.setStatus("- ");
                result.setJson(json1);
                resultList.add(result);
            } else if (!json1.containsKey(key) && json2.containsKey(key)) {
                result.setStatus("+ ");
                result.setJson(json2);
                resultList.add(result);
            }
        }
        return resultList.toString();
    }
}
