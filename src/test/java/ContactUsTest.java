import org.testng.annotations.BeforeTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import utiles.ExtentReports.ExtentReportListener;
import utiles.datareaders.DataProviderUtils;
import utiles.datareaders.JsonFile;

@Listeners(ExtentReportListener.class)
public class ContactUsTest extends BaseTest{
    ContactUsPage contactUsPage;
    @BeforeTest
    public  void setUp(){
        contactUsPage=new ContactUsPage();
    }
    @Test(dataProvider = "jsonDataProvider", dataProviderClass = DataProviderUtils.class,testName = "Contact Us Form Test")
    @JsonFile("src/test/resources/SearchTestData.json")
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
