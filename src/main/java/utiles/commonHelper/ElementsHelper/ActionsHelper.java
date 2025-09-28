package utiles.commonHelper.ElementsHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsHelper {

    public static void hoverOver(WebDriver driver, By locator) {
        Actions actions = new Actions(driver);
        WebElement element = WaitHelper.waitForVisibility(driver, locator);
        actions.moveToElement(element).perform();
    }

}
