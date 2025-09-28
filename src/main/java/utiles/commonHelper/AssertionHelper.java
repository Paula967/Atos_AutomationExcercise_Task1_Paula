package utiles.commonHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class AssertionHelper {
    // Assert element is present and displayed
    public static void assertElementPresent(WebDriver driver, By locator) {
        try {
            boolean isDisplayed = ElementHelper.waitForVisibility(driver, locator).isDisplayed();
            Assert.assertTrue(isDisplayed, "❌ Element not displayed: " + locator);
        } catch (NoSuchElementException e) {
            Assert.fail("❌ Element not found: " + locator);
        }
    }
    public static void assertTextPresent(WebDriver driver, By locator,String text) {
        try {
            boolean isDisplayed =ElementHelper.isTextPresentInElement(driver,locator,text);
            Assert.assertTrue(isDisplayed, "❌ Text not displayed: " + text);
        } catch (NoSuchElementException e) {
            Assert.fail("❌ Element not found: " + locator);
        }
    }
    // Assert current URL matches expected URL
    public static void assertUrl(WebDriver driver, String expectedUrl) {
        String actualUrl = ElementHelper.getCurrentUrl(driver);
        Assert.assertEquals(actualUrl, expectedUrl,
                "❌ Expected URL: " + expectedUrl + " but found: " + actualUrl);
    }

    // Assert that object is not null
    public static void assertNotNull(Object object, String message) {
        Assert.assertNotNull(object, "❌ " + message);
    }

    // Assert that object is null
    public static void assertNull(Object object, String message) {
        Assert.assertNull(object, "❌ " + message);
    }

    // Assert a condition is true
    public static void assertTrue(boolean condition, String message) {
        Assert.assertTrue(condition, "❌ " + message);
    }

    // Assert a condition is false
    public static void assertFalse(boolean condition, String message) {
        Assert.assertFalse(condition, "❌ " + message);
    }

    // Assert equality for strings with better messages
    public static void assertEqual(String actual, String expected) {
        Assert.assertEquals(actual, expected,
                "❌ Expected: [" + expected + "] but found: [" + actual + "]");
    }
    // Assert equality for numbers
    public static void assertEqual(Number actual, Number expected) {
        Assert.assertEquals(actual, expected,
                "❌ Expected: [" + expected + "] but found: [" + actual + "]");
    }
    // Assert text of a web element matches expected value
    public static void assertElementText(WebDriver driver, By locator, String expectedText) {
        String actualText = ElementHelper.waitForVisibility(driver, locator).getText();
        Assert.assertEquals(actualText.trim(), expectedText.trim(),
                "❌ Text mismatch! Expected: [" + expectedText + "] but found: [" + actualText + "]");
    }
    //Assert All Elements Are Visible
    public static void assertElementsVisibility(WebDriver driver,By Locator){
        try {
            boolean isDisplayed = ElementHelper.areAllProductsVisible(driver,Locator);
            Assert.assertTrue(isDisplayed, "❌ Elements not displayed: " + Locator);
        } catch (NoSuchElementException e) {
            Assert.fail("❌ Elements not found: " + Locator);
        }
    }
    public static void assertListContainsSpecificElement(WebDriver driver,By Locator,String Element){
        List<String> items=ElementHelper.getAllElementsText(driver,Locator);
        for (String item : items) {
            Assert.assertTrue(
                    item.toLowerCase().contains(Element.toLowerCase()),
                    "❌ The product '" + item + "' does not contain the keyword: " + Element
            );
        }
    }
    public static void assertContains(WebDriver driver,By Locator, String ExpectedText){
        String actualText=ElementHelper.getText(driver,Locator);
        Assert.assertTrue(actualText.toLowerCase().contains(ExpectedText.toLowerCase()),
                "❌ Expected text: [" + ExpectedText + "] not found in actual text: [" + actualText + "]");
    }
}
