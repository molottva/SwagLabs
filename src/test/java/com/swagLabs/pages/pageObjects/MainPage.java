package com.swagLabs.pages.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.swagLabs.pages.basePage.DefaultSettingsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPage extends DefaultSettingsPage {
    @FindBy(css = "div[id='login_button_container']")
    private WebElement loginForm;
    @FindBy(css = "input[id='user-name']")
    private WebElement usernameInput;
    @FindBy(css = "input[id='password']")
    private WebElement passwordInput;
    @FindBy(css = "input[data-test='login-button']")
    private WebElement loginButton;
    @FindBy(css = "div.error-message-container")
    private WebElement errorContainer;
    @FindBy(css = "h3[data-test='error']")
    private WebElement errorNotification;
    @FindBy(css = "button.error-button")
    private WebElement errorButton;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        defaultWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#root")));
    }

    public MainPage assertPageIsLoad() {
        assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
        assertEquals("Swag Labs", driver.getTitle());

        assertTrue(loginForm.isDisplayed());
        assertTrue(usernameInput.isDisplayed());
        assertTrue(passwordInput.isDisplayed());
        assertTrue(loginButton.isDisplayed());

        assertEquals("input_error form_input", usernameInput.getAttribute("class"));
        assertEquals("input_error form_input", passwordInput.getAttribute("class"));
        assertEquals("error-message-container", errorContainer.getAttribute("class"));
        return this;
    }

    public MainPage inputLoginForm(String login, String password) {
        usernameInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
        return this;
    }

    public InventoryPage assertLoginIsSuccessful(String login, String password) {
        inputLoginForm(login, password);
        return new InventoryPage(driver);
    }

    public MainPage assertLoginIsFailing(String login, String password) {
        inputLoginForm(login, password);

        assertEquals("input_error form_input error", usernameInput.getAttribute("class"));
        assertEquals("input_error form_input error", passwordInput.getAttribute("class"));
        assertEquals("error-message-container error", errorContainer.getAttribute("class"));

        errorNotification = loginForm.findElement(By.cssSelector("h3[data-test='error']"));
        errorButton = errorNotification.findElement(By.cssSelector("button.error-button"));
        return this;
    }

    public String getTextFromErrorNotification() {
        return errorNotification.getText();
    }

    public MainPage closingErrorNotification() {
        errorButton.click();

        assertEquals("input_error form_input", usernameInput.getAttribute("class"));
        assertEquals("input_error form_input", passwordInput.getAttribute("class"));
        assertEquals("error-message-container", errorContainer.getAttribute("class"));
        return this;
    }
}
