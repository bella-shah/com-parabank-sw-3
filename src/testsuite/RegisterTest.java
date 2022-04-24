package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseurl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openBrowser(baseurl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        // register name link and click on register link
        clickOnElement(By.linkText("Register"));
        //This message from requirement
        String expectedMessage = "Signing up is easy!";
        String actualMessage = getTextFromElement(By.xpath("//h1[@class='title']"));
    }

    @Test
    public void verifyShouldRegisterAccountsSuccessfully() {
        //find log in link and click on login link
        clickOnElement(By.linkText("Register"));
        // find the first name and enter first name
        sendTextToElement(By.id("customer.firstName"), "Bella");
        // find the last name and enter last name
        sendTextToElement(By.id("customer.lastName"), "Shah");
        //Find the address and enter the address
        sendTextToElement(By.id("customer.address.street"), "54 Ealing Road");
        // find the city and enter the city name
        sendTextToElement(By.id("customer.address.city"), "Wembley");
        // find the state name and enter the state name
        sendTextToElement(By.id("customer.address.state"), "Middlesex");
        // find the zip code and enter the zip code
        sendTextToElement(By.id("customer.address.zipCode"), "HP20 1DA");
        //find the phone number and enter the phone number
        sendTextToElement(By.id("customer.phoneNumber"), "07939373398");
        //find the ssn number end enter the ssn number
        sendTextToElement(By.id("customer.ssn"), "AA-12-34-55-B");
        //find the username and enter the username
        sendTextToElement(By.id("customer.username"), "Bella-shah8");
        //find the password field and enter the password
        sendTextToElement(By.id("customer.password"), "Bella1234");
        //find the confirm password and enter the confirm password
        sendTextToElement(By.id("repeatedPassword"), "Bella1234");
        //find the register field and click on register field
        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));
        //This message from requirement
        String expectedMessage = "Your account was created successfully. You are now logged in.";
        String actualMessage = getTextFromElement(By.xpath("//h1[@class='title']"));
    }

    @After
    //close the driver
    public void tearDown() {
        closeBrowser();
    }
}

