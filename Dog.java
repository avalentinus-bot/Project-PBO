public class Dog extends Pet {
    public Dog(String name) {
        super(name);
    }

    // Method TAMBAHAN khusus Dog
    public void barkLoudly() {
        System.out.println(getName() + " menggonggong dengan keras: GUK GUK GUK!");
        setEnergy(getEnergy() - 5);
    }

    @Override
    public void timePasses() {
        setHunger(getHunger() + 10);
        setHappiness(getHappiness() - 15); // Butuh perhatian, happiness cepat turun
        setEnergy(getEnergy() - 5);
        
        if (getHunger() >= 90) {
            setHealth(getHealth() - 10);
            System.out.println("⚠️ " + getName() + " melolong kelaparan! Health menurun!");
        }
    }
}