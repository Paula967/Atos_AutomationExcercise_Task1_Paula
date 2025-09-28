package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utiles.DriverMange.DriverManager;
import utiles.commonHelper.AssertionHelper;
import utiles.commonHelper.ElementHelper;

public class CheckOutPage {

    //Variables
    WebDriver driver;

    //Locators
    By deliveryAddress= By.cssSelector("ul[id='address_delivery'] li:nth-child(4)");
    By city_State_PostCode=By.cssSelector("ul[id='address_delivery'] li[class='address_city address_state_name address_postcode']");
    By placeOrderButton=By.cssSelector(".btn.btn-default.check_out");

    //Constructor
    public CheckOutPage() {
        this.driver = DriverManager.getDriver();
    }

    //Actions
    public CheckOutPage assertDeliveryAddress(String expectedAddress){
        AssertionHelper.assertElementText(driver,deliveryAddress,expectedAddress);
        return this;
    }
    public CheckOutPage assertCityStatePostCode(String expectedCity,String expectedState, String expectedPostCode){
        AssertionHelper.assertContains(driver,city_State_PostCode,expectedCity);
        AssertionHelper.assertContains(driver,city_State_PostCode,expectedState);
        AssertionHelper.assertContains(driver,city_State_PostCode,expectedPostCode);
        return this;
    }
    public PaymentPage clickPlaceOrderButton(){
        ElementHelper.click(driver,placeOrderButton);
        return new PaymentPage();
    }
}
