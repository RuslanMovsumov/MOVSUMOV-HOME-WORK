abstract class Animal.java {
    String name;
    // Статическая переменная для подсчета объектов
    static int count = 0;

    public Animal(String name) {
        this.name = name;
        count++; // Увеличиваем счетчик при создании нового объекта
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }

    // Метод для получения общего количества животных
    public static int getCount() {
        return count;
    }
}
