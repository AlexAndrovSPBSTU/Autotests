package org.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MyHolidaysPage {
    private final SelenideElement currentDay = $(".uec-calendar_day.__selected .uec-calendar_day-content");

    public MyHolidaysPage() {
    }

    public int getCurrentDay() {
        return Integer.parseInt(currentDay.text());
    }
}
