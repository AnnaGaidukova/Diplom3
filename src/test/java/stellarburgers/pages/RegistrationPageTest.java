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
import static stellarburgers.pages.RegistrationPage.REGISTRATION_PAGE;

public class RegistrationPageTest {
    private WebDriver driver;
    private String userName;
    private String userEmail;
    private String userPassword;
    private User user;
    private UserStep userStep;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private MainPage mainPage;
    private HeaderPage headerPage;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        userName = RandomStringUtils.randomAlphabetic(10);
        userEmail = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        userPassword = "Test123!";
        userStep = new UserStep();
        user = new User(userEmail, userPassword, userName, "");
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        headerPage = new HeaderPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
        }
    @Test
    @DisplayName("Переход к регистрации через кнопку Зарегистрироваться")
    public void userRegistrationFromTheRegistrationButton() {
        driver.get(LOGIN_PAGE);
        loginPage.clickToRegisterPageLink();
        registrationPage.assertCurrentUrl();
    }
    @Test
    @DisplayName("Успешная регистрация пользователя")
    public void userRegistrationWithValidCredentials() {
        driver.get(REGISTRATION_PAGE);
        registrationPage.fillRegistrationForm(userName, userEmail, userPassword);
        registrationPage.clickToRegisterButton();
        registrationPage.assertCurrentUrl();
    }
    @Test
    @DisplayName("Ошибка при некорректном пароле меньше шести символов")
    public void userRegistrationWithInvalidPassword() {
        driver.get(REGISTRATION_PAGE);
        registrationPage.fillRegistrationForm(userName, userEmail, "Test");
        registrationPage.clickToRegisterButton();
        registrationPage.isPasswordErrorDisplayed();
        driver.get(MAIN_PAGE);
        headerPage.clickToAccButton();
        loginPage.assertCurrentUrl();
    }
}