package utiles.commonHelper.ElementsHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utiles.Logs.LogUtiles;

import java.time.Duration;
import java.util.List;

public class WaitHelper {
    private static final int waitingTime = 20;
    public static WebElement waitForVisibility(WebDriver driver, By locator) {
        LogUtiles.info("Waiting for visibility of element located by: " + locator.toString());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(WebDriver driver, By locator) {
        LogUtiles.info("Waiting for element to be clickable located by: " + locator.toString());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static List<WebElement> waitForVisibilityOfAllElements(WebDriver driver, By Locator){
        LogUtiles.info("Waiting for visibility of all elements located by: " + Locator.toString());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locator));
    }
    public static List<WebElement> waitForVisibilityOfElements(WebDriver driver,By Locator){
        LogUtiles.info("Waiting for presence of all elements located by: " + Locator.toString());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locator));
    }
    public static Boolean waitForTextToBePresent(WebDriver driver, By locator, String text) {
        LogUtiles.info("Waiting for text '" + text + "' to be present in element located by: " + locator.toString());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));

    }

    public static void waitForInvisibility(WebDriver driver, By locator) {
        LogUtiles.info("Waiting for invisibility of element located by: " + locator.toString());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitUntilTextPresent(WebDriver driver, By locator, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedText));
    }

    public static WebElement fluentWait(WebDriver driver, By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        return wait.until(driver1 -> driver1.findElement(locator));
    }

    public static void waitForLoaderToDisappear(WebDriver driver, By loaderLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderLocator));
    }

}
