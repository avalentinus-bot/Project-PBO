import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Membuat Object Pet dan Food
        Pet myPet = new Pet("kucing");
        Food snack = new Food("whiskas", 15);
        Food meat = new Food("ikan asin", 30);

        System.out.println("=== ambanimal ===");

        // Loop Game: Berjalan selama Health peliharaan masih di atas 0
        while (myPet.getHealth() > 0) {
            myPet.showStatus();
            
            System.out.println("\nApa yang ingin dilakukan?");
            System.out.println("1. Feed (Beri Makan)");
            System.out.println("2. Play (Bermain)");
            System.out.println("3. Sleep (Tidur)");
            System.out.println("4. Exit (Keluar)");
            System.out.print("Pilihan: ");
            
            int pilihan = input.nextInt();

            // Logika aksi berdasarkan input
            if (pilihan == 1) {
                System.out.println("Pilih makanan: 1. whiskas 2. ikan asin");
                System.out.print("Pilihan makanan: ");
                int pilMakan = input.nextInt();
                
                if (pilMakan == 1) myPet.feed(snack);
                else if (pilMakan == 2) myPet.feed(meat);
                else System.out.println("Makanan tidak tersedia!");
            } 
            else if (pilihan == 2) {
                myPet.play();
            } 
            else if (pilihan == 3) {
                myPet.sleep();
            } 
            else if (pilihan == 4) {
                System.out.println("Menutup simulator. Sampai jumpa!");
                break;
            } 
            else {
                System.out.println("Input tidak valid. Masukkan angka 1-4.");
            }
            
            System.out.println("---------------------------------------");
        }

        // Cek kondisi akhir
        if (myPet.getHealth() <= 0) {
            System.out.println("\n[GAME OVER] " + myPet.getName() + " telah tiada karena tidak terawat...");
        }

        input.close();
    }
}