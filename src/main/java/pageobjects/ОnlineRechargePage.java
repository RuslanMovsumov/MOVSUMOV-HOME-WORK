package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OnlineRechargePage extends BasePage {

    // Locators
    private By blockTitle = By.xpath("//h2[contains(text(), 'Онлайн пополнение без комиссии')]");
    private By paymentSystemLogos = By.cssSelector(".payment-systems img");
    private By moreInfoLink = By.linkText("Подробнее о сервисе");
    private By serviceTypeSelect = By.id("serviceType");
    private By phoneNumberField = By.id("phoneNumber");
    private By continueButton = By.id("continueButton");
    private By resultMessage = By.id("resultMessage");

    public OnlineRechargePage(WebDriver driver) {
        super(driver);
    }

    public String getBlockTitle() {
        return driver.findElement(blockTitle).getText();
    }

    public boolean arePaymentSystemLogosPresent() {
        List<WebElement> logos = driver.findElements(paymentSystemLogos);
        return !logos.isEmpty();
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
}
     
