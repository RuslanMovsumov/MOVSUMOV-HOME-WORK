package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By; // Импорт для использования By
import pageobjects.OnlineRechargePage;
import java.util.List; // Импорт для использования List

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

        // Принятие cookie
        driver.switchTo().activeElement();
        driver.findElement(By.cssSelector("#cookie-agree")).click();
        driver.switchTo().defaultContent();

        onlineRechargePage = new OnlineRechargePage(driver);
    }

    @Test
    public void testBlockTitle() {
        assertEquals("Онлайн пополнение без комиссии", onlineRechargePage.getBlockTitle());
    }

    @Test
    public void testPaymentSystemLogos() {
        List<String> actualLogoList = onlineRechargePage.arePaymentSystemLogosPresent();
        assertFalse(actualLogoList.isEmpty(), "Логотипы не найдены");

        assertAll(
            () -> assertTrue(actualLogoList.contains("Visa"), "Логотип Visa отсутствует"),
            () -> assertTrue(actualLogoList.contains("Verified By Visa"), "Логотип Verified By Visa отсутствует"),
            () -> assertTrue(actualLogoList.contains("MasterCard"), "Логотип MasterCard отсутствует"),
            () -> assertTrue(actualLogoList.contains("MasterCard Secure Code"), "Логотип MasterCard Secure Code отсутствует"),
            () -> assertTrue(actualLogoList.contains("Белкарт"), "Логотип Белкарт отсутствует")
        );
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

    @Test
    public void testOnlineRecharge() { 
        // Проверка надписей в незаполненных полях
        List<String> errors = onlineRechargePage.getFieldErrors();
        
        // Проверка по варианту «Услуги связи»
        String phoneNumber = "1234567890"; 
        String expectedAmount = "100";  
        onlineRechargePage.fillConnectionServices(phoneNumber);

        // Проверка отображения суммы и других полей
        boolean isDisplayCorrect = onlineRechargePage.isCorrectDisplayAfterContinue(expectedAmount, phoneNumber);
        assertTrue(isDisplayCorrect, "Данные на экране правильные.");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
