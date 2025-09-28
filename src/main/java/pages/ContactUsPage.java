package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utiles.DriverMange.DriverManager;
import utiles.commonHelper.AssertionHelper;
import utiles.commonHelper.ElementHelper;
import utiles.commonHelper.Global;

public class ContactUsPage {

    //Variables
    WebDriver driver;
    Global global;

    //Locators
    By contactUsLink=By.cssSelector("a[href='/contact_us']");
    By nameText= By.cssSelector("input[placeholder='Name']");
    By emailText=By.cssSelector("input[placeholder='Email']");
    By subjectText=By.cssSelector("input[placeholder='Subject']");
    By message=By.cssSelector("textarea[placeholder='Your Message Here']");
    By submitButton=By.cssSelector("input[value='Submit']");
    By resultMessage=By.cssSelector(".alert-success");

    //Constructor
    public ContactUsPage() {
        this.driver = DriverManager.getDriver();
        global=Global.getInstance();
    }
    //Actions
    public ContactUsPage clickOnContactUS(){
        ElementHelper.click(driver,contactUsLink);
        return this;
    }
    public ContactUsPage enterName(String Name){
        ElementHelper.sendText(driver,nameText,Name);
        return this;
    }
    public ContactUsPage enterEmail(){
        ElementHelper.sendText(driver,emailText,global.getEmail());
        return this;
    }
    public ContactUsPage enterSubject(){
        global.setSubject();
        ElementHelper.sendText(driver,subjectText,global.getSubject());
        return this;
    }
    public ContactUsPage enterMessage(){
        global.setMessage();
        ElementHelper.sendText(driver,message,global.getMessage());
        return this;
    }
    public ContactUsPage clickOnSubmit(){
        ElementHelper.click(driver,submitButton);
        return this;
    }
    public ContactUsPage clickOnAlert(){
        ElementHelper.clickOnAcceptAlert(driver);
        return this;
    }
    public ContactUsPage assertSuccessMessageAppear(){
        AssertionHelper.assertElementPresent(driver,resultMessage);
        return this;
    }
}
