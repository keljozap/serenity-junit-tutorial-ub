package serenityswag.inventory;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import serenityswag.auth.User;
import serenityswag.auth.actions.LoginActions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.auth.User.STANDARD_USER;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenViewingHighlightedProducts {

    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    ProductListPageObject plist;

    ProductDetailsPage pdetails;

    @Test
    public void shouldDisplayHighlightedProductsOnTheWelcomePage(){
        login.as(STANDARD_USER);
        List<String> productsOnDisplay = plist.titles();
        Serenity.reportThat("The products on the welcome page should contain 6 elements",
                () -> assertThat(productsOnDisplay).hasSize(6).contains("Sauce Labs Backpack"));
    }

    @Test
    public void shouldDisplayCorrectProductDetailsPage(){
        login.as(STANDARD_USER);

        String firstItemName = plist.titles().get(0);
        plist.openProductDetailsFor(firstItemName);

        assertThat(pdetails.productName()).isEqualTo(firstItemName);

        Serenity.reportThat("The image should has the value of" + firstItemName,
                () ->pdetails.productImageWithAltValueOf(firstItemName).shouldBeVisible());
    }

    @Test
    public void highlightedProductsShouldDisplayTheCorrespondingImages(){
        login.as(STANDARD_USER);
        List<String> productsOnDisplay = plist.titles();

        //This methos allows us to fail at the last time, I mean, if the methos gets two images the methos won't fail for that
        SoftAssertions softy = new SoftAssertions();
        productsOnDisplay.forEach(
                productName -> softy.assertThat(plist.imageTextForProduct(productName)).isEqualTo(productName)
        );
        softy.assertAll();

    }
}
