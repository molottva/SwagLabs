package com.swagLabs.pages.pageComponents;

import com.swagLabs.pages.pageObjects.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.swagLabs.pages.basePage.DefaultSettingsPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HeaderComponent extends DefaultSettingsPage {
    @FindBy(css = "div.app_logo")
    private WebElement logo;
    @FindBy(css = "button#react-burger-menu-btn")
    private WebElement menuContainerButton;
    @FindAll(@FindBy(css = "nav.bm-item-list a"))
    private List<WebElement> menuItems;
    @FindBy(css = "button#react-burger-cross-btn")
    private WebElement menuCloseButton;
    @FindBy(css = "div#shopping_cart_container")
    private WebElement cartButton;

    public HeaderComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        defaultWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.primary_header")));
    }

    public HeaderComponent assertHeaderComponentIsLoad() {
        assertTrue(logo.isDisplayed());
        assertTrue(menuContainerButton.isDisplayed());
        assertTrue(cartButton.isDisplayed());

        assertFalse(menuItems.get(0).isDisplayed());
        assertFalse(menuItems.get(menuItems.size() - 1).isDisplayed());
        assertFalse(menuCloseButton.isDisplayed());
        return this;
    }
    //todo навигация в меню слева
    public CartPage clickToCartPage() {
        cartButton.click();
        return new CartPage(driver);
    }
}
