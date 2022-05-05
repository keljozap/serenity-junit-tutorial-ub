package serenityswag.auth.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import serenityswag.auth.User;

public class LoginActions extends UIInteractionSteps {

    @Step("Log in as {0}")
    public void as(User user){
        //Code commented is code that we use if we don't extend from UIInteractionsSteps class
        //driver.get("https://www.saucedemo.com/");
        openUrl("https://www.saucedemo.com/");
        //driver.findElement(By.cssSelector("[data-test='username']")).sendKeys("standard_user");
        //driver.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");
        //driver.findElement(By.cssSelector("[data-test='login-button']")).click();

        //Locate an object using css selector and find by id method (Same thing)
        //find("[data-test='username']").sendKeys(user.getUserName());
        //find(By.id("user-name")).sendKeys(user.getUserName());
        //Using css selector instead
        $("#user-name").sendKeys(user.getUserName());
        //$("[data-test='password']").sendKeys(user.getPassword());
        //Using css selector instead
        $("#password").sendKeys(user.getPassword());
        //Other form to do the same
        //$("[name=password]").sendKeys(user.getPassword());
        //$("[data-test='login-button']").click();
        $("#login-button").click();
    }
}
