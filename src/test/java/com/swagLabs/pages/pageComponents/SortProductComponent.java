package com.swagLabs.pages.pageComponents;

import com.swagLabs.exceptions.UnknownSortOptionException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.swagLabs.pages.generalPages.basePage.DefaultSettingsPage;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class SortProductComponent extends DefaultSettingsPage {
    @FindBy(css = "select.product_sort_container")
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

    public void selectSortOption(String value) throws UnknownSortOptionException {
        try {
            Select select = new Select(sortContainer);
            select.selectByValue(value);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new UnknownSortOptionException("Неизвестный параметр сортировки: " + value);
        }
    }
}
