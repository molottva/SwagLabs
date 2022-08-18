package swagLabs.pages.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import swagLabs.pages.basePage.DefaultSettingsPage;

import java.util.List;

public class HeaderComponent extends DefaultSettingsPage {
    @FindBy(css = "div.app_logo")
    private WebElement logo;
    @FindBy(css = "button#react-burger-menu-btn")
    private WebElement menuContainerButton;
    @FindBy(css = "nav.bm-item-list a")
    private List<WebElement> menuItem;
    @FindBy(css = "div#shopping_cart_container")
    private WebElement cartButton;

    public HeaderComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        defaultWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.primary_header")));
    }
}
