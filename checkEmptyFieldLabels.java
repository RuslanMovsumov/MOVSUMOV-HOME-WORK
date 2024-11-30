public void checkEmptyFieldLabels() {
    assert connectionServicesField.getAttribute("placeholder").equals("Введите услуги связи");
    assert homeInternetField.getAttribute("placeholder").equals("Введите домашний интернет");
    assert installmentField.getAttribute("placeholder").equals("Введите рассрочку");
    assert debtField.getAttribute("placeholder").equals("Введите задолженность");
}
