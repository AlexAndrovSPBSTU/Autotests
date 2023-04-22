package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement LOGIN_FIELD = $x("//input[@id='field_email']");
    private final SelenideElement PASSWORD_FIELD = $x("//input[@id='field_password']");
    private final SelenideElement SUBMIT_BUTTON = $x("//*[@class='login-form-actions']/input[@type='submit']");

    public LoginPage() {
    }

    public void inputLogin(String login) {
        LOGIN_FIELD.sendKeys(login);
    }

    public void inputPasswd(String passwd) {
        PASSWORD_FIELD.sendKeys(passwd);
    }

    public void clickLoginBtn() {
        SUBMIT_BUTTON.click();
    }

    public void check(){
        LOGIN_FIELD.shouldBe(Condition.visible.because("Поле логина не найдено"));
        PASSWORD_FIELD.shouldBe(Condition.visible.because("Поле пароля не найдено"));
        SUBMIT_BUTTON.shouldBe(Condition.visible.because("Кнопка не найдена"));
    }
}
