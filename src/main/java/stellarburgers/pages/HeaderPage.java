package stellarburgers.pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HeaderPage {
    @FindBy(how = How.XPATH, using = "//*[@href='/account']")
    private SelenideElement userAccountButton;
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logo;
    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Лента Заказов')]")
    private SelenideElement orderListButton;
    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Конструктор')]")
    private SelenideElement constructorButton;

    @Step("Перейти в Личный кабинет")
    public void clickToAccountButton() {
        userAccountButton.shouldBe(Condition.visible).click();
    }
    @Step("Клик по кнопке Конструктор")
    public void clickToConstructorButton() {
        constructorButton.shouldBe(Condition.visible).click();
    }
    @Step("Клик по логотипу")
    public void clickToLogo() {
        logo.shouldBe(Condition.visible).click();
    }
    @Step("Проверка, что кнопка Конструктор доступна")
    public boolean isConstructorButtonEnabled() {
        return constructorButton.is(Condition.enabled);
    }
}