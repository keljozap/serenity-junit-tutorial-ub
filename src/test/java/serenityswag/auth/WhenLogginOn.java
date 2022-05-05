package serenityswag.auth;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import serenityswag.auth.actions.LoginActions;
import serenityswag.inventory.InventoryPage;
import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.auth.User.STANDARD_USER;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenLogginOn{

    @Managed
    WebDriver driver;

    //Steps anotation is for actions we do
    @Steps
    LoginActions login;

    //Objects which we interact to
    InventoryPage invPage;
    @Test
    public void usersCanLogOnViaTheHomePage(){

        login.as(STANDARD_USER);
        //assertThat(driver.findElement(By.cssSelector(".title")).getText()).isEqualToIgnoringCase("Products");
        //This method is for the assertion appears on the report, this using serenity.reportThat
        Serenity.reportThat("The inventory page should be displayed with the correct title",
                () ->  assertThat(invPage.getHeading()).isEqualToIgnoringCase("Products"));
       ;
    }

}
