package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utiles.DriverMange.DriverManager;
import utiles.commonHelper.ElementsHelper.BaseElementHelper;
import utiles.commonHelper.Global;

// WE use fluent pattern (Method chainning )
public class SigninPage {

    WebDriver driver;
    Global global;
    By LoginEmail =By.xpath("//input[@data-qa='login-email']");
    By  LoginPassword=By.xpath("//input[@data-qa='login-password']");
    By LoginButton =By.xpath("//button[@data-qa='login-button']");
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
    public SigninPage  clickOnLoginBtn() {
        BaseElementHelper.click(driver,LoginButton);
        return this ;
    }
}
