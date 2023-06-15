package stellarburgers.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static stellarburgers.pages.LoginPage.LOGIN_PAGE;

public class ProfilePageTest {
    private WebDriver driver;
    private String userName;
    private String userEmail;
    private String userPassword;
    private User user;
    private UserStep userStep;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private HeaderPage headerPage;

    @Before
    public void setUp()  {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        userName = "USerNameTest";
        userEmail = "USerNameTest@yandex.ru";
        userPassword = "Test123!";
        userStep = new UserStep();
        user = new User(userEmail, userPassword, userName, "");
        userStep.createUser(user);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        headerPage = new HeaderPage(driver);
        driver.get(LOGIN_PAGE);
        loginPage.setUserLogin(userEmail, userPassword);
        loginPage.clickToLoginButton();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    @DisplayName("Выход по кнопке Выйти в личном кабинете")
    public void exitFromUserAccount() {
        driver.get(LOGIN_PAGE);
        loginPage.setUserLogin(userEmail, userPassword);
        loginPage.clickToLoginButton();
        headerPage.clickToAccButton();
        profilePage.assertCurUrl();
        profilePage.clickToExitButton();
    }
}