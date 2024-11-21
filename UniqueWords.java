import java.util.HashMap;
import java.util.Map;

public class UniqueWords {
    public static void main(String[] args) {
        String[] words = {
            "банан", "яблоко", "груша", "яблоко", "виноград", 
            "груша", "персик", "банан", "гранат", "вишня", 
            "апельсин", "виноград", "груша", "яблоко", "груша"
        };

        // Используем HashMap для подсчета частоты слов
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Выводим уникальные слова и их частоту
        System.out.println("Уникальные слова и их частота:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
