import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InzhenerkaLoginTest {
    private static final String adminName = "admin";
    private static final String adminPassword = "admin123";
    private static final String userName = "user";
    private static final String userPassword = "user123";

    //  10.2 Задание
    //  шаг 1.
    //  https://stepik.org/lesson/1663877/step/1?unit=1686870
    @Test
    @DisplayName("Проверка логина")
    public void runLoginTestForAdmin() {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage();
        loginPage.setUsername(adminName);
        loginPage.setPassword(adminPassword);
        loginPage.login();
        loginPage.logout();
    }

    //  10.2 Задание
    //  шаг 2.
    //  https://stepik.org/lesson/1663877/step/1?unit=1686870
    @Test
    @DisplayName("Проверка логина")
    public void runLoginTestForUser() {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage();
        loginPage.setUsername(userName);
        loginPage.setPassword(userPassword);
        loginPage.login();
        loginPage.logout();
    }
}
