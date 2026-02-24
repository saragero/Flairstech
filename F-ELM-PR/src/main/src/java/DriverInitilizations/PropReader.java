package DriverInitilizations;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropReader {

    private static Map<String, Properties> allProperties = new HashMap<>();

    // Load files on startup
    static {
        loadPropertiesFile("platform.properties");
        loadPropertiesFile("env.properties");
    }

    private static void loadPropertiesFile(String fileName) {
        try (InputStream input =
                     PropReader.class
                             .getClassLoader()
                             .getResourceAsStream(fileName)) {

            if (input == null) {
                throw new RuntimeException(fileName + " not found");
            }

            Properties props = new Properties();
            props.load(input);
            allProperties.put(fileName, props);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load " + fileName, e);
        }
    }

    // Read from a specific file
    public static String get(String fileName, String key) {
        Properties props = allProperties.get(fileName);
        if (props == null) {
            throw new RuntimeException(fileName + " not loaded");
        }
        return props.getProperty(key);
    }
}