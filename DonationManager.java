import java.util.ArrayList;
import java.util.Scanner;


public class DonationManager {
    public static void main(String[] args) {
        ArrayList<Donation> donations = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        menu.show();
        menu.listMenu();
        System.out.print("Enter your choice : ");

        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    menu.addDonation(donations);
                    menu.clearScreen();
                    menu.show();
                    menu.listMenu();
                    System.out.print("Enter your choice : ");
                    break;
                case 2:
                    menu.clearScreen();
                    menu.show();
                    menu.deleteDonationsByCategory(donations);
                    menu.listMenu();
                    System.out.print("Enter your choice : ");
                    break;
                case 3:
                    menu.clearScreen();
                    menu.show();
                    menu.displayDonationsSortedByName(donations);
                    menu.listMenu();
                    System.out.print("Enter your choice : ");
                    break;
                case 4:
                    menu.clearScreen();
                    menu.show();
                    menu.displayDonationsSortedByNominal(donations);
                    menu.listMenu();
                    System.out.print("Enter your choice : ");
                    break;
                case 5:
                    menu.clearScreen();                    
                    menu.show2();
                    menu.displayAmountByCategory(donations);
                    menu.listMenu();
                    System.out.print("Enter your choice : ");
                    break;
                case 6:
                    menu.clearScreen();
                    menu.showOnly();    
                    menu.findDonation(donations);
                    menu.listMenu();              
                    System.out.print("Enter your choice : ");
                    break;
                case 7:
                    menu.clearScreen();
                    menu.show();
                    menu.listMenu();
                    menu.exportDonation(donations);
                    System.out.print("Enter your choice : ");
                    break;
                case 8:
                    scanner.close();
                    menu.clearScreen();
                    menu.show();
                    System.out.println("-------------------------------------------------------------------------------------");
                    menu.displayDonationsSortedByName(donations);
                    System.out.println("-------------------------------------------------------------------------------------");
                    menu.displayAmountByCategory(donations);
                    System.out.println("-------------------------------------------------------------------------------------");
                    System.out.println("||                             Mengakhiri program. . .                             ||");
                    System.out.println("=====================================================================================");
                    System.exit(0);
            }
        }
    }
}
class Donation {
    String name; int nominal; int category;
    public Donation(String name, int nominal, int category) {
        this.name = name; this.nominal = nominal; this.category = category;
    }
    public int amount() {
        return 0;
    }
    public String getName() {
        return name;
    }

    public int getNominal() {
        return nominal;
    }

    public int getCategory() {
        return category;
    }
}
