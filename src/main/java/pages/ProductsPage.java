package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utiles.DriverMange.DriverManager;
import utiles.commonHelper.ElementsHelper.AssertionHelper;
import utiles.commonHelper.ElementsHelper.BaseElementHelper;
import utiles.commonHelper.ElementsHelper.JavaScriptHelper;

public class ProductsPage {

    //Variables
    WebDriver driver;

    //Locators
    By productsItem=By.cssSelector(".features_items > .col-sm-4");
    By searchProductText=By.id("search_product");
    By searchButton=By.id("submit_search");
    By resultProducts=By.cssSelector(".productinfo p");
    //By viewProduct=By.xpath("//*[text()='View Product']");

    //Constructor
    public ProductsPage() {
        this.driver = DriverManager.getDriver();
    }

    //Actions
    public ProductsPage verifyAllProductsVisible(){
        AssertionHelper.assertElementsVisibility(driver,productsItem);
        return this;
    }
    public ProductsPage searchForProduct(String Product){
        BaseElementHelper.sendText(driver,searchProductText,Product);
        return this;
    }
    public ProductsPage clickOnSearchButton(){
        BaseElementHelper.click(driver,searchButton);
        return this;
    }
    public ProductDetailsPage viewOneProduct(){
        JavaScriptHelper.jsClickOnElementByIndex(driver,2,"View Product");
        return new ProductDetailsPage();
    }
    public ProductsPage verifyMatchingProductResult(String Product){
        AssertionHelper.assertListContainsSpecificElement(driver,resultProducts,Product);
        return this;
    }
    /*
    public ProductsPage printAllElementsText() {
        List<String> texts = ElementHelper.getAllElementsText(driver,resultProducts);

        if (texts.isEmpty()) {
            System.out.println("⚠️ No elements found for locator: " + resultProducts);
        } else {
            System.out.println("✅ Found " + texts.size() + " elements:");

            for (String text : texts) {
                System.out.println("- " + text);
            }
        }
        return this;
    }*/

}
