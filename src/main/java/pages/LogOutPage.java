package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utiles.DriverMange.DriverManager;
import utiles.commonHelper.ElementsHelper.AssertionHelper;
import utiles.commonHelper.ElementsHelper.BaseElementHelper;

public class LogOutPage {
    //Variables
    WebDriver driver;

    //Locators
    private final By logoutLink = By.cssSelector("a[href='/logout']");

    //Constructor
    public LogOutPage() {
        this.driver = DriverManager.getDriver();
    }

    //Actions
    public LogOutPage clickOnLogOutButton(){
        BaseElementHelper.click(driver,logoutLink);
        return this;
    }
    public void assertRedirectionOfURL(){
        AssertionHelper.assertUrl(driver,"https://www.automationexercise.com/login");
    }
}
