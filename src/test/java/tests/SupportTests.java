package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.EnterPage;

@DisplayName("Support tests")
public class SupportTests extends BaseTest{
    EnterPage enterPage = new EnterPage();

    @DisplayName("Support FAQ test")
    @Owner("Daniil Borisevich")
    @Test
    void checkSupportFAQ() {
        enterPage
                .clickOkButton()
                .verifyIfWelcomePageIsOpen()
                .clickSupportButton()
                .verifyIfWelcomePageIsOpen()
                .clickFAQ()
                .verifyIfFAQPageIsOpen();
    }

    @DisplayName("Support Chat test")
    @Owner("Daniil Borisevich")
    @Test
    void checkSupportChat() {
        enterPage
                .clickOkButton()
                .verifyIfWelcomePageIsOpen()
                .clickSupportButton()
                .verifyIfWelcomePageIsOpen()
                .clickChat()
                .verifyIfChatPageIsOpen();
    }
}
