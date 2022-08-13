package swagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import swagLabs.helpers.DataHelper;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MainPage {
    private final WebDriver driver;
    private final WebElement loginForm;
    private final WebElement usernameInput;
    private final WebElement passwordInput;
    private final WebElement loginButton;
    private final WebElement errorMessage;
//    private final WebElement errorNotification;
//    private final WebElement errorButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //todo переделать проверку с url на более правильную
        assertTrue(wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/")));

        this.loginForm = driver.findElement(By.cssSelector("div[id='login_button_container']"));
        this.usernameInput = loginForm.findElement(By.cssSelector("input[id='user-name']"));
        this.passwordInput = loginForm.findElement(By.cssSelector("input[id='password']"));
        this.loginButton = loginForm.findElement(By.cssSelector("input[data-test='login-button']"));
        this.errorMessage = loginForm.findElement(By.cssSelector("div.error-message-container"));

        //todo перенести в проверку с невалидными данными пользователя
//        this.errorNotification = loginForm.findElement(By.cssSelector("h3[data-test='error']"));
//        this.errorButton = errorNotification.findElement(By.cssSelector("button.error-button"));

        assertTrue(loginForm.isDisplayed());
        assertTrue(usernameInput.isDisplayed());
        assertTrue(passwordInput.isDisplayed());
        assertTrue(loginButton.isDisplayed());

        assertEquals("error-message-container", errorMessage.getAttribute("class"));
    }

    public InventoryPage assertSuccessLogin(String login, String password) {
        usernameInput.sendKeys(login);
        passwordInput.sendKeys(password);

        loginButton.click();
        return new InventoryPage(driver);
    }
}
