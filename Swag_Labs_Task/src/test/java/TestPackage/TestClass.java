package TestPackage;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestClass {
    WebDriver driver;
    LoginPage loginPage;

    ////////////////////////////////////////////////////
    ////////// Test Cases /////////////////////////////
    //////////////////////////////////////////////////
    @Test
    public void loginWithValidData() {
        loginPage.navigateToLoginPage();
        Assert.assertEquals(loginPage.getPageTitle(),"Swag Labs");
        System.out.println("Title is correct!");
        loginPage.validUsernameAndPassword();
        Assert.assertEquals(loginPage.getText(),"PRODUCTS");
        System.out.println("Logging successfully! ");
    }

    @Test
    public void loginWithInValidData() {
        loginPage.navigateToLoginPage();
        Assert.assertEquals(loginPage.getPageTitle(),"Swag Labs");
        System.out.println("Title is correct!");
        loginPage.inValidUsernameAndPassword();
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username and password do not match any user in this service");
        System.out.println("Error message appears successfully!");
        System.out.println(loginPage.getErrorMessage());
    }

    @Test
    public void loginWithEmptyData() {
        loginPage.navigateToLoginPage();
        Assert.assertEquals(loginPage.getPageTitle(),"Swag Labs");
        System.out.println("Title is correct!");
        loginPage.emptyUsernameAndPassword();
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username is required");
        System.out.println("Error message appears successfully!");
        System.out.println(loginPage.getErrorMessage());
    }

    @Test
    public void loginWithEmptyUserNameOnly() {
        loginPage.navigateToLoginPage();
        Assert.assertEquals(loginPage.getPageTitle(),"Swag Labs");
        System.out.println("Title is correct!");
        loginPage.emptyUsernameOnly();
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username is required");
        System.out.println("Error message appears successfully!");
        System.out.println(loginPage.getErrorMessage());

    }

    @Test
    public void loginWithEmptyPasswordOnly() {
        loginPage.navigateToLoginPage();
        Assert.assertEquals(loginPage.getPageTitle(),"Swag Labs");
        System.out.println("Title is correct!");
        loginPage.emptyPasswordOnly();
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Password is required");
        System.out.println("Error message appears successfully!");
        System.out.println(loginPage.getErrorMessage());

    }



    ////////////////////////////////////////////////////////
    /////////////////Before and After Methods//////////////
    //////////////////////////////////////////////////////

    //Set up the environment to start Testing
    @BeforeMethod
    public void setupEnv() throws IOException, ParseException {

        // setting up chromedriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();

    }

    //Closing browser !
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
