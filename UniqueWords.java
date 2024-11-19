import java.util.*;

public class UniqueWords {
    public static void main(String[] args) {
        String[] words = {
        "яблоко", "банан", "груша", "апельсин", "банан",
        "яблоко", "груша", "виноград", "апельсин", "банан",
        "груша", "груша", "яблоко", "папайя", "апельсин"
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
