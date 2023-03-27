package org.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {
    private final SelenideElement sideMenu = $x("//*[@id=\"hook_Block_Navigation\"]/div/div/div[1]/a/div");
    private final SelenideElement logoutBtn = $x("//*[@id=\"hook_Block_ToolbarUserDropdown\"]/div/div[2]/div/div[1]/div/div[1]/div[2]/a");
    private final SelenideElement userMenu = $x("//*[@id=\"hook_Block_ToolbarUserDropdown\"]/div/div[1]");
    private final SelenideElement openMyGroupsButton = $x("//a[@aria-label='Группы']");
    private final SelenideElement openMyMusicButton = $x("//div[@class='toolbar_nav_a toolbar_nav_a__audio h-mod']/div[2]");
    private final SelenideElement openActionButton = $x("//span[@aria-label='События']");

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

    public String getUserName() {
        return sideMenu.getText();
    }

    public void expandUserMenu() {
        userMenu.click();
    }

    public void userLogout() {
        logoutBtn.click();
    }
}

