package pages.socialNetworks;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwitterPage extends BasePage {
    private final SelenideElement groupName = $(By.xpath("(//span[text()='onlíner'])[1]"));
    @Override
    protected SelenideElement getPageIdentifier() {
        return groupName.shouldBe(Condition.enabled, waitTimeout);
    }

    @Step("Check if Twitter page is opened")
    public TwitterPage checkIfTwitterPageIsOpen(){
        switchTo().window(1);
        checkPageIsOpened();
        assertEquals("onlíner", groupName.shouldBe(Condition.enabled, waitTimeout).getText());
        return this;
    }
}
