package pages.onliner;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnlinerCartPage extends BasePage {
    private final SelenideElement title = $(".cart-form__title");

    @Override
    protected SelenideElement getPageIdentifier() {
        return title.shouldBe(Condition.enabled, waitTimeout);
    }

    @Step("Check if page is opened")
    public OnlinerCartPage checkIfCartPageIsOpen(){
        checkPageIsOpened();
        assertEquals("Корзина",title.getText());
        return this;
    }
}
