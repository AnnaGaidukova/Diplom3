package stellarburgers.pages;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.pages.extentions.WebDriverFactory;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPageTest {
    MainPage mainPage = page(MainPage.class);
    LoginPage loginPage = page(LoginPage.class);
    RegistrationPage registrationPage = page(RegistrationPage.class);
    User validUserData;
    RandomCredentials random = new RandomCredentials();

    @Before
    public void setUp() {
        WebDriverFactory.initWebDriver();
        open(AppConfig.URL_MAIN);
        mainPage.clickToLoginButton();
        loginPage.clickToRegisterPageLink();
    }

    @After
    public void tearDown() {
        if (validUserData != null) {
            validUserData.deleteUserUsingAPI();
        }
        WebDriverRunner.clearBrowserCache();
        WebDriverRunner.closeWebDriver();
    }


    @Test
    @DisplayName("Успешная регистрация пользователя")
    public void userRegistrationWithValidCredentials() {
        User user = new User(random.String(),random.Email(), random.String());
        user.RegistrationUser();
        Assert.assertTrue(loginPage.isLogInHeaderDisplayed());
    }

    @Test
    @DisplayName("Ошибка при некорректном пароле меньше шести символов")
    public void userRegistrationWithInvalidPassword() {
        User user = new User(random.String(),random.Email(),random.invalidString());
        user.RegistrationUser();
        Assert.assertTrue(registrationPage.isPasswordErrorDisplayed());
    }
}