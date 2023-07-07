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
        Map<String, Object> json1 = parser(filepath1);
        Map<String, Object> json2 = parser(filepath2);
        SortedSet<String> keySet = new TreeSet<>();
        System.out.println();
        System.out.println(json1);
        System.out.println();
        System.out.println(json2);
        System.out.println();
        json1.forEach((key, value) -> keySet.add(key));
        json2.forEach((key, value) -> keySet.add(key));
        System.out.println(keySet);
        System.out.println();
        List<String> resultList = new ArrayList<>();
        for (String key : keySet) {
            StringBuilder result = new StringBuilder();
            if (json1.containsKey(key) && json2.containsKey(key)){
                if (json1.get(key).equals(json2.get(key))){
                    result.append(" ").append(key).append(": ").append(json1.get(key));
                    resultList.add(result.toString());
                } else {
                    result.append("- ").append(key).append(": ").append(json1.get(key));
                    resultList.add(result.toString());
                    result = new StringBuilder();
                    result.append("+ ").append(key).append(": ").append(json2.get(key));
                    resultList.add(result.toString());
                }
            } else if (json1.containsKey(key) && !json2.containsKey(key)) {
                result.append("- ").append(key).append(": ").append(json1.get(key));
                resultList.add(result.toString());
            } else if (!json1.containsKey(key) && json2.containsKey(key)) {
                result.append("+ ").append(key).append(": ").append(json2.get(key));
                resultList.add(result.toString());
            }
        }
        return resultList.toString();
    }
}
