package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utiles.DriverMange.DriverManager;
import utiles.commonHelper.ElementsHelper.AssertionHelper;
import utiles.commonHelper.ElementsHelper.BaseElementHelper;
import utiles.commonHelper.ElementsHelper.DropDownHelper;
import utiles.commonHelper.Global;

public class SignupPage {
    WebDriver driver;
    Global global;
    private final By Name = By.name("name");
    private final By Email = By.xpath("//input[@data-qa='signup-email']");
    private final By SignupBtn = By.xpath("//button[text()='Signup']");
    private final By MrsGender = By.id("uniform-id_gender2");
    private final By Password = By.id("password");
    private final By DaysDropdown = By.id("days");
    private final By MonthDropdown = By.id("months");
    private final By YearsDropdown = By.id("years");
    private final By Newsletter = By.xpath("//label[text()='Sign up for our newsletter!']");
    private final By SpecialOffer = By.xpath("//label[text()='Receive special offers from our partners!']");
    private final By First_name = By.id("first_name");
    private final By Last_name = By.id("last_name");
    private final By Address = By.id("address1");
    private final By CountryDropdown = By.id("country");
    private final By State = By.id("state");
    private final By City = By.id("city");
    private final By Zipcode = By.id("zipcode");
    private final By Mobile_number = By.id("mobile_number");
    private final By Create_Account = By.xpath("//button[text()='Create Account']");
    private final By AccountCreatedMessage = By.xpath("//h2[@data-qa='account-created']");
    private final By accountCreatedMessage=By.cssSelector("h2[data-qa='account-created'] b");
    private final By LogOutBtn=By.linkText("Logout");

    public SignupPage() {
        this.driver = DriverManager.getDriver();
        global=Global.getInstance();
    }

    public SignupPage enterName(String name) {
        BaseElementHelper.sendText(driver, Name, name);
        return this;
    }

    public SignupPage EnterEmail() {
        global.setEmail();
        BaseElementHelper.sendText(driver, Email, global.getEmail());
        return this;
    }

    public SignupPage clickOnSignupBtn() {
        BaseElementHelper.click(driver, SignupBtn);
        return this;
    }

    public SignupPage chooseGender(String text) {
        BaseElementHelper.findElementByValue(text, driver).click();
        return this;
    }
    public SignupPage enterPassword() {
        global.setPassword();
        BaseElementHelper.sendText(driver, Password,global.getPassword());
        return this;
    }
    public SignupPage chooseDay(String day) {
        DropDownHelper.selectFromDropDownByText(driver, DaysDropdown, day);
        return this;
    }
    public SignupPage chooseMonth(String month) {
        DropDownHelper.selectFromDropDownByText(driver, MonthDropdown, month);
        return this;
    }

    public SignupPage chooseYear(String year) {
        DropDownHelper.selectFromDropDownByText(driver, YearsDropdown, year);
        return this;
    }

    public SignupPage checkOnNewsletter() {
        BaseElementHelper.click(driver, Newsletter);
        return this;
    }

    public SignupPage enterFirstName(String name) {
        BaseElementHelper.sendText(driver, First_name, name);
        return this;
    }

    public SignupPage enterLastName(String name) {
        BaseElementHelper.sendText(driver, Last_name, name);
        return this;
    }

    public SignupPage enterAddress(String address) {
        BaseElementHelper.sendText(driver, Address, address);
        return this;
    }

    public SignupPage chooseCountry(String country) {
        DropDownHelper.selectFromDropDownByText(driver, CountryDropdown, country);
        return this;
    }

    public SignupPage enterCity(String city) {
        BaseElementHelper.sendText(driver, City, city);
        return this;
    }

    public SignupPage enterState(String state) {
        BaseElementHelper.sendText(driver, State, state);
        return this;
    }

    public SignupPage enterZipCode(String code) {
        BaseElementHelper.sendText(driver, Zipcode, code);
        return this;
    }

    public SignupPage enterMobileNumber(String number) {
        BaseElementHelper.sendText(driver, Mobile_number, number);
        return this;
    }

    public SignupPage clickOnCreateAccountBtn() {
        BaseElementHelper.click(driver, Create_Account);
        return this;
    }
    public SignupPage clickOnLogOnBtn() {
        BaseElementHelper.click(driver, LogOutBtn);
        return this;
    }
    public SignupPage assertAccountCreated(){
        AssertionHelper.assertElementPresent(driver,accountCreatedMessage);
        return this;
    }

}
