import com.codeborne.selenide.Selenide;
import org.example.ConfProperties;
import org.example.LoginPage;
import org.example.MyGroupsPage;
import org.example.Toolbar;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class JoinGroupTest extends BaseTest {

    @BeforeAll
    static void setUp() {
        BaseTest.setUp();
        LoginPage loginPage = new LoginPage();
        loginPage.inputLogin(ConfProperties.getProperty("email"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
    }
    @Test
    public void joinGroupTest() {
        Toolbar toolbar = new Toolbar();
        MyGroupsPage myGroupsPage = toolbar.getMyGroupsPage();
        myGroupsPage.clickJoinGroupButton();
        String joinedGroupName = myGroupsPage.getFirstGroupName();
        Selenide.refresh();
        List<String> myJoinedGroupsName = myGroupsPage.getMyJoinedGroupsName();
        assertThat(myJoinedGroupsName, hasItem(joinedGroupName));
    }
}
