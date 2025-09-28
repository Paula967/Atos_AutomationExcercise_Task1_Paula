import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LogOutPage;
import pages.SigninPage;

public class LogOutTest extends BaseTest {
    LogOutPage logOutPage;
    SigninPage signinPage;
    @BeforeTest
    public  void setUp(){
        logOutPage =new LogOutPage();
        signinPage=new SigninPage();
    }
    @Test
    public void LogOut(){
        logOutPage
                .clickOnLogOutButton()
                .assertRedirectionOfURL();
    }
}
