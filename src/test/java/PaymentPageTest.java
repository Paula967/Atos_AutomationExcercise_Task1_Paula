import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.PaymentPage;
import utiles.datareaders.DataProviderUtils;
import java.io.IOException;
import java.util.Iterator;

public class PaymentPageTest extends BaseTest {
    PaymentPage paymentPage;

    @BeforeTest
    public void setUp(){
        paymentPage=new PaymentPage();
    }
    @DataProvider
    public Iterator<Object[]> getData() throws IOException {
        return DataProviderUtils.getData("src/test/resources/CreditCardTestData.json");
    }
    @Test(dataProvider = "getData")
    public void paymentTest(String name, String creditNum, String cvc, String month,String year) {

        paymentPage.enterCreditCardDetails(name, creditNum, cvc, month, year)
                .clickPayAndConfirmOrderButton()
                .getMessage();

    }
}
