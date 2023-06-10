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

public class ProfilePageTest {
    ProfilePage profilePage = page(ProfilePage.class);
    LoginPage loginPage = page(LoginPage.class);
    HeaderPage header = page(HeaderPage.class);
    User validUserData;
    RandomCredentials random = new RandomCredentials();
    User user = new User(random.String(), random.Email(), random.String());

    @Before
    public void setUp()  {
        WebDriverFactory.initWebDriver();
        open(AppConfig.URL_REGISTER);
        user.RegistrationUser();
        open(AppConfig.URL_LOGIN);
        user.LogInUser();
        header.clickToAccountButton();
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
    @DisplayName("Переход по клику на «Личный кабинет».")
    public void openUserAccount() {
        boolean isPersonalAreaElementDisplayed = profilePage.isExitButtonDisplayed();
        Assert.assertTrue(isPersonalAreaElementDisplayed);
    }

    @Test
    @DisplayName("Выход по кнопке Выйти в личном кабинете")
    public void exitFromUserAccount() throws InterruptedException {
        profilePage.clickToExitButton();
        boolean isExitSuccess = loginPage.isLogInHeaderDisplayed();
        Assert.assertTrue(isExitSuccess);
    }

    @Test
    @DisplayName("Перейти в конструктор бургеров из лого Stellar Burgers")
    public void switchFromAccountToConstructorByLogo() {
        header.clickToLogo();
        Assert.assertTrue(header.isConstructorButtonEnabled());
    }

    @Test
    @DisplayName("Перейти в конструктор бургеров по кнопке Конструктор")
    public void switchFromAccountToConstructorByConstructorButton() {
        header.clickToConstructorButton();
        Assert.assertTrue(header.isConstructorButtonEnabled());
    }
}