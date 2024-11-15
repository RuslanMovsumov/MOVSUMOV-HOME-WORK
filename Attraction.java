class Attraction.java {
    private String name;
    private String workingTime;
    private double price;

    public Attraction(String name, String workingTime, double price) {
        this.name = name;
        this.workingTime = workingTime;
        this.price = price;
    }

    public String toString() {
        return name + " - Время работы: " + workingTime + ", Цена: " + price + " рублей";
    }
}
     
