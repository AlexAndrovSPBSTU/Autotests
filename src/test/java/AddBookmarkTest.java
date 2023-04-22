import org.example.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class AddBookmarkTest extends BaseTest {
    @BeforeAll
    static void setUp() {
        BaseTest.setUp();
        LoginPage loginPage = new LoginPage();
        loginPage.inputLogin(ConfProperties.getProperty("email"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
    }

    @Test
    public void addVideoAsBookmark() {
        Toolbar toolbar = new Toolbar();
        VideosPage videosPage = toolbar.getVideosPage();
        videosPage.addBookmark();
        videosPage.waitForConfirmBookmarkToShowUp();
        String addedVideoTitle = videosPage.getVideoTitle();
        BookmarksPage bookmarksPage = toolbar.getBookmarksPage();
        bookmarksPage.waitUntilCertainVideoShowUp(addedVideoTitle);
        List<String> addedVideosTitle = bookmarksPage.getVideosTitle();
        assertThat(addedVideoTitle, Matchers.isIn(addedVideosTitle));
    }
}
