import org.example.ConfProperties;
import org.example.LoginPage;
import org.example.ProfilePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;

    @BeforeAll
    public static void setup() {
        loginPage = new LoginPage("https://ok.ru/");
        profilePage = new ProfilePage();
    }

    @Test
    public void loginTest() {
        loginPage.inputLogin(ConfProperties.getProperty("email"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        String user = profilePage.getUserName();
        String expected = ConfProperties.getProperty("login");
        Assertions.assertEquals(expected, user);
    }

    //Mather exercise
    @Test
    public void checkItemsQuantity() {
        loginPage.inputLogin("botS23AT1");
        loginPage.inputPasswd("autotests2023");
        loginPage.clickLoginBtn();
        assertThat(ProfilePage.getSideElements().size(), equalTo(9));
    }

    @AfterAll
    public static void tearDown() {
        profilePage.expandUserMenu();
        profilePage.userLogout();
    }
}