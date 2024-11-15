class Cat extends Animal {
    private static final int MAX_RUN_DISTANCE = 200; // Максимальная дистанция бега для кота
    private static final int MAX_SWIM_DISTANCE = 0; // Кот не умеет плавать
    private boolean isFull = false;

    public Cat(String name) {
        super(name);
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            super.run(distance);
        } else {
            System.out.println(name + " не может пробежать более " + MAX_RUN_DISTANCE + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public boolean eat(Bowl bowl) {
        if (bowl.getFoodAmount() > 0) {
            bowl.decreaseFood(1); // Уменьшаем количество еды в миске
            isFull = true; // Кот сыт
            return true; // Успешно поел
        } else {
            System.out.println(name + " не может поесть, миска пуста.");
            return false; // Не удалось поесть
        }
    }

    public boolean isFull() {
        return isFull;
    }
} 
