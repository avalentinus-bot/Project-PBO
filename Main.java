import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Deklarasi variabel referensi menggunakan tipe Parent Class (Pet).
        // penerapan Polymorphic Reference, di mana variabel tipe superclass 
        // disiapkan untuk menampung objek dari subclass-nya nanti.
        Pet myPet = null; 

        System.out.println("+=============================+");
        System.out.println("|    VIRTUAL PET SIMULATOR    |");
        System.out.println("+=============================+");
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

        clearScreen();
        System.out.println("\nSelamat datang, " + myPet.getName() + "!");

        // Game loop: Kondisi terminasi menggunakan getter getHealth() untuk 
        // memastikan program mematuhi aturan encapsulation.
        while (myPet.getHealth() > 0) {
            // Memberikan jeda sebentar agar user bisa melihat aksi yang baru dilakukan
            try { Thread.sleep(1200); } catch (Exception e) {}
            
            clearScreen(); // Membersihkan layar agar tidak menumpuk ke bawah
            
            myPet.updateRealTime(); // Memperbarui state berdasarkan waktu dunia nyata
            myPet.showStatus();
            
            System.out.println("\n+---------------------------------------+");
            System.out.println("|               MAIN MENU               |");
            System.out.println("+---------------------------------------+");
            System.out.println("| 1. Feed          5. Check Status      |");
            System.out.println("| 2. Play          6. Shop              |");
            System.out.println("| 3. Sleep         7. Save Game         |");
            System.out.println("| 4. Sound         8. Load Game         |");
            System.out.println("| 9. Exit                               |");
            System.out.println("+---------------------------------------+");
            System.out.print("Pilih aksi: ");
            int pilihan = input.nextInt();

            if (pilihan == 1) {
                System.out.println("=== INVENTORI MAKANAN ===");
                System.out.println("1. Dry Food (" + myPet.getDryFoodCount() + "x)");
                System.out.println("2. Wet Food (" + myPet.getWetFoodCount() + "x)");
                System.out.println("3. Treat (" + myPet.getTreatCount() + "x)");
                System.out.print("Pilih makanan: ");
                int pilMakan = input.nextInt();
                
                if (pilMakan == 1) {
                    if (myPet.getDryFoodCount() > 0) {
                        myPet.setDryFoodCount(myPet.getDryFoodCount() - 1);
                        myPet.feed(new DryFood());
                    } else System.out.println("Dry Food habis! Silakan beli di Shop.");
                } else if (pilMakan == 2) {
                    if (myPet.getWetFoodCount() > 0) {
                        myPet.setWetFoodCount(myPet.getWetFoodCount() - 1);
                        myPet.feed(new WetFood());
                    } else System.out.println("Wet Food habis! Silakan beli di Shop.");
                } else if (pilMakan == 3) {
                    if (myPet.getTreatCount() > 0) {
                        myPet.setTreatCount(myPet.getTreatCount() - 1);
                        myPet.feed(new Treat());
                    } else System.out.println("Treat habis! Silakan beli di Shop.");
                } else {
                    System.out.println("Pilihan tidak valid.");
                }
            } 
            else if (pilihan == 2) {
                myPet.play();
                myPet.setMoney(myPet.getMoney() + 20);
                System.out.println(myPet.getName() + " mendapatkan 20 Koin karena bermain!");
            }
            else if (pilihan == 3) myPet.sleep();
            else if (pilihan == 4) myPet.makeSound(); // Pemanggilan Polymorphic Method
            else if (pilihan == 5) System.out.println("Mengecek status terbaru...");
            else if (pilihan == 6) {
                System.out.println("=== TOKO MAKANAN ===");
                System.out.println("Uang kamu: " + myPet.getMoney() + " koin");
                System.out.println("1. Dry Food (10 koin)");
                System.out.println("2. Wet Food (25 koin)");
                System.out.println("3. Treat (15 koin)");
                System.out.println("4. Batal");
                System.out.print("Pilih yang mau dibeli: ");
                int beli = input.nextInt();
                
                if (beli == 1 && myPet.getMoney() >= 10) {
                    myPet.setMoney(myPet.getMoney() - 10);
                    myPet.setDryFoodCount(myPet.getDryFoodCount() + 1);
                    System.out.println("Berhasil membeli Dry Food!");
                } else if (beli == 2 && myPet.getMoney() >= 25) {
                    myPet.setMoney(myPet.getMoney() - 25);
                    myPet.setWetFoodCount(myPet.getWetFoodCount() + 1);
                    System.out.println("Berhasil membeli Wet Food!");
                } else if (beli == 3 && myPet.getMoney() >= 15) {
                    myPet.setMoney(myPet.getMoney() - 15);
                    myPet.setTreatCount(myPet.getTreatCount() + 1);
                    System.out.println("Berhasil membeli Treat!");
                } else if (beli == 4) {
                    System.out.println("Batal membeli.");
                } else {
                    System.out.println("Uang tidak cukup atau pilihan tidak valid.");
                }
            }
            else if (pilihan == 7) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("pet_save.dat"))) {
                    oos.writeObject(myPet);
                    System.out.println("Game berhasil disimpan!");
                } catch (Exception e) {
                    System.out.println("Gagal menyimpan: " + e.getMessage());
                }
            }
            else if (pilihan == 8) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pet_save.dat"))) {
                    myPet = (Pet) ois.readObject();
                    myPet.setLastTimeChecked(System.currentTimeMillis()); 
                    System.out.println("Game berhasil dimuat! Selamat datang kembali, " + myPet.getName());
                } catch (Exception e) {
                    System.out.println("Gagal memuat save file atau file tidak ditemukan.");
                }
            }
            else if (pilihan == 9) break;
            else System.out.println("Pilihan tidak valid!");
        }

        // Validasi Game Over jika keluar dari loop karena health habis
        if (myPet.getHealth() <= 0) {
            clearScreen();
            System.out.println("\n[GAME OVER] " + myPet.getName() + " telah tiada...");
        }
        input.close();
    }

    // Helper method untuk membersihkan terminal console
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (Exception ex) {
            // Jika terminal tidak mendukung, beri jeda baris saja
            System.out.println("\n\n\n\n\n");
        }
    }
}