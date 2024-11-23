public class FactorialCalculator {
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Число должно быть неотрицательным");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        // Пример использования
        System.out.println("Факториал 5: " + factorial(5)); // Должно вывести 120
    }
}
