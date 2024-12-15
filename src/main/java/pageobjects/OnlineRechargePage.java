package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class OnlineRechargePage extends BasePage {

    private By blockTitle = By.xpath("//h2[contains(text(), 'Онлайн пополнение')]");
    private By paymentSystemLogos = By.cssSelector(".payment-logos img");
    private By moreInfoLink = By.linkText("Подробнее о сервисе");
    private By serviceTypeSelect = By.id("serviceType");
    private By phoneNumberField = By.id("phoneNumber");
    private By continueButton = By.id("continue");
    private By resultMessage = By.id("resultMessage");
    private By fieldErrorMessages = By.cssSelector(".error-message");

    public OnlineRechargePage(WebDriver driver) {
        super(driver);
    }

    @Step("Получение заголовка блока")
    public String getBlockTitle() {
        return driver.findElement(blockTitle).getText();
    }

    @Step("Получение логотипов платежных систем")
    public List<String> getPaymentSystemLogos() {
        List<WebElement> logos = driver.findElements(paymentSystemLogos);
        List<String> altTexts = new ArrayList<>();
        for (WebElement element : logos) {
            altTexts.add(element.getAttribute("alt"));
        }
        return altTexts;
    }

    @Step("Клик на ссылку 'Подробнее о сервисе'")
    public void clickMoreInfoLink() {
        driver.findElement(moreInfoLink).click();
    }

    @Step("Выбор типа услуги: {serviceType}")
    public void selectServiceType(String serviceType) {
        driver.findElement(serviceTypeSelect).click();
        driver.findElement(By.xpath("//option[text()='" + serviceType + "']")).click();
    }

    @Step("Ввод номера телефона: {phoneNumber}")
    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    @Step("Клик на кнопку 'Продолжить'")
    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    @Step("Проверка отображения сообщения результата")
    public boolean isResultMessageDisplayed() {
        return driver.findElement(resultMessage).isDisplayed();
    }

    @Step("Получение сообщений об ошибках полей")
    public List<String> getFieldErrors() {
        List<WebElement> errors = driver.findElements(fieldErrorMessages);
        List<String> errorMessages = new ArrayList<>();
        for (WebElement error : errors) {
            errorMessages.add(error.getText());
        }
        return errorMessages;
    }

    @Step("Проверка корректного отображения после нажатия 'Продолжить' для суммы {expectedAmount} и номера {expectedPhoneNumber}")
    public boolean isCorrectDisplayAfterContinue(String expectedAmount, String expectedPhoneNumber) {
        String displayedAmount = driver.findElement(By.id("displayedAmount")).getText();
        String displayedPhoneNumber = driver.findElement(By.id("displayedPhoneNumber")).getText();
        return displayedAmount.equals(expectedAmount) && displayedPhoneNumber.equals(expectedPhoneNumber);
    }
}
