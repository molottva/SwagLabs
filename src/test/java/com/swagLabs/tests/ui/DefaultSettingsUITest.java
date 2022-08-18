package com.swagLabs.tests.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DefaultSettingsUITest {
    public WebDriver driver;

    @BeforeAll
    public static void setUpBeforeClass() {
        System.setProperty("webdriver.chrome.driver", "./webdrivers/chromedriver.exe");
    }

    @BeforeEach
    public void setUpBeforeMethod() {
        this.driver = new ChromeDriver();
        System.out.println("ss");
    }

    @AfterEach
    public void tierDownAfterMethod() {
        driver.close();
        driver.quit();
        driver = null;
    }
}
