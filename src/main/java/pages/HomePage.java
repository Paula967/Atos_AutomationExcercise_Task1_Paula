package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utiles.DriverMange.DriverManager;
import utiles.commonHelper.ElementHelper;

public class HomePage {

    //Variables
    WebDriver driver;

    //Locators
    By SignInUp = By.linkText("Signup / Login");
    By productsLink=By.cssSelector("a[href='/products']");

    //Constructor
public HomePage() {
        this.driver = DriverManager.getDriver();
    }

    //Actions
    public void clickOnSignInUpLink() {
        ElementHelper.click(driver,SignInUp);
    }

    public ProductsPage clickOnProductsLink(){
    ElementHelper.click(driver,productsLink);
    return new ProductsPage();
    }
}
