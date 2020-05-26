package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage {

    //since we are extending BasePage we do not need explicit constructor

    public WebElement getContactEmail(String mail) {
        String xpath="//td[contains(text(),'"+mail+"') and @data-column-label=\"Email\"]";
        WebElement email= Driver.get().findElement(By.xpath(xpath));
        return email;
    }


}
