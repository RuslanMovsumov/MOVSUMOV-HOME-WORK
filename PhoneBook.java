import java.util.*;

class PhoneBook {
    private Map<String, List<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        contacts.putIfAbsent(surname, new ArrayList<>());
        contacts.get(surname).add(phoneNumber);
    }

    // Метод для получения списка номеров по фамилии
    public List<String> get(String surname) {
        // Возвращаем список номеров по фамилии или пустой список, если фамилия не найдена
        return contacts.getOrDefault(surname, Collections.emptyList());
    }

    
