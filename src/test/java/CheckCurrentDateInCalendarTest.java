import com.codeborne.selenide.Selenide;
import org.example.ConfProperties;
import org.example.LoginPage;
import org.example.MyHolidaysPage;
import org.example.Toolbar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CheckCurrentDateInCalendarTest extends BaseTest {
    @BeforeAll
    static void setUp() {
        BaseTest.setUp();
        LoginPage loginPage = new LoginPage();
        loginPage.inputLogin(ConfProperties.getProperty("email"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
    }

    @Test
    public void checkCurrentDate() {
        Toolbar toolbar = new Toolbar();
        MyHolidaysPage myHolidaysPage = toolbar.getMyHolidaysPage();
        Assertions.assertEquals(myHolidaysPage.getCURRENT_DAY_FIELD(), LocalDate.now().getDayOfMonth());
        Selenide.back();
    }
}
