import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.Assert.assertTrue;

public class OnlineRechargeTest {
    private WebDriver driver;
    private OnlineRechargePage onlineRechargePage;

    @Before
    public void setUp() {
        // Устанавливаем драйвер браузера
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize(); 
        driver.get("https://www.mts.by/");  
        onlineRechargePage = new OnlineRechargePage(driver);
    }

    @Test
    public void testOnlineRechargePage() {
        // Проверяем названия пустых полей
        onlineRechargePage.checkEmptyFieldLabels();

        // Заполняем информацию и нажимаем кнопку "Продолжить"
        onlineRechargePage.fillConnectionServices("1234567890");

        // Замените "Ожидаемая сумма" на правильное значение, которое ваше приложение должно отображать
        String expectedAmount = "Ожидаемая сумма"; 
        String expectedPhoneNumber = "297777777"; 

        // Проверяем результаты после нажатия кнопки "Продолжить"
        onlineRechargePage.verifyDetailsAfterContinue(expectedAmount, expectedPhoneNumber);
        
        // Дополнительная проверка, чтобы убедиться, что иконки платежных систем отображаются
        assertTrue("Иконки платежных систем отображаются.", onlineRechargePage.getPaymentSystemIcons().size() > 0);
    }

    @After
    public void tearDown() {
        // Закрываем браузер
        if (driver != null) {
            driver.quit();
        }
    }
}
