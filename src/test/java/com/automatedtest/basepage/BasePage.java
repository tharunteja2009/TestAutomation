package com.automatedtest.basepage;

import com.automatedtest.infrastructure.driver.Setup;
import com.automatedtest.infrastructure.driver.Wait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BasePage {

    protected WebDriver driver;
    protected Wait wait;
    protected JavascriptExecutor javascriptExecutor;
    protected Actions actions;

    public BasePage() {
        this.driver = Setup.driver;
        this.wait = new Wait(this.driver);
        this.javascriptExecutor = Setup.javascriptExecutor;
        this.actions = Setup.actions;
    }
}
