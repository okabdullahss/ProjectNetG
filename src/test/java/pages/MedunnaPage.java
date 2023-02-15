package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;



import java.time.Duration;
import java.util.List;


public class MedunnaPage {


    public MedunnaPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement loginAndRegisterIcon;

    @FindBy(xpath = "//a[@href='/account/register']")
    public WebElement registerBtn;

    @FindBy(xpath = "//span[text()='Sign in']")
    public WebElement signInButton;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy(id = "entity-menu")
    public WebElement staffMyPagesBtn;

    @FindBy(xpath = "//span[text()='MY PAGES(PATIENT)']")
    public WebElement patientMyPagesBtn;

    @FindBy(xpath = "//span[text()='My Appointments']")
    public WebElement myAppointmentsPatient;

    @FindBy(id = "fromDate")
    public WebElement patientAppointmentsFromDate;

    @FindBy(id = "toDate")
    public WebElement patientAppointmentsToDate;



    @FindBy(xpath = "//span[text()='Search Patient']")
   public WebElement staffSearchPatientBtn;

    @FindBy(xpath = "//input[@class='form-control']")
    public WebElement staffMyPagePatientSSNsearch;

    @FindBy(xpath = "(//tbody//td)[2]")
    public WebElement patientSSNfromTableByStaff;

    @FindBy(css = "#c-test-result-id")
    public WebElement editIdSectionInTestResult;


    @FindBy(css = "a[href=\"/c-test-result-update/306918\"]")
    public WebElement editBtnViewTestReults;

    @FindBy(xpath = "//span[text()='Payment / Invoice Process']")
    public WebElement paymentInvoiceProcessBtn;

    @FindBy(css = "div[class=\"btn-group flex-btn-group-container\"]>a")
    public List<WebElement> verifyPaymentIfStatusCancelledOrCompleted;

    @FindBy(css = "a[class=\"btn btn-warning btn-sm\"]")
    public WebElement showInvoiceBtn;

    @FindBy(xpath = "//span[text()='Show Tests']")
    public WebElement showTestsBtnPatient;

    @FindBy(xpath = "//span[text()='View Results']")
    public WebElement viewResultsBtnPatient;

    @FindBy(xpath = "//tr[2]//td")
    public List<WebElement> testReultSections;

    @FindBy(xpath = "//span[text()='Show Invoice']")
    public List<WebElement> showInvoicePatient;

    @FindBy(xpath = "")
    public WebElement nameOnInvoicePatient;

    @FindBy(xpath = "//tr[4]/th[2]")
    public WebElement SSNonInvoicePatient;






    public WebElement myMethod(String ssnId ){

        try {
            Thread.sleep(1000);// DOM changes as you enter ssNid, so it waits a little bit until the table is created
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        List<WebElement> SSNids = Driver.getDriver().findElements(By.xpath("//td[2]"));

        int indx = 0;

        for (WebElement w: SSNids) {

            if(w.getText().equalsIgnoreCase(ssnId)){
                indx= SSNids.indexOf(w)+1;
                //break;
            }
        }

        WebElement ele = Driver.getDriver().findElement(By.xpath("(//td[16]//a[@class='btn btn-warning btn-sm'])["+indx+"]"));
        return ele;

    }

    @FindBy(xpath = "//span[text()='Show Tests']")
    public WebElement showTestsBtnOfPatientByStaff;

    @FindBy(xpath = "//a[@class='btn btn-info btn-sm']")
    public  WebElement viewResultsBtnOfPatientByStaff;

    @FindBy(xpath = "(//a[@class='d-flex align-items-center dropdown-toggle nav-link'])[2]")
    public WebElement loggedInProfileBtn;

    @FindBy(xpath = "//span[text()='Sign out']")
    public WebElement signOutBtn;





    @FindBy(xpath = "//input[@id='ssn']")
    public WebElement registerSSNInput;

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement registerFirstNameInput;

    @FindBy(xpath = "//div[text()='Your SSN is invalid']")
    public WebElement invalidSSNWarning;

    @FindBy(xpath = "(//tr/th)[4]")
    public WebElement invoiceSSN;







}
