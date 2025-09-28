import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.CheckOutPage;
import utiles.datareaders.DataProviderUtils;

import java.io.IOException;
import java.util.Iterator;

public class CheckOutPageTest extends BaseTest{

    CheckOutPage checkOutPage;
    AddToCartPage addToCartPage;

    @BeforeTest
    public void setUp(){
        checkOutPage= new CheckOutPage();
        addToCartPage= new AddToCartPage();
    }
    @DataProvider
    public Iterator<Object[]> getData() throws IOException {
        return DataProviderUtils.getData("src/test/resources/AddressTestData.json");
    }
    @Test(dataProvider = "getData")
    public void testVerifyDeliveryAddressAndPlaceOrder(String address, String city, String state, String postCode) {

        checkOutPage=addToCartPage.clickOnProceedToCheckOut();
        checkOutPage
                .assertDeliveryAddress(address)
                .assertCityStatePostCode(city,state,postCode)
                .clickPlaceOrderButton();
    }
}
