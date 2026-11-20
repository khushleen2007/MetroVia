package PersonalizedMap;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

// Accepts user input and builds a personalised graph.
public class PersonalizedGraph {
    // static personalizedMap so that it is common to all the objects of this class
    static HashMap<String, HashMap<String, Double>> personalizedMap= new HashMap<>();
    Scanner sc = new Scanner(System.in);
    
    // Method to create graph by taking user inputs.
    public void createGraph(){
        personalizedMap.clear();
        System.out.println("Start creating your own Map!");
        System.out.print("Enter number of Stations: ");
        try{
            int stations = sc.nextInt();
            if(stations <= 1){
                System.out.println("Error: Number of stations muct be greater than 1.");
                return;
            }
            while(stations > 0){
                System.out.print("Enter station name: ");
                String stationName = sc.next();
                System.out.print("Enter number of neighbouring stations: ");
                int neig = sc.nextInt();
                HashMap<String, Double> n = new HashMap<>();
                while(neig > 0){
                    System.out.print("Enter neighbouring station name: ");
                    String neighbourName = sc.next();
                    System.out.print("Enter "+ neighbourName +" distance from "+ stationName+ " (in km): ");
                    double neighbourDistance = sc.nextDouble();
                    n.put(neighbourName, neighbourDistance);
                    neig--;
                }
                personalizedMap.put(stationName, n);
                stations--;
            }
        // Exception Handeling
        }catch(InputMismatchException e){
            System.out.println("Please enter a valid data..\n" + e);
            System.out.println("The map could not be generated.");
        }
    }
}
