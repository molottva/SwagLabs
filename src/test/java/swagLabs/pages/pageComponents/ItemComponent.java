package swagLabs.pages.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemComponent {
    private final WebDriver driver;
    private final WebElement item;
    private final WebElement itemImage;
    private final WebElement itemName;
    private final WebElement itemDescription;
    private final WebElement itemPrice;
    private final WebElement itemAddToCartButton;

    public ItemComponent(WebDriver driver, WebElement item) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.inventory_item")));

        this.item = item;
        this.itemImage = item.findElement(By.cssSelector("img.inventory_item_img"));
        this.itemName = item.findElement(By.cssSelector("div.inventory_item_name"));
        this.itemDescription = item.findElement(By.cssSelector("div.inventory_item_desc"));
        this.itemPrice = item.findElement(By.cssSelector("div.inventory_item_price"));
        this.itemAddToCartButton = item.findElement(By.cssSelector("button.btn"));

        assertTrue(itemImage.isDisplayed());
        assertTrue(itemName.isDisplayed());
        assertTrue(itemDescription.isDisplayed());
        assertTrue(itemPrice.isDisplayed());
        assertTrue(itemAddToCartButton.isDisplayed());
    }
}
