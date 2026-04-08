public class Pet {
    // 1. Atribut Private (Encapsulation Milestone 2)
    private String name;
    private int hunger;
    private int happiness;
    private int energy;
    private int health;

    // 2. Constructor (Milestone 1)
    public Pet(String name) {
        this.name = name;
        this.hunger = 80;
        this.happiness = 80;
        this.energy = 50;
        this.health = 100;
    }

    // 3. Getter & Setter dengan Validasi (Milestone 2)
    public String getName() { return name; }
    public int getHealth() { return health; }

    public void setHunger(int hunger) {
        if (hunger < 0) this.hunger = 0;
        else if (hunger > 100) this.hunger = 100;
        else this.hunger = hunger;
    }

    public void setHappiness(int happiness) {
        if (happiness < 0) this.happiness = 0;
        else if (happiness > 100) this.happiness = 100;
        else this.happiness = happiness;
    }

    public void setEnergy(int energy) {
        if (energy < 0) this.energy = 0;
        else if (energy > 100) this.energy = 100;
        else this.energy = energy;
    }

    public void setHealth(int health) {
        if (health < 0) this.health = 0;
        else if (health > 100) this.health = 100;
        else this.health = health;
    }

    // 4. Method Operasional (Milestone 1 di-upgrade ke Milestone 2)
    public void feed(Food food) {
        // Mengurangi hunger berdasarkan nutritionValue makanan
        setHunger(this.hunger - food.getNutritionValue());
        System.out.println(name + " makan " + food.getName() + ".");
        timePasses();
    }

    public void play() {
        setHappiness(this.happiness + 20);
        setEnergy(this.energy - 10);
        System.out.println(name + " sedang bermain dan bersenang-senang...");
        timePasses();
    }

    public void sleep() {
        setEnergy(this.energy + 80);
        System.out.println(name + " sedang tidur nyenyak...");
        timePasses();
    }

    // 5. Method Waktu Berlalu (Milestone 2)
    public void timePasses() {
        setHunger(this.hunger + 10);
        setHappiness(this.happiness - 5);
        setEnergy(this.energy - 5);

        // Jika hunger >= 70, health berkurang
        if (this.hunger >= 70) {
            setHealth(this.health - 10);
            System.out.println("⚠️ PERINGATAN: " + name + " kelaparan! Health menurun!");
        }
    }

    // 6. Visual Status (Milestone 2)
    public void showStatus() {
        System.out.println("\n[" + name + "]");
        printBar("Hunger   ", hunger);
        printBar("Happiness", happiness);
        printBar("Energy   ", energy);
        printBar("Health   ", health);
    }

    private void printBar(String label, int value) {
        int dots = value / 10;
        System.out.print(label + ": " + String.format("%3d", value) + "/100 [");
        for(int i = 0; i < 10; i++) {
            if(i < dots) System.out.print("#");
            else System.out.print("-");
        }
        System.out.println("]");
    }
}