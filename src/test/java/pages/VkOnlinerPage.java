package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VkOnlinerPage extends BasePage{
    private final SelenideElement groupTitle = $(".basisGroup__groupTitle");
    private final SelenideElement loginButton = $(".wide_link");

    @Override
    protected SelenideElement getPageIdentifier() {return loginButton;}

    @Step("Check if page is opened")
    public VkOnlinerPage checkIfVkPageOpen(){
        switchTo().window(1);
        checkPageIsOpened();
        assertEquals("onlíner", groupTitle.getText());
        return this;
    }
}
