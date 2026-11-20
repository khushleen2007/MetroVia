package App;
import PersonalizedMap.PersonalizedMenu;
import StandardMap.StandardMenu;
import java.util.InputMismatchException;
import java.util.Scanner;

// Main class - Displays the top level menu and opens the selected map mode.
public class Main {
    Scanner sc = new Scanner(System.in);
    StandardMenu sm = new StandardMenu();
    PersonalizedMenu pm = new PersonalizedMenu();

    public void menu(){
        while (true) { 
            System.out.println("-----------------------------------------------------");
            System.out.println("    Welcome to Metrovia - Smart metro navigation");
            System.out.println("-----------------------------------------------------");
            System.out.println("Select preference for map: ");
            System.out.println("1. Standard Map");
            System.out.println("2. Personalised Map");
            System.out.println("3. Exit");
            System.out.print("Enter Choice: ");
            // Using try and catch for Exception handeling (InputMismatchException)
            try {
                int choice = sc.nextInt();
                if(choice == 3){
                    System.out.println("Thank you...");
                    System.out.println("Exiting Metrovia...");
                    break;
                }
                switch(choice){
                    case 1:
                        sm.standardMenu();
                        break;
                    case 2:
                        pm.personalizedMenu();
                        break;
                    default:
                        System.out.println("Please, Enter a valid chioce between 1 - 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid type of data..");
            }
            
        }
    }
    public static void main(String[] args) {
        // Creating unreferenced object to execute the menu method 
        new Main().menu();
    }
}
