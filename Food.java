// --- REFACTORING MILESTONE 5: Mengubah class menjadi abstract ---
// Sekarang Food tidak bisa di-instantiate langsung (tidak bisa: new Food())
public abstract class Food {
    // Atribut private (Konsep Encapsulation)
    // class lain seperti main/pet tidak bisa mengakses
    private String name; //menyimpan teks nama makanan
    private int nutritionValue; //menyimpan seberapa mengenyangkan makanan ini(nilai gizi)

    // Constructor
    // untuk memanggil ketika menambahkan makanan baru di main.java
    public Food(String name, int nutritionValue) {
        this.name = name;
        this.nutritionValue = nutritionValue;
    }
    // methode mengizinkan class lain melihat isi variabel 'name'
    public String getName() { 
        return name; 
    }
    // methode mengizinkan class lain melihat isi variabel 'nutritionValue'
    public int getNutritionValue() { 
        return nutritionValue; 
    }

    // --- REFACTORING MILESTONE 5: Abstract Methods ---
    // Menambahkan kontrak wajib bagi seluruh subclass makanan (DryFood, WetFood, Treat).
    // Method ini tidak memiliki body {} karena nilainya akan ditentukan oleh subclass masing-masing.
    public abstract int getHungerReduction();
    public abstract int getHappinessBoost();
}