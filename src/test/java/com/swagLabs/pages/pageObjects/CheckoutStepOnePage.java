package com.swagLabs.pages.pageObjects;

import com.swagLabs.pages.generalPages.basePage.DefaultSettingsPage;
import com.swagLabs.pages.pageComponents.HeaderComponent;
import com.swagLabs.pages.pageComponents.NavbarComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

//todo class
public class CheckoutStepOnePage extends DefaultSettingsPage {
    private HeaderComponent headerComponent;
    private NavbarComponent navbarComponent;
    @FindBy(id = "first-name")
    private WebElement firstNameInput;
    @FindBy(id = "last-name")
    private WebElement lastNameInput;
    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;
    @FindBy(css = "div.error-message-container h3")
    private WebElement errorMessage;
    @FindBy(css = "button.error-button")
    private WebElement errorCloseButton;
    @FindBy(id = "cancel")
    private WebElement cancelButton;
    @FindBy(id = "continue")
    private WebElement continueButton;

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        defaultWait.until(ExpectedConditions.presenceOfElementLocated(By.id("checkout_info_container")));

        this.headerComponent = new HeaderComponent(driver);
        this.navbarComponent = new NavbarComponent(driver);
    }

    public CheckoutStepOnePage acceptCheckoutPageIsLoad() {
        assertEquals("https://www.saucedemo.com/checkout-step-one.html", driver.getCurrentUrl());
        headerComponent.assertHeaderComponentIsLoad();
        navbarComponent.assertNavbarComponentIsLoad();

        assertTrue(firstNameInput.isDisplayed());
        assertTrue(lastNameInput.isDisplayed());
        assertTrue(postalCodeInput.isDisplayed());
        assertTrue(cancelButton.isDisplayed());
        assertTrue(continueButton.isDisplayed());

        assertEquals("input_error form_input", firstNameInput.getAttribute("class"));
        assertEquals("input_error form_input", lastNameInput.getAttribute("class"));
        assertEquals("input_error form_input", postalCodeInput.getAttribute("class"));

        assertFalse(errorMessage.isDisplayed());
        assertFalse(errorCloseButton.isDisplayed());
        return this;
    }

    public CheckoutStepOnePage typeForm(String firstName, String lastName, String postalCode) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(postalCode);
        return this;
    }

    public CheckoutStepTwoPage assertTypeFormIsSuccessful(String firstName, String lastName, String postalCode) {
        this.typeForm(firstName, lastName, postalCode);
        assertFalse(errorMessage.isDisplayed());
        assertFalse(errorCloseButton.isDisplayed());
        return clickToContinue();
    }

    public CheckoutStepOnePage assertTypeFormIsFailed(String firstName, String lastName, String postalCode) {
        this.typeForm(firstName, lastName, postalCode);
        clickToContinue();

        assertEquals("input_error form_input error", firstNameInput.getAttribute("class"));
        assertEquals("input_error form_input error", lastNameInput.getAttribute("class"));
        assertEquals("input_error form_input error", postalCodeInput.getAttribute("class"));

        assertTrue(errorMessage.isDisplayed());
        assertTrue(errorCloseButton.isDisplayed());
        return this;
    }

    public String getTextFromErrorMessage() {
        return errorMessage.getText();
    }

    public CheckoutStepOnePage closeErrorMessage() {
        errorCloseButton.click();

        assertEquals("input_error form_input", firstNameInput.getAttribute("class"));
        assertEquals("input_error form_input", lastNameInput.getAttribute("class"));
        assertEquals("input_error form_input", postalCodeInput.getAttribute("class"));

        assertFalse(errorMessage.isDisplayed());
        assertFalse(errorCloseButton.isDisplayed());
        return this;
    }

    public CartPage clickToCancel() {
        cancelButton.click();
        return new CartPage(driver);
    }

    public CheckoutStepTwoPage clickToContinue() {
        continueButton.click();
        return new CheckoutStepTwoPage(driver);
    }
}
