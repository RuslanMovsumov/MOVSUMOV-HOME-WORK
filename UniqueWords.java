import java.util.*;

public class UniqueWords {
    public static void main(String[] args) {
        String[] words = {
        "банан", "яблоко", "виноград", "апельсин", "банан",
        "яблоко", "гранат", "виноград", "апельсин", "банан",
        "груша", "груша", "яблоко", "гранат", "апельсин"
        };

        // Получаем список новых уникальных слов 
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        // Подсчитываем количество вхождений каждого слова
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Уникальные слова: " + uniqueWords);
        System.out.println("Количество вхождений слов:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
