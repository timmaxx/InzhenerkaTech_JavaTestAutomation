import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InzhenerkaLoginTest {
    private static final String adminName = "admin";
    private static final String adminPassword = "admin123";

    //  10.1 Page Object Model
    //  шаг 1.
    //  https://stepik.org/lesson/1663876/step/1?unit=1686869
    @Test
    @DisplayName("Проверка логина")
    public void runLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage();
        loginPage.setUsername(adminName);
        loginPage.setPassword(adminPassword);
        loginPage.login();
        loginPage.logout();
    }
}
