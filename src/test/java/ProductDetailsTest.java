import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;

public class ProductDetailsTest extends BaseTest{

    ProductDetailsPage productDetailsPage;

    @BeforeTest
    public  void setUp(){
        productDetailsPage=new ProductDetailsPage();
    }

    @Test()
    public void productDetails(){
        productDetailsPage
                .assertProductNameIsDisplayed()
                .assertProductCategoryIsDisplayed()
                .assertProductPriceIsDisplayed();
    }
}
