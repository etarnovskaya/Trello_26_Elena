package com.trello.qa.tests;

import com.trello.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @Test
    public void testAtlassianUserLogin() throws InterruptedException {
        app.user().initLogin();
        app.user().fillLoginForm(new User()
                .setEmail("rochman.elena@gmail.com")
                .setPassword("12345.com"));
        app.user().confirmLogin();

        Assert.assertTrue(app.user().isAvatarPresent());
    }
}
