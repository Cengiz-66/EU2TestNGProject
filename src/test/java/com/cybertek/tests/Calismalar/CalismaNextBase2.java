package com.cybertek.tests.Calismalar;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class CalismaNextBase2 extends TestBase {
    LoginPageDemo loginPage=new LoginPageDemo();

    @Test
    public void test() {

        String username= ConfigurationReader.get("nextbase_user");
        String password= ConfigurationReader.get("nextbase_password");
        loginPage.login(username,password);

    }
}
