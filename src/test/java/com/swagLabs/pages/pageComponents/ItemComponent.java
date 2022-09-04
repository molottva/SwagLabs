package com.swagLabs.pages.pageComponents;

import com.swagLabs.pages.generalPages.basePage.DefaultSettingsPage;
import com.swagLabs.pages.generalPages.interfacePages.ItemInterface;
import com.swagLabs.pages.pageObjects.ItemDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemComponent extends DefaultSettingsPage implements ItemInterface {
    @FindBy(css = "img.inventory_item_img")
    private WebElement itemImage;
    @FindBy(css = "div.inventory_item_name")
    private WebElement itemName;
    @FindBy(css = "div.inventory_item_desc")
    private WebElement itemDescription;
    @FindBy(css = "div.inventory_item_price")
    private WebElement itemPrice;
    @FindBy(css = "button.btn")
    private WebElement itemAddToCartButton;

    public ItemComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        defaultWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.inventory_item")));
    }

    public void assertItemComponentIsLoad() {
        assertTrue(itemImage.isDisplayed());
        assertTrue(itemName.isDisplayed());
        assertTrue(itemDescription.isDisplayed());
        assertTrue(itemPrice.isDisplayed());
        assertTrue(itemAddToCartButton.isDisplayed());

        assertEquals(itemName.getText(), itemImage.getAttribute("alt"));
        assertEquals("inventory_item_name", itemName.getAttribute("class"));
        assertEquals("inventory_item_desc", itemName.getAttribute("class"));
    }

    public String getItemImageSrc() {
        return itemImage.getAttribute("src");
    }

    public String getItemName() {
        return itemName.getText();
    }

    public String getItemDescription() {
        return itemDescription.getText();
    }

    public String getItemPrice() {
        return itemPrice.getText();
    }

    public ItemComponent addToCartClick() {
        itemAddToCartButton.click();
        return this;
    }

    public ItemComponent assertConditionAddToCartButton(String expectedText) {
        assertTrue(itemAddToCartButton.getText().equalsIgnoreCase(expectedText));
        return this;
    }

    public ItemDetailsPage clickToItemsDetailsPageByImage() {
        itemImage.click();
        return new ItemDetailsPage(driver);
    }

    public ItemDetailsPage clickToItemsDetailsPageByName() {
        itemName.click();
        return new ItemDetailsPage(driver);
    }
}
