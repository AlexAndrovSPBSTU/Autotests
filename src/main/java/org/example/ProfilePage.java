package org.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {
    private final SelenideElement loginNameField = $x("//a[@class='nav-side_i  __with-ic __with-new-icons']/div");
    private final SelenideElement logoutBtn = $x("//div[@class='toolbar_accounts-user-delete-button']");
    private final SelenideElement userMenu = $x("//div[@class='ucard-mini toolbar_ucard js-toolbar-menu']");
    private final SelenideElement openMyGroupsButton = $x("//a[@aria-label='Группы']");
    private final SelenideElement openMyMusicButton = $x("//div[@class='toolbar_nav_a toolbar_nav_a__audio h-mod']");
    private final SelenideElement openActionButton = $x("//span[@aria-label='События']");
    private final SelenideElement openMyPhotosButton = $x("//a[@aria-label='Фото']");
    private final SelenideElement myHolidaysButton = $x("//li[@data-l='outlandertarget,eventsCalendar,t,eventsCalendar']");
    private final SelenideElement videosButton = $x("//li[@id='hook_Block_TopMenuVideo']");
    private final SelenideElement bookmarksButton = $x("//a[@href='/bookmarks']");

    public ProfilePage() {
    }

    public MyGroupsPage getMyGroupsPage() {
        openMyGroupsButton.click();
        return new MyGroupsPage();
    }

    public MyMusicPage getMyMusicPage() {
        openMyMusicButton.click();
        return new MyMusicPage();
    }

    public ActionsPage getActionsPage() {
        openActionButton.click();
        return new ActionsPage();
    }

    public MyPhotosPage getMyPhotosPage() {
        openMyPhotosButton.click();
        return new MyPhotosPage();
    }

    public MyHolidaysPage getMyHolidaysPage() {
        myHolidaysButton.click();
        return new MyHolidaysPage();
    }

    public VideosPage getVideosPage() {
        videosButton.click();
        return new VideosPage();
    }

    public BookmarksPage getBookmarksPage() {
        bookmarksButton.click();
        return new BookmarksPage();
    }

    public String getUserName() {
        return loginNameField.getText();
    }

    public void expandUserMenu() {
        userMenu.click();
    }

    public void userLogout() {
        logoutBtn.click();
    }
}

