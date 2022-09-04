package com.swagLabs.pages.pageObjects;

import com.swagLabs.pages.generalPages.basePage.DefaultSettingsPage;
import com.swagLabs.pages.pageComponents.HeaderComponent;
import com.swagLabs.pages.pageComponents.NavbarComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutCompletePage extends DefaultSettingsPage {
    private HeaderComponent headerComponent;
    private NavbarComponent navbarComponent;
    @FindBy(id = "back-to-products")
    private WebElement backHomeButton;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        defaultWait.until(ExpectedConditions.presenceOfElementLocated(By.id("checkout_complete_container")));

        this.headerComponent = new HeaderComponent(driver);
        this.navbarComponent = new NavbarComponent(driver);
    }

    public CheckoutCompletePage acceptCheckoutCompletePageIsLoad() {
        assertEquals("https://www.saucedemo.com/checkout-complete.html", driver.getCurrentUrl());
        headerComponent.assertHeaderComponentIsLoad();
        navbarComponent.assertNavbarComponentIsLoad();

        assertEquals("THANK YOU FOR YOUR ORDER", driver.findElement(By.cssSelector("h2.complete-header")));
        assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!",
                driver.findElement(By.cssSelector("div.complete-text")));

        assertTrue(backHomeButton.isDisplayed());
        return this;
    }

    public InventoryPage clickToBackHomeButton() {
        backHomeButton.click();
        return new InventoryPage(driver);
    }
}
