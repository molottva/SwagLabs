package swagLabs.pages.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HeaderComponent {
    private final WebDriver driver;
    private final WebElement logo;
    private final WebElement menuContainerButton;
    private final List<WebElement> menuItem;
    private final WebElement cartButton;

    public HeaderComponent(WebDriver driver) {
        this.driver = driver;

        this.logo = driver.findElement(By.cssSelector("div.app_logo"));
        this.menuContainerButton = driver.findElement(By.cssSelector("button#react-burger-menu-btn"));
        this.menuItem = menuContainerButton.findElements(By.cssSelector("nav.bm-item-list a"));
        this.cartButton = driver.findElement(By.cssSelector("div#shopping_cart_container"));
    }
}
