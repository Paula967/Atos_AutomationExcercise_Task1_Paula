package utiles.commonHelper.ElementsHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHelper {
    /**
     * -----------------------------
     * Can be extracted into a separate class: DropdownHelper
     * -----------------------------
     **/

    public static void selectFromDropDownByText(WebDriver driver, By locator , String text) {
        Select select = new Select(WaitHelper.waitForClickable(driver, locator));
        select.selectByVisibleText(text);
    }

    public static void selectFromDropdownByIndex(int index, WebDriver driver, By locator) {
        Select select = new Select(WaitHelper.waitForClickable(driver, locator));
        select.selectByIndex(index);
    }

    public static void selectFromDropdownByValue(String value, WebDriver driver, By locator) {
        Select select = new Select(WaitHelper.waitForClickable(driver, locator));
        select.selectByValue(value);
    }

}
