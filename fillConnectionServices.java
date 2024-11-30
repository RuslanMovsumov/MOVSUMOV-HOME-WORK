public void fillConnectionServices(String phoneNumber) {
    connectionServicesField.sendKeys("Услуги связи");
    phoneNumberField.sendKeys(phoneNumber);
    continueButton.click();
    
    // Проверяем корректность отображения суммы и других элементов
    assert driver.findElement(By.id("amount_display")).getText().equals("Ожидаемая сумма");
    assert phoneNumberField.getAttribute("value").equals(phoneNumber);
    assert cardNumberField.getAttribute("placeholder").equals("Введите номер карты");
    
    // Проверка наличия иконок платежных систем
    assert paymentSystemIcons.size() > 0;
}
