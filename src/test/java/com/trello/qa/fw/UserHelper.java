package com.trello.qa.fw;

import com.trello.qa.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        switchToWindowHanle(1);


    }

    public void closeWindow(){
        //close
        //get list of handles. size -> (int)
        //switchto size-2

        wd.close();
        switchToWindowHanle(0);
    }




    public void changeAvatar(String path) {
        WebElement avatar = wd.findElement(By.cssSelector("[data-test-selector='profile-hover-info']"));
//[data-test-selector='profile-hover-info'] [class^=Droplist__Trigger]
        Actions actions = new Actions(wd);
       actions
                .moveToElement(avatar)
                .moveToElement(avatar.findElement(By.xpath(".//*[@class='Droplist__Trigger-sc-1z05y4v-3 eteVrT']")))
                .click()
                //.moveToElement(wd.findElement(By.xpath("//div[@id='uid16']/span[1]"))).click()
                .perform();


      //  click(By.xpath("//div[@id='uid16']/span[1]"));
        new WebDriverWait(wd, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Change profile photo')]"))).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        attachPhoto(By.cssSelector("#image-input"), new File(path));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(By.xpath("//button//span[contains(., 'Upload')]"));
    }
}
