package stellarburgers.pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainPage extends AppConfig {
    private final WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    public static final String MAIN_PAGE = "https://stellarburgers.nomoreparties.site/";
    //button Войти в аккаунт
    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    //button Оформить заказ
    private final By makeOrderButton = By.xpath("//button[text()='Оформить заказ']");
    // section Булки
    private final By bunsSectionActive = By.xpath("//div[contains(span/text(),'Булки') and contains(@class,'current')]");
    private final By bunsSectionUnactive = By.xpath("//div[contains(span/text(),'Булки') and not(contains(@class,'current'))]");
    //section 'Соусы'
    private final By saucesSectionActive = By.xpath("//div[contains(span/text(),'Соусы') and contains(@class,'current')]") ;
    private final By saucesSectionUnactive = By.xpath("//div[contains(span/text(),'Соусы') and not(contains(@class,'current'))]") ;
    //section Начинки
    private final By ingredientsSectionActive = By.xpath("//div[contains(span/text(),'Начинки') and contains(@class,'current')]");
    private final By ingredientsSectionUnactive = By.xpath("//div[contains(span/text(),'Начинки') and not(contains(@class,'current'))]");


    @Step("Клик по кнопке Войти в аккаунт на главой странице")
    public void clickToLoginButton() {
        driver.findElement(loginButton).click();
    }
    @Step("Открыть раздел Начинки")
    public void openIngredientSection() {
        driver.findElement(ingredientsSectionUnactive).click();
    }
    @Step("Открыть раздел 'Соусы'")
    public void openSaucesSection() {
        driver.findElement(saucesSectionUnactive).click();
    }
    @Step("Открыть раздел 'Булки'")
    public void openBunsSection() {
        driver.findElement(bunsSectionUnactive).click();
    }
    @Step("Проверить, что раздел Начинки открылся")
    public boolean isIngredientsSectionOpen() {
        return driver.findElement(ingredientsSectionActive).isDisplayed();
    }
    @Step("Проверить, что раздел Соусы открылся")
    public boolean isSaucesSectionOpen() {
        return driver.findElement(saucesSectionActive).isDisplayed();
    }
    @Step("Проверить, что раздел Булки открылся")
    public boolean isBunsSectionOpen() {
        return driver.findElement(bunsSectionActive).isDisplayed();
    }
    @Step("Проверить, что кнопка Оформить заказ отображается")
    public void isMakeOrderButtonDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(makeOrderButton));
        assertThat("Отображается кнопка Оформить заказ", true, equalTo(driver.findElement(makeOrderButton).isDisplayed()));
    }
    @Step("Проверка перехода на Главную страницу")
    public void assertCurrentUrl() {
        assertThat("Происходит переход на Главную страницу", MAIN_PAGE, equalTo(driver.getCurrentUrl()));
    }
}