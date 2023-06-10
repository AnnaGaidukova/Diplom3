package stellarburgers.pages;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.pages.extentions.WebDriverFactory;
import stellarburgers.pages.AppConfig;
import stellarburgers.pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class ConstructorTest {
    MainPage mainPage = page(MainPage.class);

    @Before
    public void setUp()  {
        WebDriverFactory.initWebDriver();
        open(AppConfig.URL_MAIN);
    }

    @After
    public void tearDown() {
        WebDriverRunner.clearBrowserCache();
        WebDriverRunner.closeWebDriver();
    }

    @Test
    @DisplayName("Открыть раздел Начинки по клику на название раздела")
    public void openIngredientsSectionFromSectionNameLink() {
        mainPage.openIngredientSection();
        Assert.assertTrue(mainPage.isIngredientsSectionOpen());
    }

    @Test
    @DisplayName("Открыть раздел Начинки по скроллу к элементу")
    public void openIngredientsSectionByScrollToIngredientImage() {
        mainPage.scrollToCrispyMineralRings();
        Assert.assertTrue(mainPage.isIngredientsSectionOpen());
    }
    @Test
    @DisplayName("Открыть раздел Соусы по клику на название раздела")
    public void openSaucesSectionFromSectionNameLink(){
        mainPage.openSaucesSection();
        Assert.assertTrue(mainPage.isSaucesSectionOpen());
    }
    @Test
    @DisplayName("Открыть раздел Соусы по скроллу к элементу")
    public void openSaucesSectionByScrollToSauceImage() {
        mainPage.scrollTosauceWithAntarianFlatheadspikes();
        Assert.assertTrue(mainPage.isSaucesSectionOpen());
    }

    @Test
    @DisplayName("Открыть раздел Булки по клику на название раздела")
    public void openBunsSectionFromSectionNameLink(){
        mainPage.openIngredientSection();
        mainPage.openBunsSection();
        Assert.assertTrue(mainPage.isBunsSectionOpen());
    }

    @Test
    @DisplayName("Открыть раздел 'Булки' по скроллу к элементу")
    public void openBunsSectionByScrollToBunsImage() {
        mainPage.scrollTofluorescentBunR2D3();
        Assert.assertTrue(mainPage.isBunsSectionOpen());
    }
}