package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.onliner.OnlinerMainPage;

@DisplayName("Onliner other tests")
public class OtherTests extends BaseTest{
    OnlinerMainPage onlinerMainPage = new OnlinerMainPage();

    @DisplayName("Cart test")
    @Owner("Daniil Borisevich")
    @Test
    public void cartCheck() {
        onlinerMainPage
                .open()
                .clickBurgerMenu()
                .clickCartIcon()
                .checkIfCartPageIsOpen();
    }

    @DisplayName("VK link test")
    @Owner("Daniil Borisevich")
    @Test
    public void vkLinkTest() {
        onlinerMainPage
                .open()
                .clickVkIcon()
                .checkIfVkPageIsOpen();
    }

    @DisplayName("Facebook link test")
    @Owner("Daniil Borisevich")
    @Test
    public void facebookLinkTest() {
        onlinerMainPage
                .open()
                .clickFacebookIcon()
                .checkIfFacebookPageIsOpen();
    }

    @DisplayName("Twitter link test")
    @Owner("Daniil Borisevich")
    @Test
    public void twitterLinkTest() {
        onlinerMainPage
                .open()
                .clickTwitterIcon()
                .checkIfTwitterPageIsOpen();
    }

    @DisplayName("Onliner main icon test")
    @Owner("Daniil Borisevich")
    @Test
    public void mainIconTest() {
        onlinerMainPage
                .open()
                .clickBurgerMenu()
                .checkBurgerMenuIsOpen()
                .clickCatalog()
                .checkIfCatalogPageIsOpen()
                .clickOnlinerIcon()
                .checkPageIsOpened();
    }
}

