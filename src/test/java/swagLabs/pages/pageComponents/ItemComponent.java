package swagLabs.pages.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import swagLabs.pages.basePage.DefaultSettingsPage;
import swagLabs.pages.interfacePages.ItemInterface;

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
        //todo проверка на значения аттрибутов у названия и изображения
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
}
