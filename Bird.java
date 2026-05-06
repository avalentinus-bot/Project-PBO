public class Bird extends Pet {
    public Bird(String name) {
        super(name);
    }

    // Method TAMBAHAN khusus Bird
    public void sing() {
        System.out.println(getName() + " berkicau mania~");
        setHappiness(getHappiness() + 5);
    }

    @Override
    public void timePasses() {
        setHunger(getHunger() + 15); // Makan sedikit tapi sering (Cepat lapar)
        setHappiness(getHappiness() - 5);
        setEnergy(getEnergy() - 15); // Energy cepat habis
        
        if (getHunger() >= 90) {
            setHealth(getHealth() - 10);
            System.out.println("⚠️ " + getName() + " lemas kelaparan! Health menurun!");
        }
    }
}