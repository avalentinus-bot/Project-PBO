public class Cat extends Pet {
    // Constructor Chaining
    public Cat(String name) {
        super(name);
    }

    // Method TAMBAHAN khusus Cat (Memenuhi rubrik penilaian)
    public void purr() {
        System.out.println(getName() + " mendengkur kebahagiaan: Purrrrrr...");
        setHappiness(getHappiness() + 5);
    }

    // Mengakomodasi fitur "Suka Ikan"
    @Override
    public void feed(Food food) {
        super.feed(food); // Panggil cara makan standar dari parent
        
        // Jika makanannya mengandung kata "Fish" atau "Ikan"
        if (food.getName().toLowerCase().contains("ikan") || food.getName().toLowerCase().contains("fish")) {
            System.out.println("😻 " + getName() + " sangat senang karena diberi ikan!");
            setHappiness(getHappiness() + 10); // Bonus happiness karena suka ikan
        }
    }

    @Override
    public void timePasses() {
        setHunger(getHunger() + 10);
        setHappiness(getHappiness() - 5);
        setEnergy(getEnergy() - 2); // Energy turun lambat
        
        if (getHunger() >= 90) {
            setHealth(getHealth() - 10);
            System.out.println("⚠️ " + getName() + " mengeong kelaparan! Health menurun!");
        }
    }
}