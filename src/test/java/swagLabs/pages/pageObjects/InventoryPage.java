package swagLabs.pages.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import swagLabs.pages.basePage.DefaultSettingsPage;
import swagLabs.pages.pageComponents.HeaderComponent;
import swagLabs.pages.pageComponents.ItemComponent;
import swagLabs.pages.pageComponents.SortProductComponent;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryPage extends DefaultSettingsPage {
    private HeaderComponent header;
    private SortProductComponent sortProductComponent;
    @FindBy(css = "div.inventory_list")
    private WebElement inventoryList;
    @FindAll(@FindBy (css = "div.inventory_item"))
    private List<ItemComponent> items;

    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        defaultWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#root")));

        this.header = new HeaderComponent(this.driver);
        this.sortProductComponent = new SortProductComponent(this.driver);
    }

    public InventoryPage assertInventoryPageIsLoad() {
        assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory"));

        assertTrue(inventoryList.isEnabled());
        assertFalse(items.isEmpty());
        return this;
    }
}
