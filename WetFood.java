// Deklarasi class WetFood yang mewarisi (extends) class Food.
// implementasi dari konsep Inheritance.
// WetFood bertindak sebagai subclass, sedangkan Food adalah superclass.
public class WetFood extends Food {
    
    public WetFood() {
        // ini mengeksekusi constructor milik superclass (Food)
        // dengan mengirimkan argumen spesifik ("Wet Food (Ikan bandeng)" sebagai name, 
        // Hal ini memungkinkan inisialisasi atribut parent tanpa harus mendeklarasikan
        super("Wet Food (Ikan bandeng)", 35);
    }
    // Mengimplementasikan nilai spesifik untuk WetFood
    @Override
    public int getHungerReduction() {
        return 35; // Mengurangi lapar sedikit
    }

    @Override
    public int getHappinessBoost() {
        return 10; // Memberikan kebahagiaan tinggi
    }
}   