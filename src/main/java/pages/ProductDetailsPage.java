package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utiles.DriverMange.DriverManager;
import utiles.commonHelper.ElementsHelper.AssertionHelper;

public class ProductDetailsPage {
    //Variables
    WebDriver driver;

    //Locators
    private final By productName=By.cssSelector(".product-information h2");
    private final By productCategory=By.xpath("//p[contains(text(), 'Category')]");
    private final By productPrice=By.cssSelector("div[class='product-information'] span span");


    //Constructor
    public ProductDetailsPage() {
        this.driver = DriverManager.getDriver();
    }

    //Actions
    public ProductDetailsPage assertProductNameIsDisplayed(){
        AssertionHelper.assertElementPresent(driver,productName);
        return this;
    }
    public ProductDetailsPage assertProductCategoryIsDisplayed(){
        AssertionHelper.assertElementPresent(driver,productCategory);
        return this;
    }
    public ProductDetailsPage assertProductPriceIsDisplayed(){
        AssertionHelper.assertElementPresent(driver,productPrice);
        return this;
    }

}
