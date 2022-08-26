package Pages;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.FileReader;
import java.io.IOException;

public class LoginPage {

    // variable
    WebDriver driver;
    String url = "https://www.saucedemo.com/";

    JSONParser jsonParser = new JSONParser();
    JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("Utilities\\read.json"));



    //Locators
    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");
    By productsText = By.xpath("//span[contains(@class, 'title')]");
    By errorMessage = By.xpath("//h3[contains(@data-test, 'error')]");

    //Default constructor
    public LoginPage (WebDriver driver) throws IOException, ParseException {
        this.driver = driver;
    }

    //Actions
    public void navigateToLoginPage() {
        driver.navigate().to(url);
    }

    public String getPageTitle(){
       return driver.getTitle();
    }

    public void validUsernameAndPassword() {

        driver.findElement(username).sendKeys(jsonObject.get("username3").toString());
        driver.findElement(password).sendKeys(jsonObject.get("password3").toString());
        driver.findElement(loginBtn).click();

    }

    public void inValidUsernameAndPassword() {
        driver.findElement(username).sendKeys(jsonObject.get("username1").toString());
        driver.findElement(password).sendKeys(jsonObject.get("password1").toString());
        driver.findElement(loginBtn).click();

    }

    public void emptyUsernameAndPassword() {
        driver.findElement(username).sendKeys(jsonObject.get("username2").toString());
        driver.findElement(password).sendKeys(jsonObject.get("password2").toString());
        driver.findElement(loginBtn).click();

    }

    public void emptyUsernameOnly() {
        driver.findElement(username).sendKeys(jsonObject.get("username2").toString());
        driver.findElement(password).sendKeys(jsonObject.get("password3").toString());
        driver.findElement(loginBtn).click();

    }

    public void emptyPasswordOnly() {
        driver.findElement(username).sendKeys(jsonObject.get("username3").toString());
        driver.findElement(password).sendKeys(jsonObject.get("password2").toString());
        driver.findElement(loginBtn).click();

    }

    public String getText(){
        return driver.findElement(productsText).getText();
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }
}
