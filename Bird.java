// Deklarasi class Bird yang melakukan extends ke class Pet.
// Menunjukkan implementasi Inheritance di mana Bird adalah subclass dari superclass Pet.
public class Bird extends Pet {
    
    // Constructor untuk class Bird.
    public Bird(String name) {
        // Constructor Chaining: memanggil constructor milik superclass (Pet) 
        // untuk menginisialisasi atribut 'name' yang bersifat private di parent class.
        super(name);
    }

    // Subclass-specific method (Method Tambahan).
    // Memenuhi kriteria Milestone 3 di mana setiap subclass harus memiliki 
    // atribut atau behavior unik yang tidak dimiliki oleh parent class.
    public void sing() {
        // Menggunakan accessor getName() dan mutator setHappiness() 
        // karena atribut tersebut dienkapsulasi di superclass.
        System.out.println(getName() + " berkicau mania~");
        setHappiness(getHappiness() + 5);
    }

    // Method Overriding: Menimpa implementasi method timePasses() dari superclass.
    // Anotasi @Override memastikan bahwa signature method ini sama persis dengan yang ada di parent.
    @Override
    public void timePasses() {
        // Modifikasi state management khusus untuk class Bird.
        // Bird dirancang untuk lebih cepat lapar (+15) dan energinya lebih cepat habis (-15).
        // Modifikasi ini diimplementasikan menggunakan pemanggilan kombinasi getter dan setter.
        setHunger(getHunger() + 15); 
        setHappiness(getHappiness() - 5);
        setEnergy(getEnergy() - 15); 
        
        // Logika kondisi kritis tetap dipertahankan dari implementasi aslinya.
        if (getHunger() >= 90) {
            setHealth(getHealth() - 10);
            System.out.println("⚠️ " + getName() + " lemas kelaparan! Health menurun!");
        }
    }
}   