public class Main {
  public static void main(String[] args) {
        String[][] validArray = {
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
        };

        String[][] invalidArraySize = {
            {"1", "2"},
            {"3", "4"}
        };

        String[][] invalidArrayData = {
            {"1", "2", "3", "a"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
        };

       // Проверка валидного массива
        try {
            System.out.println("Сумма элементов: " + sumArray(validArray));
       } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }

      // Проверка массива с некорректным размером
        try {
            System.out.println("Сумма элементов (некорректный размер): " + calculateArraySum(invalidArraySize));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }

        // Проверка массива с некорректными данными
        try {
            System.out.println("Сумма элементов (некорректные данные): " + calculateArraySum(invalidArrayData));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }
    }
