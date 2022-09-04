package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.apps.EnterPage;

@DisplayName("Support tests")
public class SupportTests extends BaseTest{
    EnterPage enterPage = new EnterPage();

    @DisplayName("Support FAQ test")
    @Owner("Daniil Borisevich")
    @Test
    void supportFAQTest() {
        enterPage
                .clickOkButton()
                .verifyIfWelcomePageIsOpen()
                .clickSupportButton()
                .verifyIfWelcomePageIsOpen()
                .clickFAQ()
                .verifyIfFAQPageIsOpen();
    }

    @DisplayName("New Customer test")
    @Owner("Daniil Borisevich")
    @Test
    void newCustomerTest() {
        enterPage
                .clickOkButton()
                .verifyIfWelcomePageIsOpen()
                .clickNewCustomerButton()
                .verifyIfNewCustomerPageIsOpen()
                .verifyIfTextOfPageIsCorrect();
    }


    @DisplayName("Support Chat test")
    @Owner("Daniil Borisevich")
    @Test
    void supportChatTest() {
        enterPage
                .clickOkButton()
                .verifyIfWelcomePageIsOpen()
                .clickSupportButton()
                .verifyIfWelcomePageIsOpen()
                .clickChat()
                .verifyIfChatPageIsOpen();
    }
}
