package stellarburgers.pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage {
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Выход')]")
    private SelenideElement exitButton;

    public boolean isExitButtonDisplayed() {
        return exitButton.shouldBe(Condition.visible).isDisplayed();
    }
    public void clickToExitButton() {
        exitButton.shouldBe(Condition.visible).click();
    }
}
