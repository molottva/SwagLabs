package com.swagLabs.pages.pageComponents;

import com.swagLabs.pages.generalPages.basePage.DefaultSettingsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavbarComponent extends DefaultSettingsPage {
    @FindBy(css = "button#react-burger-menu-btn")
    private WebElement menuNavbarButton;
    @FindAll(@FindBy(css = "nav.bm-item-list a"))
    private List<WebElement> menuItems;
    @FindBy(css = "button#react-burger-cross-btn")
    private WebElement menuCloseButton;

    public NavbarComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        defaultWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("nav.bm-item-list a")));
    }

    public NavbarComponent assertNavbarComponentIsLoad() {
        assertTrue(menuItems.get(0).isDisplayed());
        assertTrue(menuItems.get(menuItems.size() - 1).isDisplayed());
        assertTrue(menuCloseButton.isDisplayed());

        assertFalse(menuNavbarButton.isDisplayed());
        return this;
    }


}
