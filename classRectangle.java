class Rectangle.java extends Shape {
   private double length;
   private double width;

   public Rectangle.java (double length, double width, String fillColor, String borderColor) {
      super(fillColor, borderColor);
      this.length = length;
      this.width = width;
   }

   @Override
   public double area() {
      return length  width;
   }

   @Override
   public double perimeter() {
      return 2  (length + width);
   }
}
