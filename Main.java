import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pet myPet = null; // Siapkan variabel induk, isinya nanti sesuai pilihan

        System.out.println("=== VIRTUAL PET SIMULATOR ===");
        System.out.println("Pilih jenis hewan peliharaan: ");
        System.out.println("1. Cat  (Mudah dirawat, suka tidur)");
        System.out.println("2. Dog  (Butuh perhatian, sangat setia)");
        System.out.println("3. Bird (Makan sedikit, energi cepat habis)");
        System.out.print("Pilihan (1/2/3): ");
        int jenis = input.nextInt();
        input.nextLine(); // Membersihkan sisa enter

        System.out.print("Berikan nama untuk peliharaanmu: ");
        String nama = input.nextLine();

        // Membuat objek berdasarkan pilihan user (Polymorphic Reference untuk M3)
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

        // Loop Game Utama
        while (myPet.getHealth() > 0) {
            myPet.showStatus();
            
            System.out.println("\nMenu: 1. Feed | 2. Play | 3. Sleep | 4. Exit");
            System.out.print("Pilihan: ");
            int pilihan = input.nextInt();

            if (pilihan == 1) {
                System.out.println("Pilih makanan: 1. Dry Food | 2. Wet Food | 3. Treat");
                System.out.print("Pilihan makanan: ");
                int pilMakan = input.nextInt();
                
                // Menggunakan makanan dari Subclass Food
                if (pilMakan == 1) myPet.feed(new DryFood());
                else if (pilMakan == 2) myPet.feed(new WetFood());
                else myPet.feed(new Treat());
            } 
            else if (pilihan == 2) myPet.play();
            else if (pilihan == 3) myPet.sleep();
            else if (pilihan == 4) break;
            
            System.out.println("---------------------------------------");
        }

        if (myPet.getHealth() <= 0) {
            System.out.println("\n[GAME OVER] " + myPet.getName() + " telah tiada...");
        }
        input.close();
    }
}