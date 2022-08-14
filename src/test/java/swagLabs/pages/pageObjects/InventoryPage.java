package swagLabs.pages.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import swagLabs.pages.pageComponents.HeaderComponent;
import swagLabs.pages.pageComponents.HeaderProductsComponent;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryPage {
    private final WebDriver driver;
    private final HeaderComponent header;
    private final HeaderProductsComponent headerProducts;
    private final WebElement inventoryList;
    private final List<WebElement> inventoryListItems;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#root")));
        assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory"));

        this.header = new HeaderComponent(driver);
        this.headerProducts = new HeaderProductsComponent(driver);
        this.inventoryList = driver.findElement(By.cssSelector("div.inventory_list"));
        this.inventoryListItems = inventoryList.findElements(By.cssSelector("div.inventory_item"));

        assertTrue(inventoryList.isEnabled());
        assertTrue(inventoryListItems.get(0).isDisplayed());
    }
}
