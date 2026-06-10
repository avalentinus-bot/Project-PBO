public abstract class Pet {
    // 1. Deklarasi Atribut (Encapsulation)
    private String name;
    private int hunger;
    private int happiness;
    private int energy;
    private int health;
    
    // --- TAMBAHAN BARU: Variabel untuk menyimpan waktu dunia nyata ---
    private long lastTimeChecked; 

    // 2. Constructor
    public Pet(String name) {
        this.name = name;
        this.hunger = 80;
        this.happiness = 80;
        this.energy = 50;
        this.health = 100;
        
        // --- TAMBAHAN BARU: Catat waktu (dalam milidetik) saat peliharaan dibuat ---
        this.lastTimeChecked = System.currentTimeMillis(); 
    }

    // 3. Accessor (Getter) - (TETAP SAMA)
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getHunger() { return hunger; }
    public int getHappiness() { return happiness; }
    public int getEnergy() { return energy; }

    // 4. Mutator (Setter) - (TETAP SAMA)
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

    // 5. Method Operasional
    public void feed(Food food) { 
        setHunger(this.hunger - food.getHungerReduction());
        setHappiness(this.happiness + food.getHappinessBoost());
        System.out.println(name + " makan " + food.getName() + ".");
        // timePasses(); <-- DIHAPUS: Karena waktu sekarang berjalan otomatis, bukan karena aksi
    }

    public void sleep() {
        setEnergy(this.energy + 80);
        System.out.println(name + " sedang tidur nyenyak...");
        // timePasses(); <-- DIHAPUS
    }

    // --- REFACTORING MILESTONE 5: Abstract Methods ---
    public abstract void play();
    public abstract void makeSound();
    public abstract String getSpecies();

    // --- SISTEM WAKTU (DELTA TIME) ---
    // Method ini mengecek selisih waktu realtime.
    public void updateRealTime() {
        long currentTime = System.currentTimeMillis();
        // Menghitung selisih waktu dalam satuan detik
        long elapsedTimeInSeconds = (currentTime - lastTimeChecked) / 1000;

        // KONFIGURASI: 1 siklus waktu di game = setiap 60 detik di dunia nyata.
        // (Kamu bisa ganti angka 60 ini jadi 30 atau 120 kalau mau lebih lama).
        long cycles = elapsedTimeInSeconds / 60;

        if (cycles > 0) {
            // Melakukan looping sebanyak siklus waktu yang terlewat
            for (int i = 0; i < cycles; i++) {
                timePasses(); // Memanggil method timePasses() yang di-override oleh tiap hewan
            }
            // Update waktu terakhir agar tidak dobel kalkulasi
            lastTimeChecked = currentTime; 
            System.out.println("\n [" + cycles + " siklus waktu nyata telah berlalu...]");
        }
    }

    // 6. State Management
    public void timePasses() {
        setHunger(this.hunger + 10);
        setHappiness(this.happiness - 5);
        setEnergy(this.energy - 5);

        if (this.hunger >= 90) {
            setHealth(this.health - 10);
            System.out.println("⚠️ PERINGATAN: " + name + " kelaparan! Health menurun!");
        }
    }

    // 7. Visualisasi CLI
    public void showStatus() {
        // Memanggil abstract method getSpecies() agar outputnya menjadi [Dog] Nama, [Cat] Nama
        System.out.println("\n[" + getSpecies() + "] " + name);
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