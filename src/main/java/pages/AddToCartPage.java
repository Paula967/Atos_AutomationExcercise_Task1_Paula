package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utiles.DriverMange.DriverManager;
import utiles.commonHelper.ElementsHelper.AssertionHelper;
import utiles.commonHelper.ElementsHelper.BaseElementHelper;
import utiles.commonHelper.ElementsHelper.JavaScriptHelper;

public class AddToCartPage {
        WebDriver driver;

        // Locators
        private final By quantityInput = By.cssSelector("input[name='quantity']");
        private final By addToCartButton = By.cssSelector(".cart");
        private final By successMessage = By.cssSelector(".modal-body p:first-child");
        private final By continueShoppingButton = By.cssSelector(".btn-block");
        private final By productsLink = By.cssSelector("a[href='/products']");
        private final By addToCartOnProductsPage = By.xpath("(//*[contains(text(),'Add to cart')])[1]");
        private final By viewCartButton = By.xpath("//u[normalize-space()='View Cart']/..");
        private final By cartProductNames = By.cssSelector("tbody h4");
        private final By cartProductQuantities = By.cssSelector("td button");
        private final By cartProductPrices = By.cssSelector(".cart_price");
        private final By cartTotalAmount = By.cssSelector(".cart_total_price");
        private final By proceedToCheckOutButton = By.cssSelector(".check_out");

        public AddToCartPage() {
            this.driver = DriverManager.getDriver();
        }

        public AddToCartPage setProductQuantity(Double quantity) {
            int intQuantity = quantity.intValue();
            BaseElementHelper.sendText(driver, quantityInput, String.valueOf(intQuantity));
            return this;
        }

        public AddToCartPage clickAddToCart() {
            BaseElementHelper.click(driver,addToCartButton);
            return this;
        }

        public AddToCartPage assertSuccessMessageDisplayed() {
            AssertionHelper.assertElementPresent(driver, successMessage);
            return this;
        }

         public AddToCartPage continueShopping(){
             BaseElementHelper.click(driver,continueShoppingButton);
             BaseElementHelper.click(driver,productsLink);
             return this;
         }
         public AddToCartPage clickOnAddToCartFromProductsPage(){
             JavaScriptHelper.jsClickAfterScroll(driver,addToCartOnProductsPage);
             return this;
         }

        public AddToCartPage goToCart() {
            BaseElementHelper.click(driver,viewCartButton);
            return this;
        }

        public String getCartProductName(Double index) {
            int intIndex = index.intValue();
            return BaseElementHelper.getElementTextByIndex(driver,cartProductNames,intIndex);
        }

        public int getCartProductQuantity(Double index) {
            int intIndex = index.intValue();
            return Integer.parseInt(BaseElementHelper.getElementTextByIndex(driver,cartProductQuantities,intIndex));
        }

        public double getCartProductPrice(Double index) {
            int intIndex = index.intValue();
            return Double.parseDouble(BaseElementHelper.getElementTextByIndex(driver,cartProductPrices,intIndex).replace("Rs. ", ""));
        }

        public double getCartTotalAmount(Double index) {
            int intIndex = index.intValue();
            return Double.parseDouble(BaseElementHelper.getElementTextByIndex(driver,cartTotalAmount,intIndex).replace("Rs. ", ""));
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
            BaseElementHelper.click(driver,proceedToCheckOutButton);
            return new CheckOutPage();
        }
    }
