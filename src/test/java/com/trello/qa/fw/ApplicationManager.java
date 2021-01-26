package com.trello.qa.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Properties properties;//= new Properties();
        WebDriver wd;
        UserHelper userHelper;



    public void start() throws IOException {
        wd = new ChromeDriver();
        properties = new Properties();
        String target = System.getProperty("target", "elena");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        wd.navigate().to(properties.getProperty("web.url"));
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


       userHelper = new UserHelper(wd);

   }

   public String setEmail(){
        return properties.getProperty("web.email");
   }

    public String setPassword(){
        return properties.getProperty("web.password");
    }

    public void stop() {
        wd.quit();
    }

    public UserHelper user() {
        return userHelper;
    }


}
