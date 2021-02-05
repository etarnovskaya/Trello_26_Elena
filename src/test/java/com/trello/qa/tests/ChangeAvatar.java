package com.trello.qa.tests;

import com.trello.qa.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class ChangeAvatar extends  TestBase{
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.user().isAvatarPresent()){
            app.user().initLogin();
            app.user().fillLoginForm(new User()
                    .setEmail(app.setEmail())
                    .setPassword(app.setPassword()));
            app.user().confirmLogin();
        }
    }

    @Test
    public void testChangeAvatar(){
        app.user().clickOnTheAvatar();
        app.user().goToProfile();
        app.user().goToAtlasianAcc();
        app.user().changeAvatar("C:\\Users\\Elena\\Documents\\GitHub\\Trello_26_Elena\\src\\test\\resources\\cat1.jpg");

        Assert.assertTrue(app.user().isElementPresent(By.xpath("//*[contains(.,'Avatar added')]")));
        app.user().closeWindow();


    }
}
