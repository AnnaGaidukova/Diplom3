package stellarburgers.pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class LoginPage extends AppConfig {
    public static final String LOGIN_PAGE = "https://stellarburgers.nomoreparties.site/login";
    private final WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    //button 'Войти'
    private final By loginButton = By.xpath("//button[contains(text(),'Войти')]");
    //field name
    private final By emailField = By.xpath("//*[@name='name']");
    //field Пароль
    private final By passwordField = By.xpath("//*[@name='Пароль']");
    //link register
    private final By registerPageLink = By.xpath("//*[@href='/register']");

    //title 'Вход'
    private final By logInHeader = By.xpath("//h2[text()='Вход']");


    @Step("Клик по кнопке Войти на странице авторизации")
    public void clickToLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Клик по ссылке Зарегистрироваться на странице авторизации")
    public void clickToRegisterPageLink() {
        driver.findElement(registerPageLink).click();
    }

    @Step("Ввести почту пользователя в поле Email")
    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввести пароль пользователя в поле Пароль")
    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    @Step("Заполнить форму зарегистрированного пользователя")
    public void setUserLogin(String email, String password) {
        setEmailField(email);
        setPasswordField(password);
    }
    @Step("Заголовок Регистрация отображается на странице")
    public boolean isLogInHeaderDisplayed() {
        return driver.findElement(logInHeader).isDisplayed();
    }
    public void assertCurrentUrl() {
        assertThat("Происходит переход на страницу Логина", LOGIN_PAGE, equalTo(driver.getCurrentUrl()));
    }
}
