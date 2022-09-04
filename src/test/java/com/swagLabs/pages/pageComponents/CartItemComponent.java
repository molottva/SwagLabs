package com.swagLabs.pages.pageComponents;

import com.swagLabs.pages.generalPages.basePage.DefaultSettingsPage;
import com.swagLabs.pages.generalPages.interfacePages.ItemInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

//todo перенести кнопку remove в CartPage
public class CartItemComponent extends DefaultSettingsPage implements ItemInterface {
    @FindBy(css = "div.cart_quantity")
    private WebElement quantity;
    @FindBy(css = "div.inventory_item_name")
    private WebElement name;
    @FindBy(css = "inventory_item_desc")
    private WebElement description;
    @FindBy(css = "inventory_item_price")
    private WebElement price;
    @FindBy(css = "button.cart_button")
    private WebElement removeButton;

    public CartItemComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CartItemComponent assertCartItemComponentIsLoad() {
        assertTrue(quantity.isDisplayed());
        assertTrue(name.isDisplayed());
        assertTrue(description.isDisplayed());
        assertTrue(price.isDisplayed());
        assertTrue(removeButton.isDisplayed());
        return this;
    }

    public void clickRemoveBtn() {
        removeButton.click();
    }

    @Override
    public String getItemImageSrc() {
        return null;
    }

    @Override
    public String getItemName() {
        return name.getText();
    }

    @Override
    public String getItemDescription() {
        return description.getText();
    }

    @Override
    public String getItemPrice() {
        return price.getText();
    }
}
