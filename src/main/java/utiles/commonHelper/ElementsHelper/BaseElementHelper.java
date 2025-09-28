package utiles.commonHelper.ElementsHelper;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseElementHelper {
    private static final int waitingTime = 20;

    /**
     * -----------------------------
     * Can be extracted into a separate class: BaseElementHelper
     * -----------------------------
     **/

    public static WebElement findElementBy(WebDriver driver, By locator) {
        return WaitHelper.waitForVisibility(driver, locator);
    }

    public static WebElement findElementByText(String text, WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[text()='" + text + "']")));

    }
    public static WebElement findElementByValue(String value, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@value='" + value + "']")));
    }

    public static void click(WebDriver driver, By locator) {
        WaitHelper.waitForClickable(driver, locator).click();
    }

    public static void clickOnAcceptAlert(WebDriver driver){
        driver.switchTo().alert().accept();
    }

    public static void sendText( WebDriver driver, By locator,String text) {
        WebElement element = WaitHelper.waitForVisibility(driver, locator);
        element.clear();
        element.sendKeys(text);
    }

    public static String getText(WebDriver driver, By locator) {
        return WaitHelper.waitForVisibility(driver, locator).getText();
    }

    public static List<WebElement> getAllElementsVisible(WebDriver driver, By Locator){
        return WaitHelper.waitForVisibilityOfAllElements(driver,Locator);
    }
    public static List<WebElement> getAllElementsPresence(WebDriver driver,By Locator){
        return WaitHelper.waitForVisibilityOfElements(driver,Locator);
    }
    public static List<String> getAllElementsText(WebDriver driver,By Locator){
        List<WebElement> elements = getAllElementsPresence(driver,Locator);
        List<String> texts = new ArrayList<>();

        for (WebElement element : elements) {
            texts.add(element.getText().trim());
        }

        return texts;
    }
    public static WebElement findElementByTextContains(String text, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'" + text + "')]")));
    }
    public static WebElement findElementByIndex(WebDriver driver,int index,String Text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        return wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//*[contains(text(),'" + Text + "')])["+index+"]")));
    }
    public static List<WebElement> findElements(WebDriver driver,By locator){
        return WaitHelper.waitForVisibilityOfAllElements(driver,locator);

    }
    public static String getElementTextByIndex(WebDriver driver,By locator,int index){
        return findElements(driver,locator).get((index-1)).getText();
    }
    public static  String getCurrentUrl(WebDriver driver){
        return driver.getCurrentUrl();}
    public static List<WebElement> getElements(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        return driver.findElements(locator);
    }

    public static boolean isElementDisplayed(WebDriver driver, By locator) {
        try {
            return WaitHelper.waitForVisibility(driver, locator).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }
    public static boolean isTextPresentInElement(WebDriver driver, By locator, String text) {
        try {
            return WaitHelper.waitForTextToBePresent(driver, locator, text);
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    public static boolean areAllProductsVisible(WebDriver driver, By locator) {
        try {
            List<WebElement> products= getAllElementsVisible(driver,locator);

            if (products.isEmpty()) {
                return false;
            }
            System.out.println("🔎 Found " + products.size() + " products.");

            for (WebElement product : products) {
                if (!product.isDisplayed()) {

                    return false;
                }
            }
            return true;
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }

    }

    public static boolean isElementEnabled(WebDriver driver, By locator) {
        try {
            return WaitHelper.waitForVisibility(driver, locator).isEnabled();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

}
