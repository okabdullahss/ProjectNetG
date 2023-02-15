package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pages.MedunnaPage;
import pages.RegistrationPage;
import pojos.TaskPojoClass;
import pojos.Netguru_userPojo_Inner;
import pojos.Netguru_userPojo_Outer;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ObjectMapperUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static base_url_setup.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.Authentication.generateToken;
import static utilities.DatabaseUtility.createConnection;
import static utilities.DatabaseUtility.getColumnData;

public class NetguruTaskStepDefinitions {

    MedunnaPage medunnaPage = new MedunnaPage();
    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker();
    static TaskPojoClass userPojo = new TaskPojoClass();

//---------------- UI Test Step Definitions ------------------------
    @Given("user is in medunna web page")
    public void userIsInMedunnaWebPage() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }

    @Then("user clicks the registration page")
    public void userClicksTheRegistrationPage() {
        medunnaPage.loginAndRegisterIcon.click();
        medunnaPage.registerBtn.click();
    }

    @And("user enters valid SSN {string}")
    public void userEntersValidSSN(String ssn) {

        ssn = faker.idNumber().ssnValid();
        userPojo.setSsn(ssn);

        WebElement ssnTextbox = registrationPage.ssnTextbox;
        Driver.waitAndSendText(ssnTextbox,ssn);
    }


    @And("user enters firstName {string}")
    public void userEntersFirstName(String firstName) {

        firstName = faker.name().firstName();
        userPojo.setFirstName(firstName);

        WebElement fName = registrationPage.firstnameTextbox;
        Driver.waitAndSendText(fName,firstName);
    }

    @And("user enters lastName {string}")
    public void userEntersLastName(String lastName) {
        lastName = faker.name().lastName();
        userPojo.setLastname(lastName);

        WebElement lName = registrationPage.lastnameTextbox;
        Driver.waitAndSendText(lName,lastName);
    }

    @And("user enters userName {string}")
    public void userEntersUserName(String userName) {

        userName = userPojo.getFirstName()+userPojo.getLastname();
        userPojo.setUsername(userName);

        WebElement usernameTextbox = registrationPage.usernameTextbox;
        Driver.waitAndSendText(usernameTextbox,userName);
    }

    @And("user enters password {string}")
    public void userEntersPassword(String password) {
        password = faker.internet().password();
        userPojo.setFirstPassword(password);

        WebElement firstPasswordTextbox = registrationPage.firstPasswordTextbox;
        Driver.waitAndSendText(firstPasswordTextbox,password);
    }

    @And("user enters email {string}")
    public void userEntersEmail(String email) {

        email = faker.internet().emailAddress();
        userPojo.setEmail(email);

        WebElement emailTextBox = registrationPage.emailTextbox;
        Driver.waitAndSendText(emailTextBox,email);
    }

    @And("user enters second password {string}")
    public void userEntersSecondPassword(String password2) {

        WebElement secondPassBox = registrationPage.newPasswordTextbox;
        Driver.waitAndSendText(secondPassBox,userPojo.getFirstPassword());
    }

    @And("user clicks the register button")
    public void userClicksTheRegisterButton() {

        Driver.waitAndClick(registrationPage.registerButton);
    }

    @And("user verifies the success message as {string}")
    public void userVerifiesTheSuccessMessageAs(String message) {

        Wait<WebDriver> waitFluent = new FluentWait<>(Driver.getDriver())
                .withTimeout( Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement successMessage = waitFluent.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Registration Saved')]")));

        String actual = successMessage.getText();
       assertEquals(message,actual);

       /* Another way:
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        String actual = js.executeScript("return document.getElementBy")*/

        System.out.println("userPojo = " + userPojo);
    }

//---------------- DATABASE Test Step Definitions ------------------------
    @Given("User creates a database connection")
    public void userCreatesADatabaseConnection() {
        String url = ConfigReader.getProperty("databaseUrlPostgre");
        String usernameDB =ConfigReader.getProperty("databaseUser");
        String passwordDB=ConfigReader.getProperty("databasePassword");

        createConnection(url,usernameDB,passwordDB);
    }

    List<Object> colList;

    @And("User fetch all the user SSN numbers from Database {string} {string}")
    public void userFetchAllTheUserSSNNumbersFromDatabase(String query, String column) {

        colList = getColumnData(query,column);
    }

    @Then("User validates the SSN number is included among fetched data")
    public void userValidatesTheSSNNumberIsIncludedAmongFetchedData() {

        String actualSSN = userPojo.getSsn();

        assertTrue(colList.contains(actualSSN));
    }

//---------------- API Test Step Definitions ------------------------
    @Given("Admin creates new country via create country API")
    public void adminCreatesNewCountryViaCreateCountryAPI() {

        Map<String,Object> body = new HashMap<>();
        body.put("name","CountryName");

        Response response = given().headers("Authorization","Bearer "+generateToken()).
                        contentType(ContentType.JSON).body(body).when().post("https://www.medunna.com/api/countries");

        Map<String,Object> actualData = response.as(HashMap.class);

        actualData.values().forEach(t-> System.out.print(t+" | "));

    }

    @Given("Validate the info of patient named JohnDoe")
    public void validateTheInfoOfPatientNamedJohnDoe() {

        //Create path parameters for the spec.

        spec.pathParams("1","patients","2","305851");

        Response resp = given().spec(spec).headers("Authorization","Bearer "+generateToken()).when().get("/{1}/{2}");

        // Step2 - Create expected data, which is defined as nested pojo class in the postman get method response. Add the
        // @jsonignoreproperties to prevent conflict while mapping

        Netguru_userPojo_Inner inner = new Netguru_userPojo_Inner("anonymousUser",null,305446,"JohnDoe","John",
                "Doe","JohnDoe@mail.com",true,"en",null,null,"500-33-0002");

        Netguru_userPojo_Outer expectedData = new Netguru_userPojo_Outer("JohnDoe",null,305851,"John","Doe",
                null,"222-222-2222",null,null,null,"JohnDoe@mail.com",null,inner,null,null,null,null);

        //Step3- Deserialization of the response from json type into the pojo class data type

        Netguru_userPojo_Outer actualData =

                ObjectMapperUtils.convertJsonIntoJava(resp.asString(), Netguru_userPojo_Outer.class);

        //Step4- Assertions. Note that there are 6 types of validation, in our example, ObjectMapping was used
        /* 1- Validation with "hemcrestMatchers",
           2- Validation with "JsonPath"
           3- Validation with "HashMap"
           4- Validation with "PojoClass"
           5- Validation with "ObjectMapper" (the one that we are currently using)
           6- Validation with "Gson"
        */
        assertEquals(expectedData.getCreatedBy(),actualData.getCreatedBy());
        assertEquals(expectedData.getCreatedDate(),actualData.getCreatedDate());
        assertEquals(expectedData.getId(),actualData.getId());
        assertEquals(expectedData.getFirstName(),actualData.getFirstName());
        assertEquals(expectedData.getLastName(),actualData.getLastName());
        assertEquals(expectedData.getBirthDate(),actualData.getBirthDate());
        assertEquals(expectedData.getPhone(),actualData.getPhone());
        assertEquals(expectedData.getEmail(),actualData.getEmail());


        assertEquals(inner.getCreatedBy(),actualData.getUser().getCreatedBy());
        assertEquals(inner.getCreatedDate(),actualData.getUser().getCreatedDate());
        assertEquals(inner.getId(),actualData.getUser().getId());
        assertEquals(inner.getLogin(),actualData.getUser().getLogin());
        assertEquals(inner.getFirstName(),actualData.getUser().getFirstName());
        assertEquals(inner.getLastName(),actualData.getUser().getLastName());
        assertEquals(inner.getEmail(),actualData.getUser().getEmail());
        assertEquals(inner.getActivated(),actualData.getUser().getActivated());
        assertEquals(inner.getLangKey(),actualData.getUser().getLangKey());
        assertEquals(inner.getImageUrl(),actualData.getUser().getImageUrl());
        assertEquals(inner.getSsn(),actualData.getUser().getSsn());


    }
}
