package com.swagLabs.pages.pageObjects;

import com.swagLabs.pages.generalPages.basePage.DefaultSettingsPage;
import com.swagLabs.pages.pageComponents.HeaderComponent;
import com.swagLabs.pages.pageComponents.NavbarComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CartPage extends DefaultSettingsPage {
    private HeaderComponent headerComponent;
    private NavbarComponent navbarComponent;
    @FindAll(@FindBy(css = "div.cart_list div.cart_item"))
    private List<WebElement> cartItems;
    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;
    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        defaultWait.until(ExpectedConditions.presenceOfElementLocated(By.id("cart_contents_container")));

        this.headerComponent = new HeaderComponent(driver);
        this.navbarComponent = new NavbarComponent(driver);
    }

    public CartPage assertEmptyCardPageIsLoad() {
        assertEquals("https://www.saucedemo.com/cart.html", driver.getCurrentUrl());

        assertTrue(continueShoppingButton.isDisplayed());
        assertTrue(checkoutButton.isDisplayed());
        assertNull(defaultWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.cssSelector("div.cart_list div.cart_item"))));

        headerComponent.assertHeaderComponentIsLoad();
        navbarComponent.assertNavbarComponentIsLoad();
        return this;
    }

    public CartPage assertNotEmptyCardPageIsLoad() {
        assertTrue(continueShoppingButton.isDisplayed());
        assertTrue(checkoutButton.isDisplayed());
        assertTrue(cartItems.get(0).isDisplayed());
        assertTrue(cartItems.get(cartItems.size() - 1).isDisplayed());

        headerComponent.assertHeaderComponentIsLoad();
        navbarComponent.assertNavbarComponentIsLoad();
        return this;
    }

    public InventoryPage clickContinueShopping() {
        continueShoppingButton.click();
        return new InventoryPage(driver);
    }

    public CheckoutStepOnePage checkoutStepOnePage() {
        checkoutButton.click();
        return new CheckoutStepOnePage(driver);
    }
}
