import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import utiles.datareaders.DataProviderUtils;

import java.io.IOException;
import java.util.Iterator;


public class ContactUsTest extends BaseTest{
    ContactUsPage contactUsPage;
    @BeforeTest
    public  void setUp(){
        contactUsPage=new ContactUsPage();
    }
    @DataProvider
    public Iterator<Object[]> getData() throws IOException {
        return DataProviderUtils.getData("src/test/resources/SearchTestData.json");
    }
    @Test(dataProvider = "getData")
    public void contactUs(String Name){
        contactUsPage
                .clickOnContactUS()
                .enterName(Name)
                .enterEmail()
                .enterSubject()
                .enterMessage()
                .clickOnSubmit()
                .clickOnAlert()
                .assertSuccessMessageAppear();
    }
}
