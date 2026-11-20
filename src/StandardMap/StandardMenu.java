package StandardMap;

import App.ShortestRoute;
import java.util.InputMismatchException;
import java.util.Scanner;

// Provides standard-map menu operations and calls route calculation.
public class StandardMenu {
    Scanner sc = new Scanner(System.in);

    public StandardMenu() {
    }
    
    public void standardMenu(){
        StandardGraph graph = new StandardGraph();
        StandardMapUI mapui = new StandardMapUI();
        ShortestRoute shortest = new ShortestRoute();
        Validation val = new Validation();
        while(true){
            System.out.println("-----------------------------------------------------");
            System.out.println("                Welcome to Standard Map");
            System.out.println("-----------------------------------------------------");
            System.out.println("1. View Graphical Map");
            System.out.println("2. List of stations and neighbours");
            System.out.println("3. Adjacency List of stations");
            System.out.println("4. Find Shortest Route");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            try {
                int choice = sc.nextInt();
                if(choice == 5){
                    System.out.println("\nExiting Standard Maps...");
                    System.out.println("Back to Main menu...\n");
                    break;
                }
                switch(choice){
                    case 1:
                        mapui.displayMap();
                        break;
                    case 2:
                        mapui.displayStations();
                        break;
                    case 3: 
                        mapui.displayAdjacencyList();
                        break;
                    case 4:
                        System.out.print("Enter Source: ");
                        String s = sc.next();
                        if(!val.isValid(s)){
                            System.out.println("Please, Enter a valid source!");
                            continue;
                        }
                        System.out.print("Enter Destination: ");
                        String d = sc.next();
                        if(!val.isValid(d)){
                            System.out.println("Please, Enter a valid destiination!");
                            continue;
                        }
                        shortest.shotestDistance( s, d, graph.map);
                        break;
                    default:
                        System.out.println("Please, Enter a valid choice between 1 to 5.");
                        break;
                }

            // Exception handeling
            } catch (InputMismatchException e) {
                System.out.println("Please, Enter a valid value...");
            }
        }
    }
    public static void main(String[] args) {
        new StandardMenu().standardMenu();
    }
}
