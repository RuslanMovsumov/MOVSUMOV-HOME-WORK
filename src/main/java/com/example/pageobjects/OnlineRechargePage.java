package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OnlineRechargePage {
    private WebDriver driver;

    private By serviceTypeDropdown = By.id("service-type-dropdown");
    private By phoneNumberInput = By.id("phone-number-input");
    private By continueButton = By.id("continue-button");
    private By amountDisplay = By.id("amount-display");
    private By phoneDisplay = By.id("phone-display");
    private By cardNumberInput = By.id("card-number-input");
    private By cardExpiryInput = By.id("card-expiry-input");
    private By cardCvcInput = By.id("card-cvc-input");
    private By paymentSystemLogos = By.cssSelector(".payment-system-logo");
    
    private By emptyFieldPlaceholder = By.className("empty-field-placeholder");

    public OnlineRechargePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectServiceType(String serviceType) {
        // Логика выбора типа услуги
    }

    public void enterPhoneNumber(String phoneNumber) {
        // Логика ввода номера телефона
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public String getDisplayedAmount() {
        return driver.findElement(amountDisplay).getText();
    }

    public String getDisplayedPhone() {
        return driver.findElement(phoneDisplay).getText();
    }

    public String getEmptyFieldPlaceholder() {
        return driver.findElement(emptyFieldPlaceholder).getText();
    }

    public List<String> getPaymentSystemLogos() {
        List<String> logos = new ArrayList<>();
        // Получаем список логотипов
        driver.findElements(paymentSystemLogos).forEach(logo -> logos.add(logo.getAttribute("src")));
        return logos;
    }
}
