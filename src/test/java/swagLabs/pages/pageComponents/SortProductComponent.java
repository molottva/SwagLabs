package swagLabs.pages.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortProductComponent {
    private final WebDriver driver;
    private final WebElement sortContainer;
    private final List<WebElement> sortOptions;

    public SortProductComponent(WebDriver driver) {
        this.driver = driver;

        this.sortContainer = driver.findElement(By.cssSelector("select[data-test='product_sort_container']"));
        this.sortOptions = sortContainer.findElements(By.cssSelector("option"));

        assertTrue(sortContainer.isDisplayed());
    }

    //todo добавить метод на выбор сортировки
}
