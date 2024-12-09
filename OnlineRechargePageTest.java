import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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

    @BeforeClass
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
        onlineRechargePage.selectServiceType("Услуги связи");
        onlineRechargePage.enterPhoneNumber(""); 
        onlineRechargePage.clickContinueButton();

        assertEquals("Введите номер карты", onlineRechargePage.getCardNumberPlaceholder());
        assertEquals("Введите срок действия карты", onlineRechargePage.getCardExpiryPlaceholder());
        assertEquals("Введите CVC", onlineRechargePage.getCvcPlaceholder());
    }

    @Test
    @Description("Тестирование отображения данных при оплате услуг связи")
    @Story("Проверка успешной оплаты услуг")
    public void testServicePaymentDetails() {
        onlineRechargePage.selectServiceType("Услуги связи");
        onlineRechargePage.enterPhoneNumber("297777777");
        onlineRechargePage.clickContinueButton();

        assertEquals("Ожидаемая сумма", onlineRechargePage.getDisplayedAmount());
        assertEquals("297777777", onlineRechargePage.getDisplayedPhone());
        assertEquals("Введите номер карты", onlineRechargePage.getCardNumberPlaceholder());
        assertEquals("Введите срок действия карты", onlineRechargePage.getCardExpiryPlaceholder());
        assertEquals("Введите CVC", onlineRechargePage.getCvcPlaceholder());

        List<String> actualLogos = onlineRechargePage.getPaymentSystemLogos();
        assertTrue(actualLogos.contains("Visa"));
        assertTrue(actualLogos.contains("MasterCard"));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
  }
