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

    public MyPhotosPage getMyPhotosPage(){
        openMyPhotosButton.click();
        return new MyPhotosPage();
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

