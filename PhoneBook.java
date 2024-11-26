import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    // Метод для добавления записи
    public void add(String surname, String phoneNumber) {
        phoneBook.putIfAbsent(surname, new ArrayList<>());
        phoneBook.get(surname).add(phoneNumber);
    }

    // Метод для поиска номера телефона по фамилии
    public List<String> get(String surname) {
        return phoneBook.getOrDefault(surname, new ArrayList<>());
    } 
   
    // Метод для вывода всех записей
    public void printAllEntries() {
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            System.out.println("Фамилия: " + entry.getKey() + ", Номера: " + entry.getValue());
        }
    }
    
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        
        // Добавляем записи
        phoneBook.add("Мовсумов", "123-45-67");
        phoneBook.add("Гордей", "89-00-00");
        phoneBook.add("Смирнов", "77-88-99");
        phoneBook.add("Толкачев", "11-22-33");

        // Поиск по фамилии
        System.out.println("Телефоны Мовсумова: " + phoneBook.get("Мовсумов"));
        System.out.println("Телефоны Гордея: " + phoneBook.get("Гордей"));
        System.out.println("Телефоны Смирнова: " + phoneBook.get("Смирнов"));
        System.out.println("Телефоны Толкачева: " + phoneBook.get("Толкачев")); // не существует
    
       // Печатаем все записи
        phoneBook.printAllEntries();
    }
}
