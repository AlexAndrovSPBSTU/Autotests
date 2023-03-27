package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenideWait;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class MyMusicPage {
    private final SelenideElement expandMyMusicButton = $x("//wm-icon[@class='arrow']");
    private final SelenideElement createOwnPlaylist = $x("//div[@class='icon-w __create-playlist']");
    private final SelenideElement playlistNameField = $x("//input[@class='input' and @placeholder='Название сборника']");
    private final SelenideElement createPlaylist = $x("//wm-button[@data-tsid='create_playlist_button']");
    private final ElementsCollection createdPlaylists = $$x("//div[@class='submenu']/section/a/div");

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

    public List<String> getCreatedPlaylists() {
        try {
//            Wait().wait(1000);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return createdPlaylists.texts();
    }
}
