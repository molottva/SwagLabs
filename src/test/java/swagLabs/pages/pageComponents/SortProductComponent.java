package swagLabs.pages.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import swagLabs.pages.basePage.DefaultSettingsPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortProductComponent extends DefaultSettingsPage {
    @FindBy(css = "select[data-test='product_sort_container']")
    private WebElement sortContainer;
    @FindAll(@FindBy(css = "select[data-test='product_sort_container'] option"))
    private List<WebElement> sortOptions;

    public SortProductComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        defaultWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.select_container")));
    }

    public void assertSortProductComponentIsLoad() {
        assertTrue(sortContainer.isDisplayed());
    }

    //todo добавить метод на выбор сортировки
}
