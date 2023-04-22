package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static com.codeborne.selenide.Selenide.$x;

public class Toolbar {
    private final SelenideElement USER_NAME_FIELD = $x("//a[@class='nav-side_i  __with-ic __with-new-icons']/div");
    private final SelenideElement LOGOUT_BUTTON = $x("//div[@class='toolbar_accounts-user-delete-button']");
    private final SelenideElement USER_MENU_BUTTON = $x("//div[@class='ucard-mini toolbar_ucard js-toolbar-menu']");
    private final SelenideElement MY_GROUPS_BUTTON = $x("//a[@aria-label='Группы']");
    private final SelenideElement MY_MUSIC_BUTTON = $x("//div[@class='toolbar_nav_a toolbar_nav_a__audio h-mod']");
    private final SelenideElement ACTIONS_BUTTON = $x("//span[@aria-label='События']");
    private final SelenideElement MY_PHOTOS_BUTTON = $x("//a[@aria-label='Фото']");
    private final SelenideElement MY_HOLIDAYS_BUTTON = $x("//li[@data-l='outlandertarget,eventsCalendar,t,eventsCalendar']");
    private final SelenideElement VIDEOS_BUTTON = $x("//li[@id='hook_Block_TopMenuVideo']");
    private final SelenideElement BOOKMARKS_BUTTON = $x("//a[@href='/bookmarks']");
    private final SelenideElement UploadedImagePanel = $x("//up-photo-midget[@tsid=\"ok-file-uploader_collapsed-container\"]");

    public Toolbar() {
    }

    public MyGroupsPage getMyGroupsPage() {
        MY_GROUPS_BUTTON
                .shouldBe(Condition.visible.because("Кнопка \"Мои группы\" не найдена"))
                .click();
        return new MyGroupsPage();
    }

    public MyMusicPage getMyMusicPage() {
        MY_MUSIC_BUTTON
                .shouldBe(Condition.visible.because("Кнопка \"Моя музыка\" не найдена"))
                .click();
        return new MyMusicPage();
    }

    public ActionsPage getActionsPage() {
        ACTIONS_BUTTON
                .shouldBe(Condition.visible.because("Кнопка \"События\" не найдена"))
                .click();
        return new ActionsPage();
    }

    public MyPhotosPage getMyPhotosPage() {
        MY_PHOTOS_BUTTON
                .shouldBe(Condition.visible.because("Кнопка \"Мои фото\" не найдена"))
                .click();
        return new MyPhotosPage();
    }

    public MyHolidaysPage getMyHolidaysPage() {
        MY_HOLIDAYS_BUTTON
                .shouldBe(Condition.visible.because("Кнопка \"Праздники\" не найдена"))
                .click();
        return new MyHolidaysPage();
    }

    public VideosPage getVideosPage() {
        VIDEOS_BUTTON
                .shouldBe(Condition.visible.because("Кнопка \"Мои видео\" не найдена"))
                .click();
        return new VideosPage();
    }

    public BookmarksPage getBookmarksPage() {
        BOOKMARKS_BUTTON
                .shouldBe(Condition.visible.because("Кнопка \"Закладки\" не найдена"))
                .click();
        return new BookmarksPage();
    }

    public String getUserName() {
        return USER_NAME_FIELD
                .shouldBe(Condition.visible.because("Поле логина пользователя не найдено"))
                .getText();
    }


    public void waitForUploadFile() {
        UploadedImagePanel.shouldBe(Condition.visible.because("Файл не загрузился"), Duration.of(10, ChronoUnit.SECONDS));
    }
}

