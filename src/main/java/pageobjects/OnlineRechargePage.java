package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class OnlineRechargePage extends BasePage {

  
    private By blockTitle = By.xpath("//h2[contains(text(), 'Онлайн пополнение')]");
    private By paymentSystemLogos = By.cssSelector(".pay__partners img");
    private By moreInfoLink = By.linkText("Подробнее о сервисе");
    private By serviceTypeSelect = By.id("serviceType");
    private By phoneNumberField = By.id("phoneNumber");
    private By continueButton = By.xpath("//button[contains(text(), 'Продолжить')]");
    private By resultMessage = By.id("resultMessage");

    // Поля для реквизитов карты
    private By cardNumberField = By.id("cardNumber");
    private By cardExpiryField = By.id("cardExpiry");
    private By cardCvcField = By.id("cardCvc");
    public OnlineRechargePage(WebDriver driver) {
        super(driver);
    }

    public String getBlockTitle() {
        return driver.findElement(blockTitle).getText();
    }

    public List<String> getPaymentSystemLogos() {
        List<WebElement> logos = driver.findElements(paymentSystemLogos);
        List<String> altTexts = new ArrayList<>();
        for (WebElement element : logos) {
            altTexts.add(element.getAttribute("alt"));
        }
        return altTexts;
    }

    public void clickMoreInfoLink() {
        driver.findElement(moreInfoLink).click();
    }

    public void selectServiceType(String serviceType) {
        driver.findElement(serviceTypeSelect).click();
        driver.findElement(By.xpath("//option[text()='" + serviceType + "']")).click();
    }

    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public boolean isResultMessageDisplayed() {
        return driver.findElement(resultMessage).isDisplayed();
    }
 
    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public boolean isFieldErrorDisplayed(String fieldName) {
        List<WebElement> errorMessages = driver.findElements(fieldErrorMessages);
        for (WebElement error : errorMessages) {
            if (error.getText().contains(fieldName)) {
                return true;
            }
        }
        return false;
    }

    public String getDisplayedAmount() {
        return driver.findElement(By.id("displayedAmount")).getText();
    }

    public String getDisplayedPhoneNumber() {
        return driver.findElement(By.id("displayedPhoneNumber")).getText();
    }

    public List<String> getPaymentSystemLogosAltTexts() {
        List<WebElement> logos = driver.findElements(paymentSystemLogos);
        List<String> altTexts = new ArrayList<>();
        for (WebElement element : logos) {
            altTexts.add(element.getAttribute("alt"));
        }
        return altTexts;
    }
}
   

   
  














