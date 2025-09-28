import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import utiles.ExtentReports.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class ProductDetailsTest extends BaseTest{

    ProductDetailsPage productDetailsPage;

    @BeforeTest
    public  void setUp(){
        productDetailsPage=new ProductDetailsPage();
    }

    @Test(testName = "Product Details Verification")
    public void productDetails(){
        productDetailsPage
                .assertProductNameIsDisplayed()
                .assertProductCategoryIsDisplayed()
                .assertProductPriceIsDisplayed();
    }
}
