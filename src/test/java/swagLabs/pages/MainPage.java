package swagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import swagLabs.helpers.DataHelper;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPage {
    private static final WebDriver driver = new ChromeDriver();
    private static final WebElement loginForm = driver.findElement(By.cssSelector("div[id='login_button_container']"));
    private static final WebElement usernameInput = loginForm.findElement(By.cssSelector("input[id='user-name']"));
    private static final WebElement passwordInput = loginForm.findElement(By.cssSelector("input[id='password']"));
    private static final WebElement loginButton = loginForm.findElement(By.cssSelector("input[data-test='login-button']"));
    private static final WebElement errorNotification = loginForm.findElement(By.cssSelector("h3[data-test='error']"));
    private static final WebElement errorButton = errorNotification.findElement(By.cssSelector("button.error-button"));

    //todo посмотреть ExpectedCondition
    public MainPage() {
        assertTrue(loginForm.isDisplayed());
        assertTrue(usernameInput.isDisplayed());
        assertTrue(passwordInput.isDisplayed());
        assertTrue(loginButton.isDisplayed());
        assertFalse(errorNotification.isEnabled());
        assertFalse(errorButton.isEnabled());
    }

    public InventoryPage assertSuccessLogin(DataHelper.UserLoginData user) {
        usernameInput.sendKeys(user.getLogin());
        passwordInput.sendKeys(user.getPassword());
        loginButton.click();

        assertFalse(errorNotification.isEnabled());
        assertFalse(errorButton.isEnabled());
        return new InventoryPage();
    }
}
