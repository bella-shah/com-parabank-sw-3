package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseurl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openBrowser(baseurl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //sending username & password to elements
        sendTextToElement(By.xpath("//input[@type='text']"), "Bella-shah8");
        sendTextToElement(By.xpath("//input[@type='password']"), "Bella1234");
        //click
        clickOnElement(By.xpath("//input[@type='submit']"));
        //This is from requirement
        String expectedMessage = "Accounts Overview";
        String actualMessage = getTextFromElement(By.xpath("//h1[@class='title']"));
    }

    @Test
    public void verifyTheErrorMessage() {
        //sending invalid username and password to elements
        sendTextToElement(By.xpath("//input[@type='text']"), "Bella66");
        sendTextToElement(By.xpath("//input[@type='password']"), "abcd123");
        //click
        clickOnElement(By.xpath("//input[@type='submit']"));
        //This is from requirement
        String expectedMessage = "The username and password could not be verified.";
        String actualMessage = getTextFromElement(By.xpath("//p[@class='error']"));
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        //Find Element of userName field
        sendTextToElement(By.xpath("//input[@type='text']"), "Bella-shah8");
        sendTextToElement(By.xpath("//input[@type='password']"), "Bella1234");
        ;
        //Find Login element and click on it
        clickOnElement(By.xpath("//input[@type='submit']"));
        //logout button click
        clickOnElement(By.xpath("//a[@href='/parabank/logout.htm']"));
        //This is from requirement
        String expectedMessage = "Customer Login";
        String actualMessage = getTextFromElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
    }

    @After
    //close the driver
    public void tearDown() {
        closeBrowser();
    }
}

