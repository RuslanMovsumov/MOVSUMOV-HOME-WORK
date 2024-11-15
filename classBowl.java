class Bowl.java {
    private int food;

    public Bowl(int food) {
        this.food = Math.max(food, 0); // Если количество еды меньше 0, устанавливаем 0
    }

    public int getFoodAmount() {
        return food;
    }

    public void decreaseFood(int amount) {
        food = Math.max(food - amount, 0); // Уменьшаем, не позволяя количеству еды стать отрицательным
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount; // Добавляем еду, если количество положительное
        }
    }
