package com.swagLabs.pages.basePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DefaultSettingsPage {
    public WebDriver driver;
    public WebDriverWait defaultWait;

    public DefaultSettingsPage(WebDriver driver) {
        this.driver = driver;
        this.defaultWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
