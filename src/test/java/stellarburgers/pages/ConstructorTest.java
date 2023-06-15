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

public class ConstructorTest {
    private WebDriver driver;
    private String userName;
    private String userEmail;
    private String userPassword;
    private User user;
    private UserStep userStep;
    private LoginPage loginPage;
    private MainPage mainPage;

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
    @DisplayName("Открыть раздел Начинки по клику на название раздела")
    public void openIngredientsSectionFromSectionNameLink() {
        driver.get(MAIN_PAGE);
        mainPage.openIngredientSection();
        mainPage.isIngredientsSectionOpen();
    }
    @Test
    @DisplayName("Открыть раздел Соусы по клику на название раздела")
    public void openSaucesSectionFromSectionNameLink(){
        driver.get(MAIN_PAGE);
        mainPage.openSaucesSection();
        mainPage.isSaucesSectionOpen();
    }
    @Test
    @DisplayName("Открыть раздел Булки по клику на название раздела")
    public void openBunsSectionFromSectionNameLink(){
        driver.get(MAIN_PAGE);
        mainPage.openIngredientSection();
        mainPage.openBunsSection();
        mainPage.isBunsSectionOpen();
    }
}