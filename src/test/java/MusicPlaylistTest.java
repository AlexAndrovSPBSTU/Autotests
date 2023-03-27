import org.example.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MusicPlaylistTest {
    public static MyMusicPage myMusicPage;
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static List<String> playlistNames;

    static {
        playlistNames = new ArrayList<>();
        playlistNames.add("playlist1");
        playlistNames.add("playlist2");
    }

    @BeforeAll
    public static void setup() {
        loginPage = new LoginPage(ConfProperties.getProperty("url"));
        loginPage.inputLogin(ConfProperties.getProperty("email"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        profilePage = new ProfilePage();
        myMusicPage = profilePage.getMyMusicPage();
    }

    @Test
    public void createPlaylistsTest() {
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

    @AfterAll
    public static void tearDown() {
        profilePage.expandUserMenu();
        profilePage.userLogout();
    }
}
