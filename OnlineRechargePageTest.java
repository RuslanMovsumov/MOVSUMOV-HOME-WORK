import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

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
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка пустых меток полей")
    @Step("Проверка пустых меток полей")
    public void testEmptyFieldLabels() {
        onlineRechargePage.checkEmptyFieldLabels();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Заполнение услуг связи и проверка деталей")
    public void testFillConnectionServices() {
        fillService("1234567890");
        onlineRechargePage.verifyDetailsAfterContinue("100 BYN", "1234567890");
    }

    @Step("Заполнение номера услуги связи")
    public void fillService(String phoneNumber) {
        onlineRechargePage.fillConnectionServices(phoneNumber);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
