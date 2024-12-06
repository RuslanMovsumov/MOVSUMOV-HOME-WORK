package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.OnlineRechargePage;

import static org.junit.jupiter.api.Assertions.*;

public class MTSOnlineRechargeTests {
    private WebDriver driver;
    private OnlineRechargePage onlineRechargePage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito"); // Открываем в режиме инкогнито
        driver = new ChromeDriver(options);
        driver.manage().window().maximize(); // Разворачиваем окно браузера
        driver.get("https://mts.by");
        onlineRechargePage = new OnlineRechargePage(driver);
    }

    @Test
    public void testBlockTitle() {
        assertEquals("Онлайн пополнение без комиссии", onlineRechargePage.getBlockTitle());
    }

    @Test
    public void testPaymentSystemLogos() {
        assertTrue(onlineRechargePage.arePaymentSystemLogosPresent());
    }

    @Test
    public void testMoreInfoLink() {
        onlineRechargePage.clickMoreInfoLink();
        assertTrue(driver.getCurrentUrl().contains("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/")); 
        driver.navigate().back();
    }

    @Test
    public void testFormFunctionality() {
        onlineRechargePage.selectServiceType("Услуги связи");
        onlineRechargePage.enterPhoneNumber("297777777");
        onlineRechargePage.clickContinueButton();
        assertTrue(onlineRechargePage.isResultMessageDisplayed());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
