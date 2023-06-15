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
import static stellarburgers.pages.MainPage.MAIN_PAGE;
import static stellarburgers.pages.ProfilePage.ACCOUNT_PAGE;

public class HeaderPageTest {
    private WebDriver driver;
    private String userName;
    private String userEmail;
    private String userPassword;
    private User user;
    private UserStep userStep;
    private LoginPage loginPage;
    private MainPage mainPage;
    private ProfilePage profilePage;
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
        profilePage = new ProfilePage(driver);
        headerPage = new HeaderPage(driver);
        driver.get(LOGIN_PAGE);
        loginPage.setUserLogin(userEmail, userPassword);
        loginPage.clickToLoginButton();
    }
    @After
    public void tearDown() {
        driver.quit();
        userStep.deleteUser(user);
    }

    @Test
    @DisplayName("Перейти в личный кабинет через кнопку Личный кабинет в Хедере")
    public void getAccountByAccountButtonOnHeader() {
        driver.get(LOGIN_PAGE);
        loginPage.setUserLogin(userEmail, userPassword);
        loginPage.clickToLoginButton();
        headerPage.clickToAccButton();
        profilePage.assertCurUrl();
    }
    @Test
    @DisplayName("Перейти на главную страницу через Конструктор из Личного кабинета")
    public void getMainPageByConstructorButtonFromPersonalPage() {
        driver.get(ACCOUNT_PAGE);
        headerPage.clickToConstructorButton();
        mainPage.assertCurrentUrl();
    }
    @Test
    @DisplayName("Перейти на главную страницу через логотип в личном кабинете")
    public void getMainPageByLOGOFromPersonalPage() {
        driver.get(LOGIN_PAGE);
        loginPage.setUserLogin(userEmail, userPassword);
        loginPage.clickToLoginButton();
        driver.get(ACCOUNT_PAGE);
        headerPage.clickToLogo();
        mainPage.assertCurrentUrl();
    }
}