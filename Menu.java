import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.io.IOException;
import java.io.PrintWriter;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    boolean par;
    String ket;

    public void addDonation(ArrayList<Donation> donations) {
    
        System.out.print("Enter name        : ");
        String name = scanner.nextLine();
        System.out.print("Enter nominal     : ");
        int nominal = scanner.nextInt();
        scanner.nextLine();
        category();
        System.out.print("Enter category    : ");
        int category = scanner.nextInt();
        scanner.nextLine();    
        donations.add(new Donation(name, nominal, category));
      }

    public void findDonation(ArrayList<Donation> donations) {
        if(donations.isEmpty()){
        System.out.println("=====================================================================================");
        System.out.println("||                              Data masih Kosong !                                ||");
        System.out.println("=====================================================================================");
        }else{
            System.out.print("||  Enter name  : ");
        String name = scanner.nextLine();
            for (Donation donation : donations) {
                if (donation.getName().equals(name)) {
                    par = true;
                    System.out.println("=====================================================================================");
                    System.out.println("||                              Data ditemukan                                     ||");
                    System.out.println("=====================================================================================");
                    System.out.println("||  Nominal     : " + donation.getNominal());

                    if(donation.getCategory() == 1){
                        ket = "Pendidikan";
                    }else if(donation.getCategory() == 2){
                        ket = "Kesehatan";
                    }else if(donation.getCategory() == 3){
                        ket = "Lingkungan";
                    }
                    System.out.println("||  Category    : " + ket);
                    System.out.println("=====================================================================================");
                    return;
                }
            }
            if(par != true){
                System.out.println("=====================================================================================");
                System.out.println("||                    Data yang dicari tidak ditemukan!                            ||");
                System.out.println("=====================================================================================");
            }            
        }
    }
    
      public void category(){
        System.out.print("""
                    =====================================================================================
                    ||                             Kategori Tujuan Dana Donasi                         ||
                    =====================================================================================
                    ||                        1. Pendidikan                                            ||                  
                    ||                        2. Kesehatan                                             ||
                    ||                        3. Lingkungan                                            ||
                    -------------------------------------------------------------------------------------
                    """);
      }
      
      public void deleteDonationsByCategory(ArrayList<Donation> donations) {
        if(donations.isEmpty()){
            System.out.print("""
                -------------------------------------------------------------------------------------
                ||                      Data masih kosong, harap masukan data                      ||
                -------------------------------------------------------------------------------------
                """);
        }else{
            category();
        System.out.print("Enter category    : ");
        int category = scanner.nextInt();
        scanner.nextLine();
    
        for (int i = 0; i < donations.size(); i++) {
          if (donations.get(i).category == category) {
            donations.remove(i);
            i--;
                }
            }
        }
    }
    
      public void displayDonationsSortedByName(ArrayList<Donation> donations) {
        if(donations.isEmpty()){
            System.out.print("""
                    -------------------------------------------------------------------------------------
                    """);
            System.out.print("""
        ||                      Data masih kosong, harap masukan data                      ||
        """);
        }
        System.out.print("""
                    -------------------------------------------------------------------------------------
                    """);
        Collections.sort(donations, (d1, d2) -> d1.name.compareTo(d2.name));
        for (Donation donation : donations) {
            if(donation.category == 1){
                ket = "Pendidikan";
            }else if(donation.category == 2){
                ket = "Kesehatan";
            }else if(donation.category == 3){
                ket = "Lingkungan";
            }
            System.out.printf("||  %-22s  |  %-27s  |  %-18d  ||%n",
                                    ket, donation.name, donation.nominal);
        }
      }
    
      public void displayDonationsSortedByNominal(ArrayList<Donation> donations) {
        if(donations.isEmpty()){
            System.out.print("""
                -------------------------------------------------------------------------------------
                ||                      Data masih kosong, harap masukan data                      ||
                -------------------------------------------------------------------------------------
                """);
        }
        System.out.print("""
                    -------------------------------------------------------------------------------------
                    """);
        Collections.sort(donations, (d1, d2) -> d2.nominal - d1.nominal);
        for (Donation donation : donations) {
            if(donation.category == 1){
                ket = "Pendidikan";
            }else if(donation.category == 2){
                ket = "Kesehatan";
            }else if(donation.category == 3){
                ket = "Lingkungan";
            }
            System.out.printf("||  %-22s  |  %-27s  |  %-18d  ||%n",
                                    ket, donation.name, donation.nominal);
          }
        }

        public void displayAmountByCategory(ArrayList<Donation> donations) {
            int[] amounts = new int[3];
            for (Donation donation : donations) {
              amounts[donation.category-1] += donation.nominal;
            }
            for (int i = 0; i < 3; i++) {
                if(i == 0){
                    ket = "Pendidikan";
                }else if(i == 1){
                    ket = "Kesehatan";
                }else if(i == 2){
                    ket = "Lingkungan";
                }
                System.out.printf(
                "||   %-33s   |   Rp.%-32d   ||%n",
                ket, amounts[i]);
            }
        }

        public void showOnly(){
            System.out.println("""
                    =====================================================================================
                    ||                                                                                 ||                  
                    ||                              DONATION MANAGER APP                               ||
                    ||                                                                                 ||
                    -------------------------------------------------------------------------------------""");
        }

        public void show2(){
            System.out.println("""
                    =====================================================================================
                    ||                                                                                 ||                  
                    ||                              DONATION MANAGER APP                               ||
                    ||                                                                                 ||
                    =====================================================================================
                    ||                             DATA TRANSAKSI DONASI                               ||
                    =====================================================================================
                    ||           Tujuan Donasi               |                 Nominal                 ||
                    -------------------------------------------------------------------------------------""");
        }

        public void show(){
            System.out.print("""
                    =====================================================================================
                    ||                                                                                 ||                  
                    ||                              DONATION MANAGER APP                               ||
                    ||                                                                                 ||
                    =====================================================================================
                    ||                             DATA TRANSAKSI DONASI                               ||
                    =====================================================================================
                    ||      Tujuan Donasi       |         Nama Donatur          |       Nominal        ||
                    """);
        }
        public void listMenu(){
            System.out.print("""
            -------------------------------------------------------------------------------------
            ||                                 MAIN MENU DONASI                                ||
            =====================================================================================                            
            ||                          1. Tambahkan Data Donasi                               ||
            ||                          2. Setorkan  Dana Terkumpul                            ||
            ||                          3. Tampilkan Data sesuai Nama                          ||
            ||                          4  Tampilkan Data sesuai Nominal                       ||            
            ||                          5. Tampilkan Total Dana sesuai Kategori                ||
            ||                          6. Temukan Data dengan Nama                            ||
            ||                          7. Export Data Donasi                                  ||
            ||                          8. Akhiri Program                                      ||
            =====================================================================================
            """);
        }


        public void exportDonation(ArrayList<Donation> donations) {
            Stack<Donation> stack = new Stack<>();
            for (Donation donation : donations) {
                stack.push(donation);
            }

            if(donations.isEmpty()){
                System.out.print("""
                -------------------------------------------------------------------------------------
                ||              Data tidak tersedia.. Tidak dapat melakukan export!                ||
                -------------------------------------------------------------------------------------
                """);
            }else{
                try (PrintWriter writer = new PrintWriter("Donations.txt")) {
                    writer.println("----------------------------------");
                    writer.println("||      DATA DONASI TEREKAM     ||");
                    writer.println("----------------------------------");
                    while (!stack.isEmpty()) {
                        Donation donation = stack.pop();
                        writer.println("Nama    : " + donation.getName());
                        writer.println("Nominal : " + donation.getNominal());
    
                        if(donation.category == 1){
                            ket = "Pendidikan";
                        }else if(donation.category == 2){
                            ket = "Kesehatan";
                        }else if(donation.category == 3){
                            ket = "Lingkungan";
                        }
                        writer.println("Tujuan  : " +  ket);
                        writer.println(" ");
                    }
                    System.out.println("||  Berhasil melakukan export data! ");
                    System.out.println("-------------------------------------------------------------------------------------");
                } catch (IOException e) {
                    System.out.println("Gagal meng-ekspor data! ");
                }
            }
            
        }
        
        
        public void clearScreen() {
            try {
                if (System.getProperty("os.name").contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    System.out.print("\033\143");
                }
            } catch (Exception e) {
                System.err.println("Can't clear screen!");
            }
        }
        
        public void finish() {
            scanner.close();
        }
}
