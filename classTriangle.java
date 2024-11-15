class Triangle.java extends Shape {
   private double a;
   private double b;
   private double c;

   public Triangle.java (double a, double b, double c, String fillColor, String borderColor) {
      super(fillColor, borderColor);
      this.a = a;
      this.b = b;
      this.c = c;
   }

   @Override
   public double area() {
      double s = (a + b + c) / 2; // Полупериметр
      return Math.sqrt(s  (s - a)  (s - b) * (s - c)); // Формула Герона
   }

   @Override
   public double perimeter() {
      return a + b + c;
   }
}
