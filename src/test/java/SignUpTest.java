import org.testng.annotations.BeforeTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupPage;
import utiles.ExtentReports.ExtentReportListener;
import utiles.datareaders.DataProviderUtils;
import utiles.datareaders.JsonFile;

@Listeners(ExtentReportListener.class)
public class SignUpTest extends  BaseTest {
    HomePage Home ;
    SignupPage signupPage ;

    @BeforeTest
    public void setup(){
        Home= new HomePage();
        signupPage=new SignupPage();
    }
    @Test(dataProvider = "jsonDataProvider", dataProviderClass = DataProviderUtils.class)
    @JsonFile("src/test/resources/SignupTestData.json")
    public  void signupHappyPathFlow (String Name,String Gender,String Day,String Month,String Year,
                                      String FirstName,String Last,
                                      String Address,String Country,String State ,String City,String ZipCode,String Mobile){
        Home.clickOnSignInUpLink();
        signupPage.enterName(Name).EnterEmail().clickOnSignupBtn()
                .chooseGender(Gender)
                .enterPassword()
                .chooseDay(Day).chooseMonth(Month).chooseYear(Year)
                .checkOnNewsletter()
                .enterFirstName(FirstName).enterLastName(Last)
                .enterAddress(Address).chooseCountry(Country).enterState(State).enterCity(City)
                .enterZipCode(ZipCode).enterMobileNumber(Mobile)
                .clickOnCreateAccountBtn();
        Home.clickOnSignInUpLink();
        signupPage.clickOnLogOnBtn();
    }

}
