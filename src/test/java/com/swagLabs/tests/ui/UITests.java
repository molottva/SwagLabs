package com.swagLabs.tests.ui;

import com.swagLabs.helpers.data.DataHelper;
import com.swagLabs.pages.pageObjects.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UITests extends DefaultSettingsUITest {
    @Test
    public void shouldLoginAsSuccessful() {
        driver.get("https://www.saucedemo.com/");
        var user = DataHelper.getStandardValidUser();
        var mainPage = new MainPage(driver);

        mainPage.assertPageIsLoad()
                .assertLoginIsSuccessful(user.getLogin(), user.getPassword())
                .assertInventoryPageIsLoad();
    }

    @Test
    public void shouldNotificationAboutEmptyUsername() {
        driver.get("https://www.saucedemo.com/");
        var user = DataHelper.getStandardValidUser();
        var mainPage = new MainPage(driver);

        mainPage.assertLoginIsFailing("", user.getPassword());
        assertEquals("Epic sadface: Username is required", mainPage.getTextFromErrorNotification());

        mainPage.closingErrorNotification();
    }
}
