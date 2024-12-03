import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
    public void testEmptyFieldLabels() {
        onlineRechargePage.checkEmptyFieldLabels();
    }

    @Test
    public void testFillConnectionServices() {
        onlineRechargePage.fillConnectionServices("1234567890");
        onlineRechargePage.verifyDetailsAfterContinue("100 BYN", "1234567890");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
