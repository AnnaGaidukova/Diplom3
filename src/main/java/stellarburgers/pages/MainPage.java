package stellarburgers.pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

    @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']")
    private SelenideElement loginButton;
    @FindBy(how = How.XPATH, using = "//button[text()='Оформить заказ']")
    private SelenideElement makeOrderButton;
    @FindBy(how = How.XPATH, using = "//*[text()='Булки']")
    private SelenideElement bunsSectionNameLink;
    @FindBy(how = How.XPATH, using = "//*[text()='Соусы']")
    private SelenideElement saucesSectionNameLink;
    @FindBy(how = How.XPATH, using = "//*[text()='Начинки']")
    private SelenideElement ingredientsSectionNameLink;
    @FindBy(how = How.XPATH, using = "//img[@alt='Хрустящие минеральные кольца']")
    private SelenideElement crispyMineralRingsImage;
    @FindBy(how = How.XPATH, using = "//img[@alt='Соус с шипами Антарианского плоскоходца']")
    private SelenideElement sauceWithAntarianFlatheadspikesImage;
    @FindBy(how = How.XPATH, using = "//img[@alt='Флюоресцентная булка R2-D3']")
    private SelenideElement fluorescentBunR2D3Image;
    @FindBy(how = How.XPATH, using = "//span[text()='Булки']")
    private SelenideElement selectedBunSection;
    @FindBy(how = How.XPATH, using = "//span[text()='Соусы']")
    private SelenideElement selectedSaucesSection;
    @FindBy(how = How.XPATH, using = "//span[text()='Начинки']")
    private SelenideElement selectedIngredientsSection;

    @Step("Клик по кнопке Войти в аккаунт на главой странице")
    public void clickToLoginButton() {
        loginButton.click();
    }

    @Step("Открыть раздел Начинки")
    public void openIngredientSection() {
        ingredientsSectionNameLink.shouldBe(Condition.visible).click();
    }
    @Step("Открыть раздел 'Соусы'")
    public void openSaucesSection() {
        saucesSectionNameLink.shouldBe(Condition.visible).click();
    }
    @Step("Открыть раздел 'Булки'")
    public void openBunsSection() {
        bunsSectionNameLink.shouldBe(Condition.visible).click();
    }
    @Step("Скролл к элементу Хрустящие минеральные кольца")
    public void scrollToCrispyMineralRings() {
        crispyMineralRingsImage.scrollIntoView(true);
    }
    @Step("Скролл к элементу Соус с шипами Антарианского плоскоходца")
    public void scrollTosauceWithAntarianFlatheadspikes() {
        sauceWithAntarianFlatheadspikesImage.scrollIntoView(true);
    }
    @Step("Скролл к элементу Флюоресцентная булка R2-D3")
    public void scrollTofluorescentBunR2D3() {
        fluorescentBunR2D3Image.scrollIntoView(true);
    }
    @Step("Проверить, что раздел Начинки открылся")
    public boolean isIngredientsSectionOpen() {
        return selectedIngredientsSection.shouldBe(Condition.visible).isDisplayed();
    }
    @Step("Проверить, что раздел Соусы открылся")
    public boolean isSaucesSectionOpen() {
        return selectedSaucesSection.shouldBe(Condition.visible).isDisplayed();
    }
    @Step("Проверить, что раздел Булки открылся")
    public boolean isBunsSectionOpen() {
        return selectedBunSection.isDisplayed();
    }
    @Step("Проверить, что кнопка 'Сделать заказ' отображается")
    public boolean isMakeOrderButtonDisplayed() {
        return makeOrderButton.shouldBe(Condition.visible).isDisplayed();
    }
}
