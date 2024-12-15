package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {

    private By paymentSuccessMessage = By.id("paymentSuccessMessage");
    private By paymentErrorMessage = By.id("paymentErrorMessage");
    
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPaymentSuccessMessageDisplayed() {
        return driver.findElement(paymentSuccessMessage).isDisplayed();
    }

    public boolean isPaymentErrorMessageDisplayed() {
        return driver.findElement(paymentErrorMessage).isDisplayed();
    }
}
