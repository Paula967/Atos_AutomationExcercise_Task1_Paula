import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LogOutPage;
import pages.SigninPage;
import utiles.ExtentReports.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class LogOutTest extends BaseTest {
    LogOutPage logOutPage;
    SigninPage signinPage;
    @BeforeTest
    public  void setUp(){
        logOutPage =new LogOutPage();
        signinPage=new SigninPage();
    }
    @Test(testName = "LogOut Happy Path Flow")
    public void LogOut(){
        logOutPage
                .clickOnLogOutButton()
                .assertRedirectionOfURL();
    }
}
