import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.CheckOutPage;
import utiles.ExtentReports.ExtentReportListener;
import utiles.datareaders.DataProviderUtils;
import utiles.datareaders.JsonFile;

@Listeners(ExtentReportListener.class)
public class CheckOutPageTest extends BaseTest{

    CheckOutPage checkOutPage;
    AddToCartPage addToCartPage;

    @BeforeTest
    public void setUp(){
        checkOutPage= new CheckOutPage();
        addToCartPage= new AddToCartPage();
    }
    @Test(dataProvider = "jsonDataProvider", dataProviderClass = DataProviderUtils.class)
    @JsonFile("src/test/resources/AddressTestData.json")
    public void testVerifyDeliveryAddressAndPlaceOrder(String address, String city, String state, String postCode) {
        checkOutPage=addToCartPage.clickOnProceedToCheckOut();
        checkOutPage
                .assertDeliveryAddress(address)
                .assertCityStatePostCode(city,state,postCode)
                .clickPlaceOrderButton();
    }
}
