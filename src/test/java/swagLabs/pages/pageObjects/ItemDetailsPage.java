package swagLabs.pages.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import swagLabs.pages.basePage.DefaultSettingsPage;
import swagLabs.pages.interfacePages.ItemInterface;
import swagLabs.pages.pageComponents.HeaderComponent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemDetailsPage extends DefaultSettingsPage implements ItemInterface {
    private HeaderComponent header;
    @FindBy(css = "button#back-to-products")
    private WebElement backToProductsButton;
    @FindBy(css = "div.inventory_details")
    private WebElement item;
    @FindBy(css = "img.inventory_details_img")
    private WebElement itemImage;
    @FindBy(css = "div.inventory_details_name")
    private WebElement itemName;
    @FindBy(css = "div.inventory_details_desc")
    private WebElement itemDescription;
    @FindBy(css = "div.inventory_details_price")
    private WebElement itemPrice;
    @FindBy(css = "button.btn")
    private WebElement itemAddToCartButton;

    public ItemDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        defaultWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.inventory_details")));

        this.driver = driver;
        this.header = new HeaderComponent(driver);
    }

    public void assertItemDetailsPageIsLoad() {
        assertTrue(itemImage.isDisplayed());
        assertTrue(itemName.isDisplayed());
        assertTrue(itemDescription.isDisplayed());
        assertTrue(itemPrice.isDisplayed());
        assertTrue(itemAddToCartButton.isDisplayed());

        assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory-item"));
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
