import org.testng.annotations.BeforeTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import utiles.ExtentReports.ExtentReportListener;
import utiles.datareaders.DataProviderUtils;
import utiles.datareaders.JsonFile;

@Listeners(ExtentReportListener.class)
public class AddToCartPageTest extends BaseTest{

    AddToCartPage cartPage;

    @BeforeTest
    public void setUp(){
        cartPage= new AddToCartPage();
    }
    @Test(dataProvider = "jsonDataProvider", dataProviderClass = DataProviderUtils.class)
    @JsonFile("src/test/resources/ProductsAddedToCartTestData.json")
    public void testAddToCartAndVerify
                (String productName_A,Double productPrice_A,Double productQty_A,Double productIndex_A,
                 String productName_B,Double productPrice_B,Double productQty_B,Double productIndex_B) {

            //Product A
             cartPage.setProductQuantity(productQty_A)
                     .clickAddToCart()
                     .assertSuccessMessageDisplayed()
                     .continueShopping();
             //Product B
             cartPage.clickOnAddToCartFromProductsPage()
                     .assertSuccessMessageDisplayed()
                     .goToCart();

             //Assert On ProductA InCart
            cartPage.assertProductNamesByIndex(productIndex_A,productName_A)
                    .assertProductQuantitiesByIndex(productIndex_A,productQty_A)
                    .assertProductPricesByIndex(productIndex_A,productPrice_A)
                    .assertTotalAmountByIndex(productIndex_A);

            //Assert On ProductB InCart
            cartPage.assertProductNamesByIndex(productIndex_B,productName_B)
                    .assertProductQuantitiesByIndex(productIndex_B,productQty_B)
                    .assertProductPricesByIndex(productIndex_B,productPrice_B)
                    .assertTotalAmountByIndex(productIndex_B);
        }
    }

