package pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.configurators.JsonConfigurator;
import drivers.LocalMobileDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OnlinerMainPage extends BasePage {
    private final SelenideElement searchField = $(By.className("fast-search__input"));
    private final SelenideElement searchFieldInFrame = $(By.className("search__input"));
    private final SelenideElement searchFrame = $(By.className("modal-iframe"));
    private final SelenideElement firstProductTitle = $(".product__title > a");
    private final SelenideElement cartIcon = $("#cart-mobile");
    private final SelenideElement vkLink = $(".footer-style__social-button_vk");
    private final SelenideElement burgerMenuButton = $(".header-style__underlay");
    private final SelenideElement onlinerLogo = $(".b-top-logo");
    private final SelenideElement burgerMenu = $(".header-style__navigation");
    private final SelenideElement catalog = $(By.xpath("(//span[@class='header-style__sign'])[2]"));

    @Step("Open Onliner main page")
    public OnlinerMainPage open(){
        LocalMobileDriver.getDriver().get(JsonConfigurator.AppSettings.appConfig.baseUrl);
        checkPageIsOpened();

        return this;
    }

    @Override
    protected SelenideElement getPageIdentifier() {
        return onlinerLogo.shouldBe(enabled, waitTimeout);
    }

    @Step("Click cart icon")
    public OnlinerCartPage clickCartIcon(){
        cartIcon.shouldBe(Condition.enabled, waitTimeout).click();

        return new OnlinerCartPage();
    }

    @Step("Click search field")
    public OnlinerMainPage clickSearchField(){
        searchField.shouldBe(Condition.enabled, waitTimeout).click();

        return this;
    }

    @Step("Input {0} into field")
    public OnlinerMainPage inputTextSearchField(String productName){
        switchTo().frame(searchFrame);
        searchFieldInFrame.shouldBe(Condition.enabled, waitTimeout).sendKeys(productName);
        LocalMobileDriver.getDriver().hideKeyboard();

        assertEquals(productName, searchFieldInFrame.getValue(), "The field value does not match the entered data!");
        return this;
    }

    @Step("Checking that the name of the first product in the search result matches the search data")
    public OnlinerMainPage checkFirstProductTitle(String productName){
        firstProductTitle.should(visible, Duration.ofSeconds(5));
        firstProductTitle.shouldHave(text(productName));

        return this;
    }

    @Step("Checking that burger menu is open")
    public OnlinerMainPage checkBurgerMenuIsOpen(){
        assertTrue(burgerMenu.shouldBe(Condition.enabled, waitTimeout).isDisplayed());

        return this;
    }

    @Step("Click VK icon")
    public VkOnlinerPage clickVkIcon(){
        vkLink.shouldBe(Condition.enabled, waitTimeout).click();

        return new VkOnlinerPage();
    }

    @Step("Click catalog")
    public OnlinerCatalogPage clickCatalog(){
        catalog.shouldBe(Condition.enabled, waitTimeout).click(ClickOptions.usingJavaScript());

        return new OnlinerCatalogPage();
    }

    @Step("Click on first product in the list")
    public OnlinerProductPage clickFirstProduct(){
        firstProductTitle.shouldBe(Condition.enabled, waitTimeout).click();

         return new OnlinerProductPage();
    }

    @Step("Click burger menu")
    public OnlinerMainPage clickBurgerMenu(){
        burgerMenuButton.shouldBe(Condition.enabled, waitTimeout).click();

        return this;
    }

    public String getFirstProductTitle(){
        return firstProductTitle.getText();
    }
}
