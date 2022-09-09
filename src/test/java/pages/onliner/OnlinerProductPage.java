package pages.onliner;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnlinerProductPage extends BasePage {
    private final SelenideElement productTitle = $(".catalog-masthead__title");
    @Override
    protected SelenideElement getPageIdentifier() {
        return productTitle.shouldBe(Condition.enabled, waitTimeout);
    }

    @Step("Check if opened correct product")
    public OnlinerProductPage checkIfOpenedCorrectProduct(String expectedProductTitle){
        assertEquals(expectedProductTitle, productTitle.shouldBe(Condition.enabled, waitTimeout).getText(),
                "Was opened wrong product!");

        return this;
    }
}
