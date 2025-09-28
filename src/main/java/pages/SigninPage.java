package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utiles.DriverMange.DriverManager;
import utiles.commonHelper.ElementsHelper.AssertionHelper;
import utiles.commonHelper.ElementsHelper.BaseElementHelper;
import utiles.commonHelper.Global;

// WE use fluent pattern (Method chainning )
public class SigninPage {

    WebDriver driver;
    Global global;
    private final By LoginEmail =By.xpath("//input[@data-qa='login-email']");
    private final By  LoginPassword=By.xpath("//input[@data-qa='login-password']");
    private final By LoginButton =By.xpath("//button[@data-qa='login-button']");
    private final By LoggedInAs =By.xpath("//a[text()=' Logged in as ']");

    //Constructor
    public  SigninPage( ){
        this.driver= DriverManager.getDriver();
        global= Global.getInstance();
    }
    public  SigninPage EnterLoginEmail(){
        BaseElementHelper.sendText(driver,LoginEmail,global.getEmail());
        return this ;
    }
    public SigninPage enterLoginPassword(){
        BaseElementHelper.sendText(driver,LoginPassword,global.getPassword());
        return this ;
    }
    public SigninPage clickOnLoginBtn() {
        BaseElementHelper.click(driver,LoginButton);
        return this ;
    }
    public HomePage assertLoginSuccessful(){
        AssertionHelper.assertElementPresent(driver,LoggedInAs);
        return new HomePage();
    }
}
