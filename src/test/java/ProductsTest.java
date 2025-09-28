import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;
import utiles.ExtentReports.ExtentReportListener;
import utiles.datareaders.DataProviderUtils;
import utiles.datareaders.JsonFile;

@Listeners(ExtentReportListener.class)
public class ProductsTest extends BaseTest{

    HomePage Home;
    ProductsPage productsPage;
    @BeforeTest
    public  void setUp(){
        Home =new HomePage();
        productsPage=new ProductsPage();
    }
    @Test(dataProvider = "jsonDataProvider", dataProviderClass = DataProviderUtils.class)
    @JsonFile("src/test/resources/SearchTestData.json")
    public void products(String product){
        productsPage=Home
                .clickOnProductsLink();
        productsPage
                .verifyAllProductsVisible()
                .searchForProduct(product)
                .clickOnSearchButton()
                .verifyMatchingProductResult(product)
                .viewOneProduct();
                //.printAllElementsText();
    }
}
