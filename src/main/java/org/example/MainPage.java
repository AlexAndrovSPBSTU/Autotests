package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement loginField = $x("//input[@id='field_email']");
    private final SelenideElement passwordField = $x("//input[@id='field_password']");
    private final SelenideElement submitButton = $x("//*[@class='login-form-actions']/input[@type='submit']");

    private final SelenideElement loginErrorField = $x("//*/form/div[3]/div");

    public MainPage(String url) {
        Selenide.open(url);
    }
    public void authorize(String login, String password) {
        loginField.setValue(login).shouldBe(Condition.value(login));
        passwordField.setValue(password).shouldBe(Condition.value(password));
        submitButton.click();
    }

    public SelenideElement getLoginErrorField() {
        return loginErrorField;
    }

}
