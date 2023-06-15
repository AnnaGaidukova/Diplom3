package stellarburgers.pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RegistrationPage extends AppConfig {
    private final WebDriver driver;
    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }
    public static final String REGISTRATION_PAGE = "https://stellarburgers.nomoreparties.site/register";
    //field имя
    private final By userNameField = By.xpath("//label[text()='Имя']/following::input");
    //field емаил
    private final By userEmailField = By.xpath("//label[text()='Email']/following::input");
    //field пароль
    private final By userPasswordField = By.xpath("//label[text()='Пароль']/following::input");
    //button зарегистрироваться
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    //warning неккоректный пароль
    private final By invalidPasswordError = By.xpath(".//p[text()='Некорректный пароль']");
    //button Войти
    private final By enterButton = By.xpath("//a[text()='Войти']");

    @Step("Клик по кнопке Регистрация")
    public void clickToRegisterButton() {
        driver.findElement(registerButton).click();
    }
    @Step("Клик по ссылке Войти")
    public void clickToLoginLink() {
        driver.findElement(enterButton).click();
    }
    @Step("Ввести имя пользователя")
    public void setUserNameField(String userName) {
        driver.findElement(userNameField).sendKeys(userName);
    }
    @Step("Ввести почту пользователя")
    public void setUserEmailField(String userEmail) {
        driver.findElement(userEmailField).sendKeys(userEmail);
    }
    @Step("Ввести пароль пользователя")
    public void setUserPasswordField(String userPassword) {
        driver.findElement(userPasswordField).sendKeys(userPassword);
    }
    @Step("Заполнить форму регистрации")
    public void fillRegistrationForm(String userName, String userEmail, String userPassword) {
        setUserNameField(userName);
        setUserEmailField(userEmail);
        setUserPasswordField(userPassword);
    }
    @Step("Проверить, что сообщение об ошибке регистрации отображается")
    public void isPasswordErrorDisplayed() {
        assertThat("При попытке зарегистрироваться с паролем короче 6 символов отображается варнинг", true, equalTo(driver.findElement(invalidPasswordError).isDisplayed()));
    }
    @Step("переход на регистрацию")
    public void assertCurrentUrl() {
        assertThat("Происходит переход на страницу Регистрации", REGISTRATION_PAGE, equalTo(driver.getCurrentUrl()));
    }
}
