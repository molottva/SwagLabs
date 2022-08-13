package swagLabs.tests.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import swagLabs.helpers.DataHelper;
import swagLabs.pages.MainPage;

public class UITests {
    private WebDriver driver;

    @BeforeAll
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "./webdrivers/chromedriver.exe");
    }

    @BeforeEach
    public void setUpMethod() {
        this.driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterEach
    public void tierDownMethod() {
        driver.close();
        driver.quit();
        driver = null;
    }

    @Test
    public void shouldLoginAsSuccessful() {
        driver.get("https://www.saucedemo.com/");
        var mainPage = new MainPage(driver);
        var user = DataHelper.getStandardUser();

        var inventoryPage = mainPage.assertSuccessLogin(user.getLogin(), user.getPassword());
    }
}
