// Mendeklarasikan class Dog yang mewarisi sifat dari class Pet.
// Ini adalah implementasi Inheritance, di mana Dog (subclass) memiliki 
// semua atribut dan method dari Pet (superclass).
public class Dog extends Pet {
    
    // Constructor untuk class Dog.
    public Dog(String name) {
        // Constructor Chaining: memanggil constructor milik parent class (Pet).
        // Delegasi ini diperlukan untuk menginisialisasi atribut private 'name' di superclass.
        super(name);
    }

    // Subclass-specific method (Method Tambahan).
    // Menambahkan behavior eksklusif yang hanya dimiliki oleh instansiasi objek Dog.
    public void barkLoudly() {
        System.out.println(getName() + " menggonggong dengan keras: GUK GUK GUK!");
        // Memanipulasi state menggunakan getter dan setter yang diwarisi dari superclass.
        setEnergy(getEnergy() - 5);
    }

    // Method Overriding: Menimpa implementasi method timePasses() dari superclass.
    @Override
    public void timePasses() {
        setHunger(getHunger() + 10);

        // Modifikasi parameter state: 
        // Implementasi spesifik Dog di mana atribut happiness mengalami 
        // penurunan yang lebih banyak (-15) dibandingkan Pet default.
        setHappiness(getHappiness() - 15);
        setEnergy(getEnergy() - 5);

        // Validasi tetap menggunakan getter untuk menjaga prinsip encapsulation.
        if (getHunger() >= 90) {
            setHealth(getHealth() - 10);
            System.out.println("⚠️ " + getName() + " melolong kelaparan! Health menurun!");
        }
    }
    
    
    @Override
    public void makeSound() {
        System.out.println("Woof! " + getName() + " menggonggong riang.");
        setHappiness(getHappiness() + 5);
    }

    @Override
    public void play() {
        System.out.println(getName() + " bermain fetch mengejar bola!");
        setHappiness(getHappiness() + 20);
        setEnergy(getEnergy() - 20);
    
    }
    @Override
    public String getSpecies() {
        return "Dog";
    }
}