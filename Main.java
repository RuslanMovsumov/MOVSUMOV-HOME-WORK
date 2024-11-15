// Основной класс для тестирования
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Барбос");
        Cat cat1 = new Cat("Матильда");
        Cat cat2 = new Cat("Васька");

        dog.run(300);
        dog.swim(5);
        dog.swim(15); // Не может

        cat1.run(150);
        cat1.swim(10); // Не умеет плавать

        Bowl bowl = new Bowl(2); // 2 порции еды для котов
        cat1.eat(bowl); // Успех
        cat2.eat(bowl); // Успех
        cat1.eat(bowl); // Миска пуста

        System.out.println(cat1.name + " сытость: " + cat1.isFull());
        System.out.println(cat2.name + " сытость: " + cat2.isFull());

        // Вывод количества животных
        System.out.println("Общее количество животных: " + Animal.getCount());
        
        // Добавляем еду в миску
        bowl.addFood(5); // Добавили еду в миску
        cat2.eat(bowl); // Теперь коту есть чем покушать
        System.out.println(cat2.name + " сытость: " + cat2.isFull());
    }
}
