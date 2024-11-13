class Dog extends Animal {
    private static final int MAX_RUN_DISTANCE = 500; // Максимальная дистанция бега для собаки
    private static final int MAX_SWIM_DISTANCE = 10; // Максимальная дистанция плавания для собаки

    public Dog(String name) {
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
        if (distance <= MAX_SWIM_DISTANCE) {
            super.swim(distance);
        } else {
            System.out.println(name + " не может проплыть более " + MAX_SWIM_DISTANCE + " м.");
        }
    }
