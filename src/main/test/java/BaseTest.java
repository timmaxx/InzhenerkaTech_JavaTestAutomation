import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/selenide.properties"));
            Configuration.browser = properties.getProperty("selenide.browser");
            // Configuration.startMaximized = Boolean.parseBoolean(properties.getProperty("selenide.startMaximized"));
            Configuration.headless = Boolean.parseBoolean(properties.getProperty("selenide.headless"));
            // Configuration.remote = properties.getProperty("selenide.remote");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
