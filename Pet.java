public class Pet {
    // 1. Deklarasi Atribut (Encapsulation)
    // Sesuai dengan spesifikasi Milestone 2, semua atribut diatur menggunakan access modifier 'private'.
    // Ini mencegah modifikasi data secara langsung dari luar class untuk menjaga integritas status hewan.
    private String name;
    private int hunger;
    private int happiness;
    private int energy;
    private int health;

    // 2. Constructor
    // Method khusus yang otomatis dieksekusi saat proses instansiasi object baru.
    // Berfungsi untuk memberikan nilai awal (default state) pada atribut.
    public Pet(String name) {
        this.name = name;
        this.hunger = 80;
        this.happiness = 80;
        this.energy = 50;
        this.health = 100;
    }

    // 3. Accessor (Getter)
    // Mengembalikan nilai dari atribut private agar bisa dibaca oleh class lain (seperti Main).
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getHunger() { return hunger; }
    public int getHappiness() { return happiness; }
    public int getEnergy() { return energy; }

    // 4. Mutator (Setter) dengan Validasi Data
    // Mengatur nilai atribut dengan menerapkan rule validasi.
    // Memastikan parameter input tidak membuat nilai atribut keluar dari batas 0 hingga 100.
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
    // Menerima object bertipe 'Food' sebagai parameter.
    public void feed(Food food) { 
        // Mengubah state hunger dengan mengurangi nilai nutritionValue dari object food.
        setHunger(this.hunger - food.getNutritionValue());
        
        // Logika kondisional: memberikan bonus happiness jika string nama makanan mengandung "treat"
        if (food.getName().toLowerCase().contains("treat")) {
            setHappiness(this.happiness + 15); 
            System.out.println(name + " sangat kegirangan memakan camilan!");
        } else {
            System.out.println(name + " makan " + food.getName() + ".");
        }
        timePasses(); // Memicu transisi state
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

    // 6. State Management
    // Method ini mengelola penalti status seiring berjalannya aksi.
    public void timePasses() {
        // Menggunakan setter untuk menjamin nilai hasil kalkulasi tetap tervalidasi
        setHunger(this.hunger + 10);
        setHappiness(this.happiness - 5);
        setEnergy(this.energy - 5);

        // Pengurangan health jika hunger mencapai batas kritis (>= 90)
        if (this.hunger >= 90) {
            setHealth(this.health - 10);
            System.out.println("⚠️ PERINGATAN: " + name + " kelaparan! Health menurun!");
        }
    }

    // 7. Visualisasi CLI
    public void showStatus() {
        System.out.println("\n[" + name + "]");
        printBar("Hunger   ", hunger);
        printBar("Happiness", happiness);
        printBar("Energy   ", energy);
        printBar("Health   ", health);
    }

    // Method helper dengan access modifier private.
    // Hanya digunakan secara internal oleh method showStatus() di dalam class ini.
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