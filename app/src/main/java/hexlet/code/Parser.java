package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static java.nio.file.Files.readString;

public class Parser {
    static String getExtention(final Path filepath) {
        return FilenameUtils.getExtension(filepath.toFile().getName());
    }
    static Map<String, Object> parser(final String filepath)
            throws IOException {
        //System.out.println("incoming filepath " + filepath);
        Path absolutePath = Paths.get(filepath).toAbsolutePath().normalize();
        //System.out.println("Absolute filePath " + absolutePath);
        Map<String, Object> map = null;
        System.out.println("Let's see what is " + absolutePath);
        System.out.println(getExtention(absolutePath));
       if (getExtention(absolutePath).equals("json")) {
           try {
               System.out.println("json file've been found");
               map = jsonToMap(absolutePath);
           } catch (Exception e) {
               throw new RuntimeException(e);
           }
       } else if (getExtention(absolutePath).equals("yml")) {
           try {
               System.out.println("yaml file've been found");
               map = yamlToMap(absolutePath);
           } catch (Exception e) {
               throw new RuntimeException(e);
           }
       } else {
           System.out.println("Can't detect what is that shit");
       }
        return map;
    }

    static Map<String, Object> jsonToMap(final Path filepath)
            throws Exception {
        ObjectMapper map = new ObjectMapper();
        return map.readValue(readString(filepath),
                new TypeReference<>() { });
    }

    static Map<String, Object> yamlToMap(final Path filepath)
            throws Exception {
        ObjectMapper map = new YAMLMapper();
        return map.readValue(readString(filepath),
                new TypeReference<>() { });
    }


}
