package stellarburgers.pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ProfilePage {
    private final WebDriver driver;
    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }
    public static final String ACCOUNT_PAGE = "https://stellarburgers.nomoreparties.site/account";
    public static final String ACCOUNT_PROFILE_PAGE = "https://stellarburgers.nomoreparties.site/account/profile";
    private final By exitButton = By.xpath(".//button[text()='Выход']");
    @Step("Нажать на кнопку удалить")
    public void clickToExitButton() {
        driver.findElement(exitButton).click();
    }
    public void assertCurUrl() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe((ACCOUNT_PROFILE_PAGE)));
        assertThat("Происходит переход на страницу Личного кабинета", ACCOUNT_PROFILE_PAGE, equalTo(driver.getCurrentUrl()));
    }
}
