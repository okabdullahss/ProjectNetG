package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class RegistrationPage {

    public RegistrationPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "ssn")
    public WebElement ssnTextbox;

    @FindBy(name = "firstName")
    public WebElement firstnameTextbox;

    @FindBy(name = "lastName")
    public WebElement lastnameTextbox;

    @FindBy(name = "username")
    public WebElement usernameTextbox;

    @FindBy(id = "email")
    public WebElement emailTextbox;

    @FindBy(name = "firstPassword")
    public WebElement firstPasswordTextbox;

    @FindBy(name = "secondPassword")
    public WebElement newPasswordTextbox;

    @FindBy(id = "register-submit")
    public WebElement registerButton;

    @FindBy(xpath = "//*[text()='Registration saved!']")
    public WebElement successMessageToastContainer;









}
