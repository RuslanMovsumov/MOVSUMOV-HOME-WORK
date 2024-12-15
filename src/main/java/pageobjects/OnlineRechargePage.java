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
  private By serviceFieldErrors = By.cssSelector(".error-message");
  private By paymentAmount = By.id("paymentAmount");
  private By phoneNumberDisplay = By.id("displayedPhoneNumber");
  private By cardFields = By.cssSelector(".card-fields");
  private By paymentSystemIcons = By.cssSelector(".payment-icons"); 
  
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

  public List<String> getFieldErrors() {
    List<WebElement> errorMessages = driver.findElements(serviceFieldErrors);
    List<String> errorTexts = new ArrayList<>();
    for (WebElement error : errorMessages) {
        errorTexts.add(error.getText());
    }
    return errorTexts;
}

  public void fillConnectionServices(String phoneNumber) {
    selectServiceType("Услуги связи");
    enterPhoneNumber(phoneNumber);
    clickContinueButton();
} 

  public boolean isCorrectDisplayAfterContinue(String expectedAmount, String expectedPhoneNumber) {
    String actualAmount = driver.findElement(paymentAmount).getText();
    String actualPhoneNumber = driver.findElement(phoneNumberDisplay).getText();
    
    boolean isAmountCorrect = actualAmount.equals(expectedAmount);
    boolean isPhoneNumberCorrect = actualPhoneNumber.equals(expectedPhoneNumber);
    
    boolean areCardFieldsDisplayed = driver.findElements(cardFields).size() > 0;
    boolean arePaymentIconsPresent = driver.findElements(paymentSystemIcons).size() > 0;

    return isAmountCorrect && isPhoneNumberCorrect && areCardFieldsDisplayed && arePaymentIconsPresent;
  } 
}  















