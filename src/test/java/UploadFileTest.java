import com.codeborne.selenide.Selenide;
import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UploadFileTest extends BaseTest {
    @BeforeAll
    static void setUp() {
        BaseTest.setUp();
        LoginPage loginPage = new LoginPage();
        loginPage.inputLogin(ConfProperties.getProperty("email"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
    }

    @Test
    public void uploadFileTest() {
        Toolbar toolbar = new Toolbar();
        MyPhotosPage myPhotosPage = toolbar.getMyPhotosPage();
        int photosNumberBefore = myPhotosPage.getPhotosCount();
        Selenide.back();
        toolbar = new Toolbar();
        ActionsPage actionsPage = toolbar.getActionsPage();
        actionsPage.uploadFile("src/main/resources/kitten.jpeg");
        actionsPage.closeWindowForUpload();
        toolbar.waitForUploadFile();
        myPhotosPage = toolbar.getMyPhotosPage();
        int photosNumberAfter = myPhotosPage.getPhotosCount();
        Assertions.assertEquals(photosNumberBefore + 1, photosNumberAfter);
    }
}
