import org.example.ConfProperties;
import org.example.LoginPage;
import org.example.MyMusicPage;
import org.example.Toolbar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;

public class CreateMusicPlaylistTest extends BaseTest {
    private final List<String> playlistNames;

    {
        playlistNames = new ArrayList<>();
        playlistNames.add("playlist1");
        playlistNames.add("playlist2");
    }

    @BeforeAll
    static void setUp() {
        BaseTest.setUp();
        LoginPage loginPage = new LoginPage();
        loginPage.inputLogin(ConfProperties.getProperty("email"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
    }

    @Test
    public void createPlaylistsTest() {
        Toolbar toolbar = new Toolbar();
        MyMusicPage myMusicPage = toolbar.getMyMusicPage();
        List<String> MyPlaylists = myMusicPage
                .expandMyMusic()
                .openPlaylistEditor()
                .setPlaylistName(playlistNames.get(0))
                .createPlaylist()
                .openPlaylistEditor()
                .setPlaylistName(playlistNames.get(1))
                .createPlaylist()
                .getMY_PLAYLISTS_LIST();
        assertThat(MyPlaylists, hasItems(playlistNames.toArray(new String[0])));
    }

    @AfterEach
    public void deletePlaylists() {
        MyMusicPage myMusicPage = new MyMusicPage();
        for (String name : playlistNames) {
            myMusicPage.removeCreatedPlaylists(name);
        }
    }
}
