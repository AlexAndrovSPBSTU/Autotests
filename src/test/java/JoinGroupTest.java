import com.codeborne.selenide.Selenide;
import org.example.ConfProperties;
import org.example.LoginPage;
import org.example.MyGroupsPage;
import org.example.ProfilePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class JoinGroupTest {
    public static MyGroupsPage myGroupsPage;
    public static LoginPage loginPage;
    public static ProfilePage profilePage;

    @BeforeAll
    public static void setup() {
        loginPage = new LoginPage(ConfProperties.getProperty("url"));
        loginPage.inputLogin(ConfProperties.getProperty("email"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        profilePage = new ProfilePage();
        myGroupsPage = profilePage.getMyGroupsPage();
    }

    @Test
    public void joinGroupTest() {
        myGroupsPage.clickJoinGroupButton();
        String joinedGroupName = myGroupsPage.getGroupName();
        Selenide.refresh();
        List<String> myJoinedGroupsName = myGroupsPage.getMyJoinedGroupsName();
        assertThat(myJoinedGroupsName, hasItem(joinedGroupName));
    }

    @AfterAll
    public static void tearDown() {
        profilePage.expandUserMenu();
        profilePage.userLogout();
    }
}
