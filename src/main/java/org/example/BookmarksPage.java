package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.collections.ItemWithText;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

public class BookmarksPage {
    private final ElementsCollection ADDED_VIDEOS_TITLES = $$x("//a[@class='video-card_n ellip']");

    public BookmarksPage() {
    }

    public List<String> getVideosTitle() {
        return ADDED_VIDEOS_TITLES.texts();
    }

    public void waitUntilCertainVideoShowUp(String title) {
        ADDED_VIDEOS_TITLES.shouldBe(new ItemWithText(title),Duration.of(10, ChronoUnit.SECONDS));

    }
}
