// extends berarti DryFood mewarisi semua sifat dari Food
public class DryFood extends Food {
    public DryFood() {
        // super() memanggil constructor milik parent class (Food)
        super("Dry Food (Makanan Kering)", 25);
    }
    // Mengimplementasikan nilai spesifik untuk DryFood
    @Override
    public int getHungerReduction() {
        return 30; // Mengurangi lapar sedikit
    }

    @Override
    public int getHappinessBoost() {
        return 10; // Memberikan kebahagiaan tinggi
    }
}