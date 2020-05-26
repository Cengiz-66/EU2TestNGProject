package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInfoPage extends BasePage {

    @FindBy(css = "h1[class=\"user-name\"]")
    public WebElement fullname;

    @FindBy(css = "a[class=\"email\"]")
    public WebElement email;

    @FindBy(css = "a[class=\"phone\"]")
    public WebElement phone;
}
