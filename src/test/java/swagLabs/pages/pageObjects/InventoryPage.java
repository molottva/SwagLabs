package swagLabs.pages.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import swagLabs.pages.pageComponents.HeaderComponent;
import swagLabs.pages.pageComponents.SortProductComponent;
import swagLabs.pages.pageComponents.ItemComponent;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryPage {
    private final WebDriver driver;
    private final HeaderComponent header;
    private final SortProductComponent sortProductComponent;
    private final WebElement inventoryList;
    private List<ItemComponent> items;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#root")));
        assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory"));

        this.header = new HeaderComponent(driver);
        this.sortProductComponent = new SortProductComponent(driver);
        this.inventoryList = driver.findElement(By.cssSelector("div.inventory_list"));
        this.items = getItems();

        assertTrue(inventoryList.isEnabled());
        assertFalse(items.isEmpty());
    }

    public List<ItemComponent> getItems() {
        List<WebElement> tmp = inventoryList.findElements(By.cssSelector("div.inventory_item"));
        this.items = new ArrayList<>();
        for (int i = 0; i < tmp.size(); i++) {
            items.add(new ItemComponent(driver, tmp.get(i)));
        }
        return items;
    }
}
