package stellarburgers.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static stellarburgers.pages.LoginPage.LOGIN_PAGE;
import static stellarburgers.pages.PasswordRecoveryPage.RECOVERY_PASSWORD_PAGE;
import static stellarburgers.pages.MainPage.MAIN_PAGE;
import static stellarburgers.pages.RegistrationPage.REGISTRATION_PAGE;


public class LoginPageTest {
    private WebDriver driver;
    private String userName;
    private String userEmail;
    private String userPassword;
    private User user;
    private UserStep userStep;
    private LoginPage loginPage;
    private MainPage mainPage;
    private PasswordRecoveryPage passwordRecoveryPage;
    private RegistrationPage registrationPage;
    private HeaderPage headerPage;


    @Before
    public void setUp()  {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        userName = RandomStringUtils.randomAlphabetic(10);
        userEmail = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        userPassword = RandomStringUtils.randomAlphabetic(10);
        userStep = new UserStep();
        user = new User(userEmail, userPassword, userName, "");
        userStep.createUser(user);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        registrationPage = new RegistrationPage(driver);
        passwordRecoveryPage = new PasswordRecoveryPage(driver);
        headerPage = new HeaderPage(driver);
    }
    @After
    public void tearDown() {
        driver.quit();
        userStep.deleteUser(user);
    }
    @Test
    @DisplayName("Вход по кнопке Войти в аккаунт на главной")
    public void userLogInFromMainPageLogInButton() {
        driver.get(MAIN_PAGE);
        mainPage.clickToLoginButton();
        loginPage.assertCurrentUrl();
    }
    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    public void userLogInFromLoginPageLogInButton() {
        driver.get(LOGIN_PAGE);
        loginPage.setUserLogin(userEmail, userPassword);
        loginPage.clickToLoginButton();
        mainPage.isMakeOrderButtonDisplayed();
    }
    @Test
    @DisplayName("Вход через кнопку в хедере")
    public void userLogInFromHeaderLogInButton() {
        driver.get(MAIN_PAGE);
        headerPage.clickToAccButton();
        loginPage.assertCurrentUrl();
    }
    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void userLogInFromRegisterPage() {
        driver.get(REGISTRATION_PAGE);
        registrationPage.clickToLoginLink();
        loginPage.assertCurrentUrl();
    }
    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void userLogInFromPasswordRecoveryPage() {
        driver.get(RECOVERY_PASSWORD_PAGE);
        passwordRecoveryPage.clickToLoginLink();
        loginPage.assertCurrentUrl();
    }
}