import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import utiles.datareaders.DataProviderUtils;

import java.io.IOException;
import java.util.Iterator;

public class AddToCartPageTest extends BaseTest{

    AddToCartPage cartPage;

    @BeforeTest
    public void setUp(){
        cartPage= new AddToCartPage();
    }
    @DataProvider
    public Iterator<Object[]> getData() throws IOException {
        return DataProviderUtils.getData("src/test/resources/ProductsAddedToCartTestData.json");
    }
    @Test(dataProvider = "getData")
    public void testAddToCartAndVerify
                (String productName_A ,String productPrice_A,String productQty_A,String productIndex_A,
                 String productName_B,String productPrice_B,String productQty_B ,String productIndex_B) {

        double p1 = Double.parseDouble(productPrice_A);
        int quantity1 = Integer.parseInt(productQty_A);
        int index1 = Integer.parseInt(productIndex_A);

        double p2 = Double.parseDouble(productPrice_B);
        int quantity2 = Integer.parseInt(productQty_B);
        int index2 = Integer.parseInt(productIndex_B);
            //Product A
             cartPage.setProductQuantity(quantity1)
                     .clickAddToCart()
                     .assertSuccessMessageDisplayed()
                     .continueShopping();
             //Product B
             cartPage.clickOnAddToCartFromProductsPage()
                     .assertSuccessMessageDisplayed()
                     .goToCart();

             //Assert On ProductA InCart
            cartPage.assertProductNamesByIndex(index1,productName_A)
                    .assertProductQuantitiesByIndex(index1,quantity1)
                    .assertProductPricesByIndex(index1,p1)
                    .assertTotalAmountByIndex(index1);

            //Assert On ProductB InCart
            cartPage.assertProductNamesByIndex(index2,productName_B)
                    .assertProductQuantitiesByIndex(index2,quantity2)
                    .assertProductPricesByIndex(index2,p2)
                    .assertTotalAmountByIndex(index2);
        }
    }

