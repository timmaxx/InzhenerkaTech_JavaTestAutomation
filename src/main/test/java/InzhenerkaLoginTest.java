import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class InzhenerkaLoginTest {
    private static final String userName = "user";
    private static final String password = "user123";
    private static final String adminName = "admin";
    private static final String adminPassword = "admin123";

    //  9.1 Автотесты для входа на сайт
    //  https://stepik.org/lesson/1663836/step/1?unit=1686829
    @Test
    void loginAndLogoutTest() {
        // Configuration.browser = "firefox"; // Раскомментируй, если нужен Firefox

        // 1. Открыть страницу
        open("http://qa-stand-login.inzhenerka.tech/login");

        // 2. Вводим логин и пароль (данные берем из документации)
        $("#username").setValue(userName);
        $(By.name("password")).setValue(password); // <-- Проверь пароль в документации!

        // 3. Нажимаем "Вход"
        $("button[type='submit']").click();

        // 4. ПРОВЕРКА (Assertion)
        // Мы ищем элемент body или заголовок, который содержит приветствие
        $("body").shouldHave(text("Привет, " + userName));

        // 5. Выход из системы
        // Используем поиск по тексту "Выйти" — это надежнее, чем искать по классам стилей (.mb-3)
        $(byText("Выйти")).click();

        // 6. Проверка выхода (снова видна кнопка "Вход")
        $("button[type='submit']").shouldBe(visible);
    }

    //  9.2 Решаем задачи
    //  https://stepik.org/lesson/1663837/step/4?unit=1686830
    @Test
    void loginAdminAndLogoutTest() {
        // Настройка: браузер откроется на весь экран
        Configuration.browserSize = "1920x1080";
        // Configuration.browser = "firefox"; // Раскомментируй, если нужен не Chrome

        // 1. Открываем сайт
        open("http://qa-stand-login.inzhenerka.tech/login");

        // --- ЧАСТЬ 1: Успешный вход ---
        $("#username").setValue(adminName);
        $(By.name("password")).setValue(adminPassword);

        // Жмем кнопку "Войти"
        $("button[type='submit']").click();

        // Проверяем, что вошли (видим кнопку "Выйти")
        $(byText("Выйти")).shouldBe(visible);

        // --- ЧАСТЬ 2: Выход ---
        $(byText("Выйти")).click();

        // Проверяем, что вышли (снова видим кнопку "Войти")
        $("button[type='submit']").shouldBe(visible);
    }

    //  9.2 Решаем задачи
    //  https://stepik.org/lesson/1663837/step/4?unit=1686830
    @Test
    void loginWithSpaceUsernameAndEmptyPasswordTest() {
        // Открываем сайт
        open("http://qa-stand-login.inzhenerka.tech/login");

        // --- ЧАСТЬ 3: Вход с пустыми полями (ЗАДАНИЕ) ---
        // Тебе нужно:
        // 1. Очистить поля или ввести пустые значения ("").
        //  !!! При вставке пустых значений ("") сервер настроен на логин как админ,
        //      поэтому здесь в имени пользователя указываю пробел.
        $("#username").setValue(" ");
        $(By.name("password")).setValue("");

        // 2. Нажать кнопку входа.
        $("button[type='submit']").click();

        // 3. Убедиться, что система не пропустила тебя внутрь (кнопка "Войти" осталась видимой).
        //  !!! Сервер не предлагает кнопку "Войти",
        //      а вместо этого предлагает кнопку "Попробовать снова".
        $(byText("Попробовать снова")).shouldBe(visible);
        $(byText("Попробовать снова")).click();

        //  !!! И только теперь кнопка "Войти" будет видимой.
        $(byText("Войти")).shouldBe(visible);
    }
}
