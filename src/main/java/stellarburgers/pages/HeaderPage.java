package stellarburgers.pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
    private final WebDriver driver;
    public HeaderPage(WebDriver driver){
        this.driver = driver;
    }
    //button Профиль
    private final By userAcButton = By.xpath("//p[text()='Личный Кабинет']");
    //LOGO
    private final By logo = By.xpath("//div[contains(@class, 'AppHeader_header__logo')]");
    //Лента заказов
    private final By orderListButton = By.xpath("//p[contains(text(),'Лента Заказов')]");
    //Конструктор
    private final By constructorButton = By.xpath("//p[text()='Конструктор']");

    @Step("Перейти в Личный кабинет")
    public void clickToAccButton() {
         driver.findElement(userAcButton).click();
    }
    @Step("Клик по кнопке Конструктор")
    public void clickToConstructorButton() {
        driver.findElement(constructorButton).click();
    }
    @Step("Клик по логотипу")
    public void clickToLogo() {
        driver.findElement(logo).click();
    }
}