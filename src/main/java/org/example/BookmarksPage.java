package org.example;

import com.codeborne.selenide.ElementsCollection;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

public class BookmarksPage {
    private final ElementsCollection addedVideosTitle = $$x("//a[@class='video-card_n ellip']");

    public BookmarksPage() {
    }

    public List<String> getVideosTitle() {
        return addedVideosTitle.texts();
    }
}
