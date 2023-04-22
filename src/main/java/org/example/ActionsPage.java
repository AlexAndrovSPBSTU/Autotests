package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.$x;

public class ActionsPage {
    private final SelenideElement CHOOSE_FILE_BUTTON = $x("//input[@data-context='{\"uploadType\":\"USER_PHOTO\",\"flashId\":\"fileapiful_user_empty_feedback_lite\"}']");
    private final SelenideElement CLOSE_ACTIONS_PAGE_BUTTON = $x("//div[@class='toolbar-layer_close js-close-layer' and @title='Закрыть']");

    public ActionsPage() {
    }

    public void uploadFile(String src) {
        CHOOSE_FILE_BUTTON.uploadFile(new File(src));
    }

    public void closeWindowForUpload() {
        CLOSE_ACTIONS_PAGE_BUTTON
                .shouldBe(Condition.visible.because("Кнопка закртия не найдена"))
                .click();
    }

}
