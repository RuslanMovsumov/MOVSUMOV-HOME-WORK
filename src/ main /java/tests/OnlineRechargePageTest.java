import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterEach;
import org.testng.annotations.BeforeEach;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

public class OnlineRechargePageTest {
    private WebDriver driver;
    private OnlineRechargePage onlineRechargePage;

     @BeforeEach 
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        onlineRechargePage = new OnlineRechargePage(driver);
        driver.get("https://mts.by/online-recharge");
    }

    @Test
    @Description("Проверка наполнения пустых полей ввода на странице онлайн-пополнения")
    @Story("Проверка обязательных полей ввода")
    public void testEmptyFieldPlaceholders() {
        performServiceTypeSelection("Услуги связи");
        onlineRechargePage.enterPhoneNumber(""); 
        onlineRechargePage.clickContinueButton();

        assertEquals("Введите номер карты", onlineRechargePage.getCardNumberPlaceholder());
        assertEquals("Введите срок действия карты", onlineRechargePage.getExpirationDatePlaceholder());
        assertEquals("Введите CVC", onlineRechargePage.getCVCPlaceholder());
    }

    @Test
    @Description("Тестирование отображения данных при оплате услуг связи")
    @Story("Проверка успешной оплаты услуг")
    public void testServicePaymentDetails() {
        performServiceTypeSelection("Услуги связи");
        onlineRechargePage.enterPhoneNumber("297777777");
        onlineRechargePage.clickContinueButton();

        assertEquals("Ожидаемая сумма", onlineRechargePage.getDisplayedAmount(), "Корректная ожидаемая сумма");
        assertEquals("297777777", onlineRechargePage.getDisplayedPhone(), "Корректный номер телефона");

        List<String> actualLogos = onlineRechargePage.getPaymentSystemLogos();
        assertTrue(actualLogos.contains("Visa"), "Логотип Visa");
        assertTrue(actualLogos.contains("MasterCard"), "Логотип MasterCard");
    }

    private void performServiceTypeSelection(String serviceType) {
        onlineRechargePage.selectServiceType(serviceType);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
