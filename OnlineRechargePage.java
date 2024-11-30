import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnlineRechargePage {
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

    public OnlineRechargePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    // Другие методы
}
