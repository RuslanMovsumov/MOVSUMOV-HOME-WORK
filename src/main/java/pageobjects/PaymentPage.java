package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends BasePage {

    private By paymentSuccessMessage = By.id("paymentSuccessMessage");
    private By paymentErrorMessage = By.id("paymentErrorMessage");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPaymentSuccessMessageDisplayed() {
        return isElementDisplayed(paymentSuccessMessage);
    }

    public boolean isPaymentErrorMessageDisplayed() {
        return isElementDisplayed(paymentErrorMessage);
    }

    private boolean isElementDisplayed(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
