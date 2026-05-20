import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Deklarasi variabel referensi menggunakan tipe Parent Class (Pet).
        // penerapan Polymorphic Reference, di mana variabel tipe superclass 
        // disiapkan untuk menampung objek dari subclass-nya nanti.
        Pet myPet = null; 

        System.out.println("=== VIRTUAL PET SIMULATOR ===");
        // Pemain memilih jenis hewan peliharaan
        System.out.println("Pilih jenis hewan peliharaan: ");
        System.out.println("1. Cat  (Mudah dirawat, suka tidur)");
        System.out.println("2. Dog  (Butuh perhatian, sangat setia)");
        System.out.println("3. Bird (Makan sedikit, energi cepat habis)");
        System.out.print("Pilihan (1/2/3): ");
        int jenis = input.nextInt();
        input.nextLine(); // Membersihkan sisa newline character dari buffer

        // Pemain memberi nama hewan
        System.out.print("Berikan nama untuk peliharaanmu: ");
        String nama = input.nextLine();

        // Proses instansiasi objek berdasarkan input user (Subclass terintegrasi di Main).
        // Melakukan upcasting: objek subclass (Cat/Dog/Bird) di-assign ke referensi superclass (Pet).
        if (jenis == 1) {
            myPet = new Cat(nama);
        } else if (jenis == 2) {
            myPet = new Dog(nama);
        } else if (jenis == 3) {
            myPet = new Bird(nama);
        } else {
            System.out.println("Pilihan tidak valid, default ke Cat.");
            myPet = new Cat(nama);
        }

        System.out.println("\nSelamat datang, " + myPet.getName() + "!");

        // Game loop: Kondisi terminasi menggunakan getter getHealth() untuk 
        // memastikan program mematuhi aturan encapsulation.
        while (myPet.getHealth() > 0) {
            myPet.showStatus();
            
            // Menambahkan menu 4. Sound untuk memicu makeSound()
            System.out.println("\nMenu: 1. Feed | 2. Play | 3. Sleep | 4. Sound | 5. Exit");
            System.out.print("Pilihan: ");
            int pilihan = input.nextInt();

            if (pilihan == 1) {
                System.out.println("Pilih makanan: 1. Dry Food | 2. Wet Food | 3. Treat");
                System.out.print("Pilihan makanan: ");
                int pilMakan = input.nextInt();
                
                // Passing object subclass Makanan (DryFood/WetFood/Treat) sebagai argumen ke method feed().
                // Ini diizinkan karena method feed(Food f) menerima parameter bertipe Parent Class Food.
                if (pilMakan == 1) myPet.feed(new DryFood());
                else if (pilMakan == 2) myPet.feed(new WetFood());
                else myPet.feed(new Treat());
            } 
           else if (pilihan == 2) myPet.play();
            else if (pilihan == 3) myPet.sleep();
            else if (pilihan == 4) myPet.makeSound(); // Pemanggilan Polymorphic Method
            else if (pilihan == 5) break;
            else System.out.println("Pilihan tidak valid!");
            
            System.out.println("---------------------------------------");
        }

        // Validasi Game Over jika keluar dari loop karena health habis
        if (myPet.getHealth() <= 0) {
            System.out.println("\n[GAME OVER] " + myPet.getName() + " telah tiada...");
        }
        input.close();
    }
}