package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement loginField = $x("//input[@id='field_email']");
    private final SelenideElement passwordField = $x("//input[@id='field_password']");
    private final SelenideElement submitButton = $x("//*[@class='login-form-actions']/input[@type='submit']");

    public LoginPage(String url) {
        Selenide.open(url);
    }

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPasswd(String passwd) {
        passwordField.sendKeys(passwd);
    }

    public void clickLoginBtn() {
        submitButton.click();
    }
}
