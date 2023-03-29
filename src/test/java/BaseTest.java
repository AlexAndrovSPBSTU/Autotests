import com.codeborne.selenide.Selenide;
import org.example.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasItem;

public class BaseTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;

    @BeforeAll
    public static void setup() {
        loginPage = new LoginPage(ConfProperties.getProperty("url"));
        loginPage.inputLogin(ConfProperties.getProperty("email"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        profilePage = new ProfilePage();
    }

    @AfterAll
    public static void tearDown() {
        profilePage.expandUserMenu();
        profilePage.userLogout();
    }


    @Test
    public void loginTest() {
        String user = profilePage.getUserName();
        String expected = ConfProperties.getProperty("login");
        Assertions.assertEquals(expected, user);
    }


    @Nested
    class JoinGroupTest {
        public MyGroupsPage myGroupsPage;

        @Test
        public void joinGroupTest() {
            myGroupsPage = profilePage.getMyGroupsPage();
            myGroupsPage.clickJoinGroupButton();
            String joinedGroupName = myGroupsPage.getGroupName();
            Selenide.refresh();
            List<String> myJoinedGroupsName = myGroupsPage.getMyJoinedGroupsName();
            assertThat(myJoinedGroupsName, hasItem(joinedGroupName));
        }
    }

    @Nested
    class UploadFileTest {
        public MyPhotosPage myPhotosPage;
        public ActionsPage actionsPage;

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
    }

    @Nested
    class MusicPlaylistTest {
        public MyMusicPage myMusicPage;
        public List<String> playlistNames;

        {
            playlistNames = new ArrayList<>();
            playlistNames.add("playlist1");
            playlistNames.add("playlist2");
        }

        @Test
        public void createPlaylistsTest() {
            myMusicPage = profilePage.getMyMusicPage();
            List<String> createdPlaylists = myMusicPage
                    .expandMyMusic()
                    .openPlaylistEditor()
                    .setPlaylistName(playlistNames.get(0))
                    .createPlaylist()
                    .openPlaylistEditor()
                    .setPlaylistName(playlistNames.get(1))
                    .createPlaylist()
                    .getCreatedPlaylists();
            assertThat(createdPlaylists, containsInAnyOrder(playlistNames.toArray()));
        }

        @AfterEach
        public void getBack() {
            myMusicPage.close();
        }
    }
}

