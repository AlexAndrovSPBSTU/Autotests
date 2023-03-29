import com.codeborne.selenide.Selenide;
import org.example.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UploadFileTest {
    public static ActionsPage actionsPage;
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static MyPhotosPage myPhotosPage;

    @BeforeAll
    public static void setup() {
        loginPage = new LoginPage(ConfProperties.getProperty("url"));
        loginPage.inputLogin(ConfProperties.getProperty("email"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        profilePage = new ProfilePage();
    }

    @Test
    public void uploadFileTest() {
        myPhotosPage = profilePage.getMyPhotosPage();
        int photosNumberBefore = myPhotosPage.getPhotosCount();
        Selenide.back();
        actionsPage = profilePage.getActionsPage();
        actionsPage.uploadFile("src/main/resources/kitten.jpeg");
        actionsPage.closeWindowForUpload();
        myPhotosPage = profilePage.getMyPhotosPage();
        int photosNumberAfter = myPhotosPage.getPhotosCount();
        Assertions.assertEquals(photosNumberBefore + 1, photosNumberAfter);
    }

    @AfterAll
    public static void tearDown() {
        profilePage.expandUserMenu();
        profilePage.userLogout();
    }
}
