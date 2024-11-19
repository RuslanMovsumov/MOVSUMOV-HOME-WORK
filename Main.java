public static void main(String[] args) {
        
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Мовсумов", "123-456");
        phoneBook.add("Дмитриенко", "789-012");
        phoneBook.add("Коваленок", "345-678");
        phoneBook.add("Смирнов", "234-567");

        // Поиск номеров телефонов
        System.out.println("Номера телефонов Мовсумова: " + phoneBook.get("Мовсумов"));
        System.out.println("Номера телефонов Коваленка: " + phoneBook.get("Коваленок"));
        System.out.println("Номера телефонов Дмитриенко: " + phoneBook.get("Дмитриенко"));
        System.out.println("Номера телефонов Смирнова: " + phoneBook.get("Смирнов")); // Фамилия отсутствует
    }
}
