package com.trello.qa.fw;

import com.trello.qa.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UserHelper extends  HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void initLogin() {
        click(By.cssSelector("[href='/login']"));
    }

    public void fillLoginForm(User user) throws InterruptedException {
        type(By.id("user"), user.getEmail());
        Thread.sleep(2000);
        click(By.id("login"));
        type(By.id("password"), user.getPassword());

    }

    public void confirmLogin() {
        click(By.id("login-submit"));
    }

    public boolean isAvatarPresent() throws InterruptedException {
        Thread.sleep(20000);
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void clickOnTheAvatar() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
        }

    public void goToProfile() {
        click(By.cssSelector("[data-test-id='header-member-menu-profile']"));
    }

    public void goToAtlasianAcc() {
        click(By.cssSelector("[href$=manage-profile]"));
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(1));


    }

    public void changeAvatar(String path) {
        //...
        attachPhoto(By.cssSelector("[id='image-input']"), new File(path));
    }
}
