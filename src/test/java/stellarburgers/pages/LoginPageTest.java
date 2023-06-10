package stellarburgers.pages;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.pages.AppConfig;
import stellarburgers.pages.extentions.WebDriverFactory;
import stellarburgers.pages.*;
import stellarburgers.pages.RandomCredentials;
import stellarburgers.pages.User;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginPageTest {

    HeaderPage header = page(HeaderPage.class);
    MainPage mainPage = page(MainPage.class);
    LoginPage loginPage = page(LoginPage.class);
    RegistrationPage registrationPage = page( RegistrationPage.class);
    PasswordRecoveryPage passwordRecoveryPage = page(PasswordRecoveryPage.class);
    User validUserData;

    RandomCredentials random = new RandomCredentials();
    User user = new User(random.String(), random.Email(), random.String());

    @Before
    public void setUp() {
        WebDriverFactory.initWebDriver();
        open(AppConfig.URL_REGISTER);
        user.RegistrationUser();
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
    @DisplayName("Вход по кнопке Войти в аккаунт на главной")
    public void userLogInFromMainPageLogInButton() {
        open(AppConfig.URL_MAIN);
        mainPage.clickToLoginButton();
        user.LogInUser();
        Assert.assertTrue(mainPage.isMakeOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    public void userLogInFromHeaderUserAccountButton() {
        open(AppConfig.URL_MAIN);
        header.clickToAccountButton();
        user.LogInUser();
        Assert.assertTrue(mainPage.isMakeOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void userLogInFromRegisterPage() {
        open(AppConfig.URL_REGISTER);
        registrationPage.clickToLoginLink();
        user.LogInUser();
        Assert.assertTrue(mainPage.isMakeOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void userLogInFromForgotPasswordPage() {
        open(AppConfig.URL_LOGIN);
        loginPage.clickToForgotPasswordLink();
        passwordRecoveryPage.clickToLoginLink();
        user.LogInUser();
        Assert.assertTrue(mainPage.isMakeOrderButtonDisplayed());
    }

}