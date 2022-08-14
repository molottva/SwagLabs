package swagLabs.pages.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MainPage {
    private final WebDriver driver;
    private final WebElement loginForm;
    private final WebElement usernameInput;
    private final WebElement passwordInput;
    private final WebElement loginButton;

    private final WebElement errorContainer;
    private WebElement errorNotification;
    private WebElement errorButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#root")));
        assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
        assertEquals("Swag Labs", driver.getTitle());

        this.loginForm = driver.findElement(By.cssSelector("div[id='login_button_container']"));
        this.usernameInput = loginForm.findElement(By.cssSelector("input[id='user-name']"));
        this.passwordInput = loginForm.findElement(By.cssSelector("input[id='password']"));
        this.loginButton = loginForm.findElement(By.cssSelector("input[data-test='login-button']"));
        this.errorContainer = loginForm.findElement(By.cssSelector("div.error-message-container"));

        assertTrue(loginForm.isDisplayed());
        assertTrue(usernameInput.isDisplayed());
        assertTrue(passwordInput.isDisplayed());
        assertTrue(loginButton.isDisplayed());

        assertEquals("input_error form_input", usernameInput.getAttribute("class"));
        assertEquals("input_error form_input", passwordInput.getAttribute("class"));
        assertEquals("error-message-container", errorContainer.getAttribute("class"));
    }

    public void inputLoginForm(String login, String password) {
        usernameInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public InventoryPage assertSuccessfulLogin(String login, String password) {
        inputLoginForm(login, password);
        return new InventoryPage(driver);
    }

    public void assertFailingLogin(String login, String password) {
        inputLoginForm(login, password);

        assertEquals("input_error form_input error", usernameInput.getAttribute("class"));
        assertEquals("input_error form_input error", passwordInput.getAttribute("class"));
        assertEquals("error-message-container error", errorContainer.getAttribute("class"));

        errorNotification = loginForm.findElement(By.cssSelector("h3[data-test='error']"));
        errorButton = errorNotification.findElement(By.cssSelector("button.error-button"));
    }

    public String getTextFromErrorNotification() {
        return errorNotification.getText();
    }

    public void closingErrorNotification() {
        errorButton.click();

        assertEquals("input_error form_input", usernameInput.getAttribute("class"));
        assertEquals("input_error form_input", passwordInput.getAttribute("class"));
        assertEquals("error-message-container", errorContainer.getAttribute("class"));
    }
}
