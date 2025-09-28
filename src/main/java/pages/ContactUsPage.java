package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utiles.DriverMange.DriverManager;
import utiles.commonHelper.ElementsHelper.AssertionHelper;
import utiles.commonHelper.ElementsHelper.BaseElementHelper;
import utiles.commonHelper.Global;

public class ContactUsPage {

    //Variables
    WebDriver driver;
    Global global;

    //Locators
    private final By contactUsLink = By.cssSelector("a[href='/contact_us']");
    private final By nameText = By.cssSelector("input[placeholder='Name']");
    private final By emailText = By.cssSelector("input[placeholder='Email']");
    private final By subjectText = By.cssSelector("input[placeholder='Subject']");
    private final By message = By.cssSelector("textarea[placeholder='Your Message Here']");
    private final By submitButton = By.cssSelector("input[value='Submit']");
    private final By resultMessage = By.cssSelector(".alert-success");


    //Constructor
    public ContactUsPage() {
        this.driver = DriverManager.getDriver();
        global=Global.getInstance();
    }
    //Actions
    public ContactUsPage clickOnContactUS(){
        BaseElementHelper.click(driver,contactUsLink);
        return this;
    }
    public ContactUsPage enterName(String Name){
        BaseElementHelper.sendText(driver,nameText,Name);
        return this;
    }
    public ContactUsPage enterEmail(){
        BaseElementHelper.sendText(driver,emailText,global.getEmail());
        return this;
    }
    public ContactUsPage enterSubject(){
        global.setSubject();
        BaseElementHelper.sendText(driver,subjectText,global.getSubject());
        return this;
    }
    public ContactUsPage enterMessage(){
        global.setMessage();
        BaseElementHelper.sendText(driver,message,global.getMessage());
        return this;
    }
    public ContactUsPage clickOnSubmit(){
        BaseElementHelper.click(driver,submitButton);
        return this;
    }
    public ContactUsPage clickOnAlert(){
        BaseElementHelper.clickOnAcceptAlert(driver);
        return this;
    }
    public ContactUsPage assertSuccessMessageAppear(){
        AssertionHelper.assertElementPresent(driver,resultMessage);
        return this;
    }
}
