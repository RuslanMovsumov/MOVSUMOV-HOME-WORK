// Интерфейс для расчетов
interface Measurable {
   double area();
   double perimeter();
}

// Родительский класс Shape
abstract class Shape implements Measurable {
   protected String fillColor;
   protected String borderColor;

   public Shape(String fillColor, String borderColor) {
      this.fillColor = fillColor;
      this.borderColor = borderColor;
   }

   public void printProperties() {
      System.out.printf("Цвет заливки: %s, Цвет границы: %s%n", fillColor, borderColor);
   }
}
