import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BaseTest {
    private final String URL = "http://qa-stand-login.inzhenerka.tech/login";

    // Локатор: Имя пользователя
    private final SelenideElement usernameField = $("#username");
    // Локатор: Пароль
    private final SelenideElement passwordField = $("[name='password']");
    // Локатор: Кнопка входа
    private final SelenideElement loginButton = $("button[type='submit']");
    // Локатор: Кнопка выхода
    private final SelenideElement logoutButton = $(byText("Выйти"));

    public void openPage() {
        Selenide.open(URL);
    }

    // Методы для работы с этими элементами

    public void setUsername(String username) {
        // Ввод имени пользователя
        usernameField.setValue(username);
    }

    public void setPassword(String password) {
        // Ввод пароля
        passwordField.setValue(password);
    }

    public void login() {
        String userName = usernameField.getValue();

        loginButton.shouldBe(visible);

        // Нажатие кнопки входа
        loginButton.click();

        // Мы ищем элемент body или заголовок, который содержит приветствие
        $("body").shouldHave(text("Привет, " + userName));

        logoutButton.shouldBe(visible);
    }

    public void logout() {
        logoutButton.shouldBe(visible);

        // Нажатие кнопки выхода
        logoutButton.click();

        loginButton.shouldBe(visible);
    }
}
