package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MyMusicPage {
    private final SelenideElement EXPAND_MY_MUSIC_BUTTON = $x("//wm-icon[@class='arrow']");
    private final SelenideElement CREATE_PLAYLIST = $x("//div[@class='icon-w __create-playlist']");
    private final SelenideElement PLAYLIST_NAME_FIELD = $x("//input[@class='input' and @data-tsid='input_playlist_name']");
    private final SelenideElement CREATE_BUTTON = $x("//wm-button[@data-tsid='create_playlist_button']");
    private final ElementsCollection MY_PLAYLISTS_LIST = $$x("//wm-nav-playlist[@data-tsid='playlist_item']/div");
    private final SelenideElement CLOSE_MUSIC_PAGE_BUTTON = $x("//div[@class='toolbar-layer_close js-close-layer']");
    private final SelenideElement ADDITIONAL_PLAYLIST_SETTINGS_BUTTON = $x("//wm-button[@icon='more-h']");
    private final SelenideElement REMOVE_PLAYLIST_BUTTON = $x("//wm-tico[@data-l='t,remove']");
    private final SelenideElement SUBMIT_BUTTON = $x("//wm-button[@data-l='t,submit']");

    public MyMusicPage() {
    }

    public MyMusicPage expandMyMusic() {
        EXPAND_MY_MUSIC_BUTTON
                .shouldBe(Condition.visible.because("Кнопка разворачивания плейлистов не найдена"))
                .click();
        return this;
    }

    public MyMusicPage openPlaylistEditor() {
        CREATE_PLAYLIST
                .shouldBe(Condition.visible.because("Кнопка открытия редактора создания нового плейлиста не найдена"))
                .click();
        PLAYLIST_NAME_FIELD
                .shouldBe(Condition.visible.because("Поле названия плейлиста не найдено"))
                .clear();
        return this;
    }

    public MyMusicPage setPlaylistName(String name) {
        PLAYLIST_NAME_FIELD.sendKeys(name);
        return this;
    }

    public MyMusicPage createPlaylist() {
        CREATE_BUTTON
                .shouldBe(Condition.visible.because("Кнопка создания нового плейлиста не найдена"))
                .click();
        return this;
    }

    public void removeCreatedPlaylists(String playlistName) {
        MY_PLAYLISTS_LIST.get(MY_PLAYLISTS_LIST.texts().indexOf(playlistName)).click();
        ADDITIONAL_PLAYLIST_SETTINGS_BUTTON
                .shouldBe(Condition.visible.because("Кнопка доп настроек не найдена"))
                .click();
        REMOVE_PLAYLIST_BUTTON
                .shouldBe(Condition.visible.because("Кнопка удаления плейлиста не найдена"))
                .click();
        SUBMIT_BUTTON
                .shouldBe(Condition.visible.because("Кнопка принятия не найдена"))
                .click();
    }

    public List<String> getMY_PLAYLISTS_LIST() {
        try {
//            Wait().wait(1000);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return MY_PLAYLISTS_LIST.texts();
    }

    public void close() {
        CLOSE_MUSIC_PAGE_BUTTON
                .shouldBe(Condition.visible.because("Кнопка закрытия MusicPage не найдена"))
                .click();
    }
}
