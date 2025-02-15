package properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    private static Properties PROPERTIES;
    private static final Logger logger = LoggerFactory.getLogger(TestProperties.class);

    static {
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/test.properties")) {
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            logger.error("Unable to read properties", e);
        }
    }

    public static String getProperty(String key) {
        return (String) PROPERTIES.getOrDefault(key, "");
    }
}
