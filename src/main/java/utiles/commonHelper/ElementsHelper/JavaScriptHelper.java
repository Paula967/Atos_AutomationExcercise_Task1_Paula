package utiles.commonHelper.ElementsHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper {
    public static WebElement scrollToElement(WebDriver driver, By locator) {
        WebElement element = WaitHelper.waitForVisibility(driver, locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    public static void jsClick(WebDriver driver, By locator) {
        WebElement element = WaitHelper.waitForClickable(driver, locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public static void jsClickAfterScroll(WebDriver driver, By locator) {
        WebElement element=scrollToElement(driver,locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

    }
    public static void jsClickOnElementByIndex(WebDriver driver,int index, String text){
        WebElement element=BaseElementHelper.findElementByIndex(driver,index,text);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public static void highlightElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
    }

}
