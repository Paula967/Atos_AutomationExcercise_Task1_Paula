package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utiles.DriverMange.DriverManager;
import utiles.commonHelper.AssertionHelper;
import utiles.commonHelper.ElementHelper;

public class AddToCartPage {
        WebDriver driver;

        // Locators
        By quantityInput = By.cssSelector("input[name='quantity']");
        By addToCartButton = By.cssSelector(".cart");
        By successMessage = By.cssSelector(".modal-body p:first-child");
        //By cartBadge = By.cssSelector(".cart-count");
        By continueShoppingButton=By.cssSelector(".btn-block");
        By productsLink=By.cssSelector("a[href='/products']");
        //Add First Product in Products Page => Product B
        By addToCartOnProductsPage=By.xpath("(//*[contains(text(),'Add to cart')])[1]");
        By viewCartButton = By.xpath("//u[normalize-space()='View Cart']/..");
        By cartProductNames = By.cssSelector("tbody h4");
        By cartProductQuantities = By.cssSelector("td button");
        By cartProductPrices = By.cssSelector(".cart_price");
        By cartTotalAmount = By.cssSelector(".cart_total_price");
        By proceedToCheckOutButton=By.cssSelector(".check_out");

        public AddToCartPage() {
            this.driver = DriverManager.getDriver();
        }

        public AddToCartPage setProductQuantity(Double quantity) {
            int intQuantity = quantity.intValue();
            ElementHelper.sendText(driver, quantityInput, String.valueOf(intQuantity));
            return this;
        }

        public AddToCartPage clickAddToCart() {
            ElementHelper.click(driver,addToCartButton);
            return this;
        }

        public AddToCartPage assertSuccessMessageDisplayed() {
            AssertionHelper.assertElementPresent(driver, successMessage);
            return this;
        }

         public AddToCartPage continueShopping(){
             ElementHelper.click(driver,continueShoppingButton);
             ElementHelper.click(driver,productsLink);
             return this;
         }
         public AddToCartPage clickOnAddToCartFromProductsPage(){
             ElementHelper.click(driver,addToCartOnProductsPage);
             return this;
         }

        public AddToCartPage goToCart() {
            ElementHelper.click(driver,viewCartButton);
            return this;
        }

        public String getCartProductName(Double index) {
            int intIndex = index.intValue();
            return ElementHelper.getElementTextByIndex(driver,cartProductNames,intIndex);
        }

        public int getCartProductQuantity(Double index) {
            int intIndex = index.intValue();
            return Integer.parseInt(ElementHelper.getElementTextByIndex(driver,cartProductQuantities,intIndex));
        }

        public double getCartProductPrice(Double index) {
            int intIndex = index.intValue();
            return Double.parseDouble(ElementHelper.getElementTextByIndex(driver,cartProductPrices,intIndex).replace("Rs. ", ""));
        }

        public double getCartTotalAmount(Double index) {
            int intIndex = index.intValue();
            return Double.parseDouble(ElementHelper.getElementTextByIndex(driver,cartTotalAmount,intIndex).replace("Rs. ", ""));
        }
        public AddToCartPage assertProductNamesByIndex(Double index,String ExpectedName){
            AssertionHelper.assertEqual(getCartProductName(index),ExpectedName);
            return this;
        }
        public AddToCartPage assertProductQuantitiesByIndex(Double index,Double ExpectedQuantity){
            int intExpectedQuantity = ExpectedQuantity.intValue();
            AssertionHelper.assertEqual(getCartProductQuantity(index),intExpectedQuantity);
            return this;
        }
        public AddToCartPage assertProductPricesByIndex(Double index,Double ExpectedPrice){
            AssertionHelper.assertEqual(getCartProductPrice(index),ExpectedPrice);
            return this;
        }
        public AddToCartPage assertTotalAmountByIndex(Double index){
            //TotalAmount for Every Product = Price * Quantity
            double ExpectedtotalAmount= getCartProductPrice(index) * getCartProductQuantity(index);
            AssertionHelper.assertEqual(getCartTotalAmount(index),ExpectedtotalAmount);
            return this;
        }
        public CheckOutPage clickOnProceedToCheckOut(){
            ElementHelper.click(driver,proceedToCheckOutButton);
            return new CheckOutPage();
        }
    }
