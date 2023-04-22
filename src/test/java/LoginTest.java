import org.example.ConfProperties;
import org.example.LoginPage;
import org.example.Toolbar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.inputLogin(ConfProperties.getProperty("email"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        Toolbar toolbar = new Toolbar();
        String user = toolbar.getUserName();
        String expected = ConfProperties.getProperty("login");
        Assertions.assertEquals(expected, user);
    }
}
