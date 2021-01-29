package com.trello.qa.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void typeByCss(String cssSelector, String text) {
        if(text!=null){
            clickByCss(cssSelector);
            wd.findElement(By.cssSelector(cssSelector)).clear();
            wd.findElement(By.cssSelector(cssSelector)).sendKeys(text);
        }

    }

    public void clickByCss(String cssSelector) {
        wd.findElement(By.cssSelector(cssSelector)).click();
    }

    public void clickByXpath(String xpath) {
        wd.findElement(By.xpath(xpath)).click();
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if(text!=null) {
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }

    public void attachPhoto(By locator, File file) {
        if(file!=null) {
            wd.findElement(locator).sendKeys(file.getAbsolutePath());
        }
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void clickYallaButton() {
        click(By.cssSelector("[type='submit']"));
    }

    public String getPageUrl(){
        return wd.getCurrentUrl();
    }

    public void switchToWindowHanle(int index) {
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(index));
    }

}
