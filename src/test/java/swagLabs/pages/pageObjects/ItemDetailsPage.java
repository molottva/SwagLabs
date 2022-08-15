package swagLabs.pages.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemDetailsPage {
    private final WebDriver driver;
    private final WebElement itemDetails;
    private final WebElement itemDetailsImage;
    private final WebElement itemDetailsName;
    private final WebElement itemDetailsDescription;
    private final WebElement itemDetailsPrice;
    private final WebElement itemAddToCartButton;

    public ItemDetailsPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.inventory_details")));
        assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory-item"));

        this.itemDetails = driver.findElement(By.cssSelector("div.inventory_details"));
        this.itemDetailsImage = itemDetails.findElement(By.cssSelector("img.inventory_details_img"));
        this.itemDetailsName = itemDetails.findElement(By.cssSelector("div.inventory_details_name"));
        this.itemDetailsDescription = itemDetails.findElement(By.cssSelector("div.inventory_details_desc"));
        this.itemDetailsPrice = itemDetails.findElement(By.cssSelector("div.inventory_details_price"));
        this.itemAddToCartButton = itemDetails.findElement(By.cssSelector("button.btn"));

        assertTrue(itemDetailsImage.isDisplayed());
        assertTrue(itemDetailsName.isDisplayed());
        assertTrue(itemDetailsDescription.isDisplayed());
        assertTrue(itemDetailsPrice.isDisplayed());
        assertTrue(itemAddToCartButton.isDisplayed());

        assertEquals(itemDetailsName.getText(), itemDetailsImage.getAttribute("alt"));
    }

    public String getItemImageSrc() {
        return itemDetailsImage.getAttribute("src");
    }

    public String getItemDetailsName() {
        return itemDetailsName.getText();
    }

    public String getItemDetailsDescription() {
        return itemDetailsDescription.getText();
    }

    public String getItemDetailsPrice() {
        return itemDetailsPrice.getText();
    }
}
