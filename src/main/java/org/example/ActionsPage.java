package org.example;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.$x;

public class ActionsPage {
    private final SelenideElement chooseFile = $x("//*[@id='feedbackEmptyStub']/div[3]/input");
    private final SelenideElement closeWindowButton = $x("//div[@class='toolbar-layer_close js-close-layer' and @title='Закрыть']");

    public ActionsPage() {
    }

    public void uploadFile(String src) {
        chooseFile.uploadFile(new File(src));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeWindowForUpload() {
        closeWindowButton.click();
    }

}
