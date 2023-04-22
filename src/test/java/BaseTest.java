import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.example.ConfProperties;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {
    @BeforeAll
    static void setUp() {
        Selenide.open(ConfProperties.getProperty("url"));
        Configuration.browserSize = "1920x1080";
    }

}
