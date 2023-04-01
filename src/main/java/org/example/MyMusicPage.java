package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class MyMusicPage {
    private final SelenideElement expandMyMusicButton = $x("//wm-icon[@class='arrow']");
    private final SelenideElement createOwnPlaylist = $x("//div[@class='icon-w __create-playlist']");
    private final SelenideElement playlistNameField = $x("//input[@class='input' and @data-tsid='input_playlist_name']");
    private final SelenideElement createPlaylist = $x("//wm-button[@data-tsid='create_playlist_button']");
    private final ElementsCollection createdPlaylists = $$x("//div[@class='submenu']/section/a/div");
    private final SelenideElement closeMusicPageButton = $x("//div[@class='toolbar-layer_close js-close-layer']");
    private final SelenideElement additionalSettingsButton = $x("//wm-button[@icon='more-h']");
    private final SelenideElement removePlaylistButton = $x("//wm-tico[@data-l='t,remove']");
    private final SelenideElement submitButton = $x("//wm-button[@data-l='t,submit']");

    public MyMusicPage() {
    }

    public MyMusicPage expandMyMusic() {
        expandMyMusicButton.click();
        return this;
    }

    public MyMusicPage openPlaylistEditor() {
        createOwnPlaylist.click();
        playlistNameField.clear();
        return this;
    }

    public MyMusicPage setPlaylistName(String name) {
        playlistNameField.sendKeys(name);
        return this;
    }

    public MyMusicPage createPlaylist() {
        createPlaylist.click();
        return this;
    }

    public void removeCreatedPlaylists() {
        int size = createdPlaylists.size();
        while (size != 0) {
            createdPlaylists.get(0).click();
            additionalSettingsButton.click();
            removePlaylistButton.click();
            submitButton.click();
            size--;
        }
    }

    public List<String> getCreatedPlaylists() {
        try {
//            Wait().wait(1000);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return createdPlaylists.texts();
    }

    public void close() {
        closeMusicPageButton.click();
    }
}
