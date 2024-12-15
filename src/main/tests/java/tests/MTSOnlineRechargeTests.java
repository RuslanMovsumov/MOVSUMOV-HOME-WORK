package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description; // Импортируем аннотацию Allure
import io.qameta.allure.Step; // Импортируем аннотацию для шагов
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import pageobjects.OnlineRechargePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MTSOnlineRechargeTests {
    private WebDriver driver;
    private OnlineRechargePage onlineRechargePage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://mts.by");

        // Принятие cookie
        driver.findElement(By.cssSelector("#cookie-agree")).click();
        onlineRechargePage = new OnlineRechargePage(driver);
    }

    @Test
    @Description("Проверка заголовка блока на странице онлайн пополнения.")
    public void testBlockTitle() {
        assertEquals("Онлайн пополнение без комиссии", onlineRechargePage.getBlockTitle());
    }

    @Test
    @Description("Проверка наличия логотипов платежных систем.")
    public void testPaymentSystemLogos() {
        List<String> actualLogoList = onlineRechargePage.arePaymentSystemLogosPresent();
        if (actualLogoList.isEmpty()) {
            fail("Логотипы не найдены");
        }

        assertAll(
            () -> { assertTrue(actualLogoList.contains("Visa")); },
            () -> { assertTrue(actualLogoList.contains("Verified By Visa")); },
            () -> { assertTrue(actualLogoList.contains("MasterCard")); },
            () -> { assertTrue(actualLogoList.contains("MasterCard Secure Code")); },
            () -> { assertTrue(actualLogoList.contains("Белкарт")); }
        );
    }


    @Test
    @Description("Проверка перехода по ссылке 'Подробнее о сервисе'.")
    public void testMoreInfoLink() {
        onlineRechargePage.clickMoreInfoLink();
        assertTrue(driver.getCurrentUrl().contains("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/")); 
        driver.navigate().back();
    }

    @Test
    @Description("Проверка функциональности формы онлайн пополнения.")
    public void testFormFunctionality() {
        onlineRechargePage.selectServiceType("Услуги связи");
        onlineRechargePage.enterPhoneNumber("297777777");
        onlineRechargePage.clickContinueButton();
        assertTrue(onlineRechargePage.isResultMessageDisplayed(), "Сообщение результата не отображается");
    }

    @Test
    @Description("Проверка наличия сообщений об ошибках для различных типов услуг.")
    public void testFieldErrorsForServiceTypes() {
        String[] serviceTypes = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"};

        for (String serviceType : serviceTypes) {
            onlineRechargePage.selectServiceType(serviceType);
            onlineRechargePage.clickContinueButton();
            
            List<String> errors = onlineRechargePage.getFieldErrors();
            assertFalse(errors.isEmpty(), "Ошибки не найдены для типа услуги: " + serviceType);
        }
    }

    @Test
    @Description("Проверка онлайн пополнения для типа услуги 'Услуги связи'.")
    public void testOnlineRechargeForServiceType() {
        String phoneNumber = "297777777"; 
        String expectedAmount = "100";  
        onlineRechargePage.selectServiceType("Услуги связи");
        onlineRechargePage.enterPhoneNumber(phoneNumber);
        onlineRechargePage.clickContinueButton();

        assertTrue(onlineRechargePage.isCorrectDisplayAfterContinue(expectedAmount, phoneNumber), 
            "Данные на экране не соответствуют ожидаемым после продолжения.");

        List<String> actualLogos = onlineRechargePage.getPaymentSystemLogos();
        assertFalse(actualLogos.isEmpty(), "Логотипы платежных систем не найдены.");
    } 

    @Test
    @Description("Проверка клика по кнопке 'Продолжить'.")
    public void testClickContinueButton() {
        onlineRechargePage.selectServiceType("Услуги связи");
        String phoneNumber = "1234567890";
        onlineRechargePage.enterPhoneNumber(phoneNumber);

        assertTrue(onlineRechargePage.isPhoneNumberValid(phoneNumber), "Номер телефона введен некорректно");

        onlineRechargePage.clickContinueButton();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultMessage")));
        assertTrue(onlineRechargePage.isResultMessageDisplayed(), "Сообщение результата не отображается для номера телефона: " + phoneNumber);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
