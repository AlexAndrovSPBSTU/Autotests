package org.example;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.$x;

public class ActionsPage {
    private final SelenideElement chooseFile = $x("//*[@id='feedbackEmptyStub']/div[3]/input");


    public ActionsPage() {
    }

    public void uploadFile(String src) {
        chooseFile.uploadFile(new File(src));
    }
}
