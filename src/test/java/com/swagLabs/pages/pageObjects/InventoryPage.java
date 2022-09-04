package com.swagLabs.pages.pageObjects;

import com.swagLabs.pages.pageComponents.HeaderComponent;
import com.swagLabs.pages.pageComponents.NavbarComponent;
import com.swagLabs.pages.pageComponents.SortProductComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.swagLabs.pages.generalPages.basePage.DefaultSettingsPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryPage extends DefaultSettingsPage {
    private HeaderComponent header;
    private NavbarComponent navbarComponent;
    private SortProductComponent sortProductComponent;
    @FindBy(css = "div.inventory_list")
    private WebElement inventoryList;
    @FindAll(@FindBy(css = "div.inventory_item"))
    private List<WebElement> items;

    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        defaultWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#root")));

        this.header = new HeaderComponent(this.driver);
        this.navbarComponent = new NavbarComponent(this.driver);
        this.sortProductComponent = new SortProductComponent(this.driver);
    }

    public InventoryPage assertInventoryPageIsLoad() {
        assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory"));
        assertTrue(inventoryList.isEnabled());
        assertFalse(items.isEmpty());
        header.assertHeaderComponentIsLoad();

        items.get(0).isDisplayed();
        items.get(items.size() - 1).isDisplayed();
        return this;
    }
}
