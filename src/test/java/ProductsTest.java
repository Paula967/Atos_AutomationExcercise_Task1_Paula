import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;
import utiles.datareaders.DataProviderUtils;

import java.io.IOException;
import java.util.Iterator;

public class ProductsTest extends BaseTest{

    HomePage Home;
    ProductsPage productsPage;
    @BeforeTest
    public  void setUp(){
        Home =new HomePage();
        productsPage=new ProductsPage();
    }
    @DataProvider
    public Iterator<Object[]> getData() throws IOException {
        return DataProviderUtils.getData("src/test/resources/SearchTestData.json");
    }
    @Test(dataProvider = "getData")
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
