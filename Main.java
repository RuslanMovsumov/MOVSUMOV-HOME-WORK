public class Main {

    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] invalidSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"}
        };

        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "A", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = processArray(validArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            processArray(invalidSizeArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            processArray(invalidDataArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
            if (e instanceof MyArrayDataException) {
                MyArrayDataException dataException = (MyArrayDataException) e;
                System.out.println("Ошибка в ячейке: " + dataException.getRow() + ", " + dataException.getCol());
            }
        }
    
