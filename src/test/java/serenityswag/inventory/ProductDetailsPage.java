package serenityswag.inventory;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementState;
import org.openqa.selenium.By;

public class ProductDetailsPage extends PageObject {
    public String productName() {
        //Using find
        //return find(".inventory_details_name").getText();
        //Using css selector
        return $(".inventory_details_name").getText();
    }

    public WebElementState productImageWithAltValueOf(String firstItemName) {
        return find(By.cssSelector(".inventory_details_container img[alt='" + firstItemName + "']"));
        //Other form
        //return $(".inventory_details_container img[alt='" + firstItemName + "']");
    }
}
