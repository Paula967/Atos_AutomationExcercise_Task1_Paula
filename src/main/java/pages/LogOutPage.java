package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utiles.DriverMange.DriverManager;
import utiles.commonHelper.AssertionHelper;
import utiles.commonHelper.ElementHelper;

public class LogOutPage {
    //Variables
    WebDriver driver;

    //Locators
    By logoutLink = By.cssSelector("a[href='/logout']");

    //Constructor
    public LogOutPage() {
        this.driver = DriverManager.getDriver();
    }

    //Actions
    public LogOutPage clickOnLogOutButton(){
        ElementHelper.click(driver,logoutLink);
        return this;
    }
    public void assertRedirectionOfURL(){
        AssertionHelper.assertUrl(driver,"https://www.automationexercise.com/login");
    }
}
