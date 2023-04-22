package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MyPhotosPage {
    private final SelenideElement PHOTOS_NUMBER_FIELD = $x("//div[@class='count__x4tyv']");

    public MyPhotosPage() {
    }

    public int getPhotosCount() {
        PHOTOS_NUMBER_FIELD.shouldBe(Condition.visible.because("Поле количества фотографий не найдено"));
        return Integer.parseInt(PHOTOS_NUMBER_FIELD.text().split(" ")[0].equals("Нет") ? "0" : PHOTOS_NUMBER_FIELD.text().split(" ")[0]);
    }
}
