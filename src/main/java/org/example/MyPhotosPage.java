package org.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MyPhotosPage {
    private final SelenideElement photosCountField = $x("//div[@class='count__x4tyv']");

    public MyPhotosPage() {
    }

    public int getPhotosCount() {
        try {
            return Integer.parseInt(photosCountField.text().split(" ")[0]);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
