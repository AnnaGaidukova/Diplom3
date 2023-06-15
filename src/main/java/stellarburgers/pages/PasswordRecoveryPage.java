package stellarburgers.pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    private final WebDriver driver;
    public PasswordRecoveryPage(WebDriver driver){
        this.driver = driver;
    }
    public static final String RECOVERY_PASSWORD_PAGE = "https://stellarburgers.nomoreparties.site/forgot-password";
    private final By emailField = By.xpath("//*[@name='name']");
    private final By loginLink = By.xpath("//*[@href='/login']");

    @Step("Клик по ссылке Войти")
    public void clickToLoginLink(){
        driver.findElement(loginLink).click();
    }

}
