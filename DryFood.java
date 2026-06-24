// extends berarti DryFood mewarisi semua sifat dari Food
public class DryFood extends Food {
    public DryFood() {
        // super() memanggil constructor milik parent class (Food)
        super("Dry Food (Makanan Kering)", 25);
    }
    @Override
    public int getHungerReduction() {
        return 30;
    }

    @Override
    public int getHappinessBoost() {
        return 10;
    }
}