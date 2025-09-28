import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.PaymentPage;
import utiles.ExtentReports.ExtentReportListener;
import utiles.datareaders.DataProviderUtils;
import utiles.datareaders.JsonFile;

@Listeners(ExtentReportListener.class)
public class PaymentPageTest extends BaseTest {
    PaymentPage paymentPage;

    @BeforeTest
    public void setUp(){
        paymentPage=new PaymentPage();
    }
    @Test(dataProvider = "jsonDataProvider", dataProviderClass = DataProviderUtils.class)
    @JsonFile("src/test/resources/CreditCardTestData.json")
    public void paymentTest(String name, String creditNum, String cvc, String month,String year) {

        paymentPage.enterCreditCardDetails(name, creditNum, cvc, month, year)
                .clickPayAndConfirmOrderButton()
                .getMessage();

    }
}
