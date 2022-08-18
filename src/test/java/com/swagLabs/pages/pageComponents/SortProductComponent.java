package com.swagLabs.pages.pageComponents;

import com.swagLabs.exceptions.UnknownSortOptionException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.swagLabs.pages.basePage.DefaultSettingsPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SortProductComponent extends DefaultSettingsPage {
    @FindBy(css = "select.select_container")
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
        assertFalse(sortOptions.get(0).isDisplayed());
        assertFalse(sortOptions.get(sortOptions.size() - 1).isDisplayed());
    }

    public void selectSortOption(String option) throws UnknownSortOptionException {
        for (WebElement sortOption : sortOptions) {
            if (sortOption.getText().equalsIgnoreCase(option)) {
                sortOption.click();
                assertEquals(option, sortContainer.findElement(By.cssSelector("span.active_option")).getText());
                return;
            }
        }
        throw new UnknownSortOptionException("Неизвестный параметр сортировки: " + option);
    }
}
