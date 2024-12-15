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
  private By serviceTypeDropdown = By.id("serviceType"); 
  private By phoneNumberInput = By.id("phoneNumber"); 
  private By continueButton = By.id("continue"); 
  private By fieldErrorMessages = By.cssSelector(".error-message"); 
  private By paymentSystemLogos = By.cssSelector(".payment-logos img");
  
  public OnlineRechargePage(WebDriver driver) {
        super(driver);
    }

    public String getBlockTitle() {
        return driver.findElement(blockTitle).getText();
    }

    public List arePaymentSystemLogosPresent() {
        List<WebElement> logos = driver.findElements(paymentSystemLogos);
        List<String> altsLogo = new ArrayList<>();
        for (WebElement element : logos) {
            altsLogo.add(element.getAttribute("alt"));
        }
    return altsLogo;
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

   public void selectServiceType(String serviceType) {
        driver.findElement(serviceTypeDropdown).sendKeys(serviceType); 
    }

    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public List<String> getFieldErrors() {
        List<WebElement> errors = driver.findElements(fieldErrorMessages);
        List<String> errorMessages = new ArrayList<>();
        for (WebElement error : errors) {
            errorMessages.add(error.getText());
        }
        return errorMessages;
    }

    public boolean isCorrectDisplayAfterContinue(String expectedAmount, String expectedPhoneNumber) {
        // Проверка отображения суммы и номера телефона
        String displayedAmount = driver.findElement(By.id("displayedAmount")).getText(); 
        String displayedPhoneNumber = driver.findElement(By.id("displayedPhoneNumber")).getText(); 
        return displayedAmount.equals(expectedAmount) && displayedPhoneNumber.equals(expectedPhoneNumber);
    }

    public List<String> arePaymentSystemLogosPresent() {
        List<WebElement> logos = driver.findElements(paymentSystemLogos);
        List<String> logoNames = new ArrayList<>();
        for (WebElement logo : logos) {
            logoNames.add(logo.getAttribute("alt")); 
        }
        return logoNames;
    }
}
  

















