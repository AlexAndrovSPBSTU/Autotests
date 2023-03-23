package org.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {
    private final SelenideElement sideMenu = $x("//*[@id=\"hook_Block_Navigation\"]/div/div/div[1]/a/div");
    private final SelenideElement logoutBtn = $x("//*[@id=\"hook_Block_ToolbarUserDropdown\"]/div/div[2]/div/div[1]/div/div[1]/div[2]/a");
    private final SelenideElement userMenu = $x("//*[@id=\"hook_Block_ToolbarUserDropdown\"]/div/div[1]");

    public ProfilePage() {
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

