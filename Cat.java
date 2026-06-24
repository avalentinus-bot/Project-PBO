// Mendeklarasikan class Cat sebagai turunan (subclass) dari Pet.
// Ini mendefinisikan relasi hierarkis IS-A (Cat is a Pet).
public class Cat extends Pet {
    
    // Constructor
    public Cat(String name) {
        // Constructor Chaining: Mendelegasikan inisialisasi atribut 'name' ke superclass.
        super(name);
    }

    // Subclass-specific method
    // Memenuhi persyaratan Milestone 3 untuk memberikan behavior unik pada setiap subclass.
    public void purr() {
        System.out.println(getName() + " mendengkur kebahagiaan: Purrrrrr...");
        // Memanfaatkan setter dari superclass untuk memanipulasi state secara aman.
        setHappiness(getHappiness() + 5);
    }

    // Method Overriding (Ekstensi Behavior)
    // Menimpa method feed() milik superclass untuk mengakomodasi fitur khusus (suka ikan).
    @Override
    public void feed(Food food) {
        // Keyword 'super' digunakan untuk memanggil implementasi method feed() milik parent class terlebih dahulu.
        // Ini memastikan proses standar (pengurangan hunger dan eksekusi timePasses) tetap berjalan 
        // tanpa harus menulis ulang kodenya (Code Reusability).
        super.feed(food); 
        
        // Logika tambahan (Subclass-specific logic) yang hanya dieksekusi oleh objek Cat.
        // Melakukan string matching pada nama makanan untuk mendeteksi varian ikan.
        if (food.getName().toLowerCase().contains("ikan") || food.getName().toLowerCase().contains("fish")) {
            System.out.println("^. .^ " + getName() + " sangat senang karena diberi ikan!");
            setHappiness(getHappiness() + 10); 
        }
    }

    // Method Overriding (Modifikasi Behavior)
    // Menimpa implementasi timePasses() secara penuh untuk mengubah parameter mutasi state.
    @Override
    public void timePasses() {
        setHunger(getHunger() + 10);
        setHappiness(getHappiness() - 5);
        // Modifikasi parameter: Cat kehilangan energi lebih lambat (-2) dibandingkan Pet default (-5).
        setEnergy(getEnergy() - 2);

        // Pengecekan kondisi kritis menggunakan getter untuk mematuhi prinsip encapsulation.
        if (getHunger() >= 90) {
            setHealth(getHealth() - 10);
            System.out.println("⚠️ " + getName() + " mengeong kelaparan! Health menurun!");
        }
    }
    
    // abstract method makeSound()
    @Override
    public void makeSound() {
        System.out.println("Meow! " + getName() + " meminta perhatian.");
        setHappiness(getHappiness() + 5);
    }

    // abstract method play()
    @Override
    public void play() {
        System.out.println(getName() + " bermain dengan bola benang!");
        setHappiness(getHappiness() + 15);
        setEnergy(getEnergy() - 10);
    }

    // abstract method getSpecies()
    @Override
    public String getSpecies() {
        return "Cat";
    }
}