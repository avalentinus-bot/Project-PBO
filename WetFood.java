// Deklarasi class WetFood yang mewarisi (extends) class Food.
// Ini adalah implementasi dari konsep Inheritance pada Milestone 3.
// WetFood bertindak sebagai subclass (anak), sedangkan Food adalah superclass (induk).
public class WetFood extends Food {
    
    // Constructor tanpa parameter (No-argument constructor).
    // Saat object WetFood di-instantiate, constructor ini akan langsung dieksekusi.
    public WetFood() {
        // Constructor Chaining menggunakan keyword 'super()'.
        // Pemanggilan ini secara eksplisit mengeksekusi constructor milik superclass (Food)
        // dengan mengirimkan argumen spesifik ("Wet Food (Makanan Basah)" sebagai name, 
        // dan 35 sebagai nutritionValue).
        // Hal ini memungkinkan inisialisasi atribut parent tanpa harus mendeklarasikan
        // ulang variabel tersebut di dalam subclass.
        super("Wet Food (Ikan bandeng)", 35);
    }
}