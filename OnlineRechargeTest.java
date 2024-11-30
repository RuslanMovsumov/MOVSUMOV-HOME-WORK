import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlineRechargeTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("URL_вашего_сайта");
        
        OnlineRechargePage onlineRechargePage = new OnlineRechargePage(driver);
        onlineRechargePage.checkEmptyFieldLabels();
        onlineRechargePage.fillConnectionServices("1234567890");

        // Закрытие драйвера после выполнения теста
        driver.quit();
    }
}
