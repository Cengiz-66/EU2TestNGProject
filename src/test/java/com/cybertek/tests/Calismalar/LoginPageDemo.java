package com.cybertek.tests.Calismalar;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageDemo {

    public LoginPageDemo() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = "[name=\"USER_LOGIN\"]")
    public WebElement usernameInput;

    @FindBy(css = "[name=\"USER_PASSWORD\"]")
    public WebElement passwordInput;

    @FindBy(css = "[type=\"submit\"]")
    public WebElement loginBtn;

    @FindBy(css = "[class=\"login-link-forgot-pass\"]")
    public WebElement forgotBtn;


    public void login(String usernameStr,String passwordStr) {
        usernameInput.sendKeys(usernameStr);
        passwordInput.sendKeys(passwordStr, Keys.ENTER);
        //loginBtn.click();

    }


}
