public class Food {
    // Atribut private (Konsep Encapsulation)
    private String name;
    private int nutritionValue;

    // Constructor
    public Food(String name, int nutritionValue) {
        this.name = name;
        this.nutritionValue = nutritionValue;
    }

    // Getter untuk mengambil nilai secara aman
    public String getName() { 
        return name; 
    }
    
    public int getNutritionValue() { 
        return nutritionValue; 
    }
}