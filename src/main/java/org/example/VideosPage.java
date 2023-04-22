package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.collections.SizeGreaterThan;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class VideosPage {
    private final ElementsCollection ADDITIONAL_VIDEO_SETTINGS_BUTTONS = $$x("//div[@id='video-card_menu-ac']");
    private final SelenideElement ADD_VIDEO_TO_BOOKMARKS_BUTTON = $x("//a[@class='video-card_menu-item']");
    private final SelenideElement BUTTON_TITLE = $x("//a[@class='video-card_menu-item']/div");
    private final SelenideElement VIDEO_TITLE_FIELD = $x("//a[@class='video-card_n ellip']");
    private final SelenideElement CONFIRM_BOOKMARK = $x("//div[@class=\"tip __action-tip __bot __fixed h-mod __active\"]");
    private final static String ADD_BOOKMARK_STRING = "Добавить закладку";

    public VideosPage() {
    }

    public void addBookmark() {
        int i = 0;
        ADDITIONAL_VIDEO_SETTINGS_BUTTONS
                .shouldBe(new SizeGreaterThan(0));
        while (i < ADDITIONAL_VIDEO_SETTINGS_BUTTONS.size()) {
            ADDITIONAL_VIDEO_SETTINGS_BUTTONS
                    .get(i)
                    .hover()
                    .shouldBe(Condition.visible.because("Кнопка настроек не найдена"))
                    .click();
            if (!BUTTON_TITLE
                    .shouldBe(Condition.visible.because("Кнопка добавления в закладки не найдена"))
                    .text().equals(ADD_BOOKMARK_STRING)) {
                i++;
            } else {
                break;
            }
        }
        ADD_VIDEO_TO_BOOKMARKS_BUTTON
                .shouldBe(Condition.visible.because("Кнопка добавления в закладки не найдена"))
                .click();
    }

    public String getVideoTitle() {
        return VIDEO_TITLE_FIELD
                .shouldBe(Condition.visible.because("Заголовок видео не найден"))
                .text();
    }

    public void waitForConfirmBookmarkToShowUp() {
        CONFIRM_BOOKMARK.shouldBe(Condition.visible.because("Закладка не появилась"), Duration.of(5, ChronoUnit.SECONDS));
    }
}
