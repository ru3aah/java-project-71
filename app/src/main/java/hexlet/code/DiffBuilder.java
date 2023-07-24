package hexlet.code;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public class DiffBuilder {
    public static List<Map<String, Object>> build(
            Map<String, Object> fileData1,
            Map<String, Object> fileData2) {
        ArrayList<Map<String, Object>> resultMap = new ArrayList<>();
        SortedSet<String> keySet = new TreeSet<>(fileData1.keySet());
        keySet.addAll(fileData2.keySet());
        for (String key : keySet) {
            Map<String, Object> resultElement = new LinkedHashMap<>();
            if (fileData1.containsKey(key) && !fileData2.containsKey(key)) {
                resultElement.put("key", key);
                resultElement.put("oldValue", fileData1.get(key));
                resultElement.put("status", "removed");
            } else if (!fileData1.containsKey(key)
                    && fileData2.containsKey(key)) {
                resultElement.put("key", key);
                resultElement.put("newValue", fileData2.get(key));
                resultElement.put("status", "added");
            } else if (!Objects.equals(fileData1.get(key),
                    fileData2.get(key))) {
                resultElement.put("key", key);
                resultElement.put("oldValue", fileData1.get(key));
                resultElement.put("newValue", fileData2.get(key));
                resultElement.put("status", "updated");
            } else {
                resultElement.put("key", key);
                resultElement.put("oldValue", fileData1.get(key));
                resultElement.put("status", "remain same");
            }
            resultMap.add(resultElement);
        }
        return resultMap;
    }
}
