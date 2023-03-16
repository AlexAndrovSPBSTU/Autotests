import com.codeborne.selenide.Condition;
import org.example.MainPage;
import org.junit.jupiter.api.Test;

public class TestClass {
    private static final String OK_URL = "https://ok.ru";
    private final static String LOGIN = "login";
    private final static String PASSWORD = "password";

    @Test
    public void logInTest() {
        MainPage page = new MainPage(OK_URL);
        page.authorize(LOGIN, PASSWORD);
        page.getLoginErrorField().shouldHave(Condition.text("Неправильно указан логин и/или пароль"));
    }
}
