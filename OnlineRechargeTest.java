import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlineRechargeTest {
    private WebDriver driver;
    private OnlineRechargePage onlineRechargePage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");  
        onlineRechargePage = new OnlineRechargePage(driver);
    }

    @Test
    public void testOnlineRechargePage() {
        onlineRechargePage.checkEmptyFieldLabels();
        onlineRechargePage.fillConnectionServices("1234567890");
        onlineRechargePage.verifyDetailsAfterContinue("Ожидаемая сумма");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
