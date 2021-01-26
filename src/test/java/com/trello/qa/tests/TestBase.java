package com.trello.qa.tests;

import com.trello.qa.fw.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class TestBase {

    protected ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp() throws IOException {
        app.start();
    }

    @AfterMethod()
    public void tearDown() {
        app.stop();
    }

}
