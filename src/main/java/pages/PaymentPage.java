package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utiles.DriverMange.DriverManager;
import utiles.commonHelper.ElementsHelper.AssertionHelper;
import utiles.commonHelper.ElementsHelper.BaseElementHelper;
import utiles.commonHelper.ElementsHelper.JavaScriptHelper;

public class PaymentPage {

    //Variables
    WebDriver driver;

    //Locators
    private final By nameOnCard = By.cssSelector("input[name='name_on_card']");
    private final By cardNumber = By.cssSelector("input[name='card_number']");
    private final By cvc = By.cssSelector("input[name='cvc']");
    private final By expiryMonth = By.cssSelector("input[name='expiry_month']");
    private final By expiryYear = By.cssSelector("input[name='expiry_year']");
    private final By payAndConfirmOrderButton = By.id("submit");
    private final By orderMessage = By.cssSelector("h2[data-qa='order-placed'] b");


    //Constructor
    public PaymentPage() {
        this.driver = DriverManager.getDriver();
    }

    //Actions
    public PaymentPage enterCreditCardDetails(String name, String number, String cvc,String month, String year){
        BaseElementHelper.sendText(driver,nameOnCard,name);
        BaseElementHelper.sendText(driver,cardNumber,number);
        BaseElementHelper.sendText(driver,this.cvc,cvc);
        BaseElementHelper.sendText(driver,expiryMonth,month);
        BaseElementHelper.sendText(driver,expiryYear,year);
        return this;
    }
    public PaymentPage clickPayAndConfirmOrderButton(){
        JavaScriptHelper.jsClickAfterScroll(driver,payAndConfirmOrderButton);
        return this;
    }
    public void getMessage(){
       AssertionHelper.assertElementPresent(driver,orderMessage);
    }
}
