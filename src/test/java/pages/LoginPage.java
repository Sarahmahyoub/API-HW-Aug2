package pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {

    //this is object repository of POM

    @FindBy(xpath="//*[@id='txtUsername']")
    private WebElement usernameField;

    @FindBy(id="txtPassword")
    public WebElement passwordField;

    @FindBy(id="btnLogin")
    public WebElement loginButton;

    @FindBy(id="spanMessage")
    public WebElement errorMessageField;


    public WebElement getUsernameField(){
        return usernameField;

    }

    //to initialize all the elements of this page we have to call them inside constructor
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

}