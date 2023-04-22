package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MyHolidaysPage {
    private final SelenideElement CURRENT_DAY_FIELD = $(".uec-calendar_day.__selected .uec-calendar_day-content");

    public MyHolidaysPage() {
    }

    public int getCURRENT_DAY_FIELD() {
        CURRENT_DAY_FIELD.shouldBe(Condition.visible.because("Поле даты не найдено"));
        return Integer.parseInt(CURRENT_DAY_FIELD.text());
    }
}
