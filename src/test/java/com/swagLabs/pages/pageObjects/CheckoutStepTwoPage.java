package com.swagLabs.pages.pageObjects;

import com.swagLabs.pages.generalPages.basePage.DefaultSettingsPage;
import com.swagLabs.pages.pageComponents.CartItemComponent;
import com.swagLabs.pages.pageComponents.HeaderComponent;
import com.swagLabs.pages.pageComponents.ItemComponent;
import com.swagLabs.pages.pageComponents.NavbarComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//todo create class
public class CheckoutStepTwoPage extends DefaultSettingsPage {
    private HeaderComponent headerComponent;
    private NavbarComponent navbarComponent;
    private CartItemComponent cartItemComponent;
    @FindAll(@FindBy(css = "div.cart_list div.cart_item"))
    private List<WebElement> cartItems;
    @FindBy(css = "div.summary_subtotal_label")
    private WebElement subtotalPrice;
    @FindBy(css = "summary_tax_label")
    private WebElement tax;
    @FindBy(css = "summary_total_label")
    private WebElement totalPrice;
    @FindBy(id = "cancel")
    private WebElement cancelButton;
    @FindBy(id = "finish")
    private WebElement finishButton;

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        defaultWait.until(ExpectedConditions.presenceOfElementLocated(By.id("checkout_info_container")));

        this.headerComponent = new HeaderComponent(driver);
        this.navbarComponent = new NavbarComponent(driver);
        this.cartItemComponent = new CartItemComponent(driver);
    }

    public CheckoutStepTwoPage acceptCheckoutStepTwoPageIsLoad() {
        assertEquals("https://www.saucedemo.com/checkout-step-two.html", driver.getCurrentUrl());
        headerComponent.assertHeaderComponentIsLoad();
        navbarComponent.assertNavbarComponentIsLoad();
        cartItemComponent.assertCartItemComponentIsLoad();

        assertTrue(subtotalPrice.isDisplayed());
        assertTrue(tax.isDisplayed());
        assertTrue(totalPrice.isDisplayed());
        assertTrue(cancelButton.isDisplayed());
        assertTrue(finishButton.isDisplayed());
        return this;
    }

    public InventoryPage clickToCancel() {
        cancelButton.click();
        return new InventoryPage(driver);
    }

    public CheckoutCompletePage clickToFinish() {
        finishButton.click();
        return new CheckoutCompletePage(driver);
    }
}
