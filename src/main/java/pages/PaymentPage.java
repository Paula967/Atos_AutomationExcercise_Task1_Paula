package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utiles.DriverMange.DriverManager;
import utiles.commonHelper.ElementHelper;

public class PaymentPage {

    //Variables
    WebDriver driver;

    //Locators
    By nameOnCard= By.cssSelector("input[name='name_on_card']");
    By cardNumber= By.cssSelector("input[name='card_number']");
    By cvc= By.cssSelector("input[name='cvc']");
    By expiryMonth= By.cssSelector("input[name='expiry_month']");
    By expiryYear= By.cssSelector("input[name='expiry_year']");
    By payAndConfirmOrderButton= By.id("submit");
    By orderMessage=By.cssSelector("div[id='success_message'] div[class='alert-success alert']");

    //Constructor
    public PaymentPage() {
        this.driver = DriverManager.getDriver();
    }

    //Actions
    public PaymentPage enterCreditCardDetails(String name, String number, String cvc,String month, String year){
        ElementHelper.sendText(driver,nameOnCard,name);
        ElementHelper.sendText(driver,cardNumber,number);
        ElementHelper.sendText(driver,this.cvc,cvc);
        ElementHelper.sendText(driver,expiryMonth,month);
        ElementHelper.sendText(driver,expiryYear,year);
        return this;
    }
    public PaymentPage clickPayAndConfirmOrderButton(){
        ElementHelper.click(driver,payAndConfirmOrderButton);
        return this;
    }
    public String getMessage(){
        return ElementHelper.getText(driver,orderMessage);
    }
}
