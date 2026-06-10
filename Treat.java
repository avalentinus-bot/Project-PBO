public class Treat extends Food {
    public Treat() {
        super("Treat (Camilan Spesial)", 20);
    }
    // Mengimplementasikan nilai spesifik untuk Treat
    @Override
    public int getHungerReduction() {
        return 20; // Mengurangi lapar sedikit
    }

    @Override
    public int getHappinessBoost() {
        return 20; // Memberikan kebahagiaan tinggi
    }
}