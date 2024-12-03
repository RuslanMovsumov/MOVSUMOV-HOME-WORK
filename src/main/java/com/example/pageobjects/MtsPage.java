import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class MtsPage {
    private WebDriver driver;

    @FindBy(id = "services_field")
    private WebElement connectionServicesField;

    @FindBy(id = "home_internet_field")
    private WebElement homeInternetField;

    @FindBy(id = "installment_field")
    private WebElement installmentField;

    @FindBy(id = "debt_field")
    private WebElement debtField;

    @FindBy(id = "continue_button")
    private WebElement continueButton;

    @FindBy(id = "phone_number_field")
    private WebElement phoneNumberField;

    @FindBy(id = "card_number_field")
    private WebElement cardNumberField;

    @FindBy(className = "payment_system_icon")
    private List<WebElement> paymentSystemIcons;

    public MtsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkEmptyFieldLabels() {
        assert connectionServicesField.getAttribute("placeholder").equals("Введите услуги связи");
        assert homeInternetField.getAttribute("placeholder").equals("Введите домашний интернет");
        assert installmentField.getAttribute("placeholder").equals("Введите рассрочку");
        assert debtField.getAttribute("placeholder").equals("Введите задолженность");
    }

    public void fillConnectionServices(String phoneNumber) {
        connectionServicesField.sendKeys("Услуги связи");
        phoneNumberField.sendKeys(phoneNumber);
        continueButton.click();
    }

    public void verifyDetailsAfterContinue(String expectedAmount, String expectedPhoneNumber) {
        assert driver.findElement(By.id("amount_display")).getText().equals(expectedAmount);
        assert phoneNumberField.getAttribute("value").equals(expectedPhoneNumber);
        assert cardNumberField.getAttribute("placeholder").equals("Введите номер карты");
        assert paymentSystemIcons.size() > 0;
    }
}
