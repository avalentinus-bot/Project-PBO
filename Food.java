public class Food {
    // Atribut private (Konsep Encapsulation)
    //class lain seperti main/pet tidak bisa mengakses
    private String name; //menyimpan teks nama makanan
    private int nutritionValue; //menyimpan seberapa mengenyangkan makanan ini(nilai gizi)

    // Constructor
    // untuk memanggil ketika menambahkan makanan baru di main.java
    public Food(String name, int nutritionValue) {
        this.name = name;
        this.nutritionValue = nutritionValue;
    }
    // methode ini mengizinkan class lain melihat isi variabel 'name'
    public String getName() { 
        return name; 
    }
   // methode ini mengizinkan class lain melihat isi variabel 'nutritionValue'
    public int getNutritionValue() { 
        return nutritionValue; 
    }
}