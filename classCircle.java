
class Circle.java extends Shape {
   private double radius;

   public Circle.java (double radius, String fillColor, String borderColor) {
      super(fillColor, borderColor);
      this.radius = radius;
   }

   @Override
   public double area() {
      return Math.PI  radius  radius;
   }

   @Override
   public double perimeter() {
      return 2  Math.PI  radius;
   }
}
