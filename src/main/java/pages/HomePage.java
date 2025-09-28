package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utiles.DriverMange.DriverManager;
import utiles.commonHelper.ElementsHelper.BaseElementHelper;

public class HomePage {

    //Variables
    WebDriver driver;

    //Locators
    private final By SignInUp = By.linkText("Signup / Login");
    private final By productsLink=By.cssSelector("a[href='/products']");

    //Constructor
public HomePage() {
        this.driver = DriverManager.getDriver();
    }

    //Actions
    public void clickOnSignInUpLink() {
        BaseElementHelper.click(driver,SignInUp);
    }

    public ProductsPage clickOnProductsLink(){
    BaseElementHelper.click(driver,productsLink);
    return new ProductsPage();
    }
}
