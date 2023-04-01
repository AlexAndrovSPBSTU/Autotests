package org.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class VideosPage {
    private final SelenideElement expandVideoMenuButton = $x("//div[@id='video-card_menu-ac']");
    private final SelenideElement addBookmarks = $x("//a[@class='video-card_menu-item']");
    private final SelenideElement videoTitleField = $x("//a[@class='video-card_n ellip']");

    public VideosPage() {
    }

    public void expandVideoMenu() {
        expandVideoMenuButton.hover();
        expandVideoMenuButton.click();
    }

    public void addBookmarks() {
        addBookmarks.click();
    }

    public String getVideoTitle() {
        return videoTitleField.text();
    }
}
