package pages.onliner;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnlinerCatalogPage extends BasePage {
    private final SelenideElement catalogNavigationTitle = $(".catalog-navigation > .catalog-navigation__title");
    private final SelenideElement onlinerLogo = $(".b-top-logo");
    @Override
    protected SelenideElement getPageIdentifier() {
        return catalogNavigationTitle.shouldBe(Condition.enabled, waitTimeout);
    }

    @Step("Click main onliner icon")
    public OnlinerMainPage clickOnlinerIcon(){
        onlinerLogo.shouldBe(Condition.enabled, waitTimeout).click();

        return new OnlinerMainPage();
    }

    @Step("Check if Catalog page is opened")
    public OnlinerCatalogPage checkIfCatalogPageIsOpen(){
        checkPageIsOpened();
        assertEquals("КаталогВсе суперцены!", catalogNavigationTitle.shouldBe(Condition.enabled, waitTimeout).getText());
        return this;
    }
}
