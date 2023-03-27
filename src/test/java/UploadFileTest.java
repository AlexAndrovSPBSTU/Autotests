import com.codeborne.selenide.Selenide;
import org.example.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UploadFileTest {
    public static ActionsPage actionsPage;
    public static LoginPage loginPage;
    public static ProfilePage profilePage;

    @BeforeAll
    public static void setup() {
        loginPage = new LoginPage(ConfProperties.getProperty("url"));
        loginPage.inputLogin(ConfProperties.getProperty("email"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        profilePage = new ProfilePage();
        actionsPage = profilePage.getActionsPage();
    }

    @Test
    public void uploadFileTest() {
        actionsPage.uploadFile("src/main/resources/kitten.jpeg");
        // TODO: 28.03.2023  ("check for the right photo upload")
    }

    @AfterAll
    public static void tearDown() {
        profilePage.expandUserMenu();
        profilePage.userLogout();
    }
}
