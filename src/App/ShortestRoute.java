package App;
// package src;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// TODO: Isolation station exception
// TODO: Custom Map and dynamic map creation
// TODO: Add estimated time for travel

// Node class - for Priority queue  
class Node{
    String station;
    double distance;
    Node(String station, double distance){
        this.station = station;
        this.distance = distance;
    }
}
public class ShortestRoute {
    public ShortestRoute(){
        
    }
    // Assuming average speed of metro to be 75km/hr.
    final double METRO_SPEED = 75;
    public double estimatedTime(double distance){
        // returns time in minutes
        return (distance/METRO_SPEED)*60;
    }

    // Method for calculating shortest distance using Dijkstra algo 
    public double shotestDistance(String source, String destination, HashMap<String, HashMap<String, Double>> map){
        // Hashmap to store station and its relative distances
        HashMap<String, Double> minDistance = new HashMap<>();
        // Hashmap to store parent and child, so traverse back the route
        HashMap<String, String> parent = new HashMap<>();
        // Priority Queue which uses min heap for shortest distance
        PriorityQueue<Node>  pq = new PriorityQueue<>(
            (a,b) -> Double.compare(a.distance, b.distance)
        );

        // Setting all station distance to infinity
        for(Map.Entry<String, HashMap<String,Double>> station : map.entrySet() ){
            minDistance.put(station.getKey(), Double.MAX_VALUE);
        }
        // Setting source station distance to 0
        minDistance.put(source, 0.0);
        pq.offer(new Node(source, 0));

        // Calculating min distance of each node from source
        while(!pq.isEmpty()){
            Node current = pq.poll();
            if(current.distance > minDistance.get(current.station)){
                continue;
            }
            for(Map.Entry<String, Double> neighbour : map.get(current.station).entrySet()){
                if(neighbour.getValue() + current.distance < minDistance.get(neighbour.getKey())){
                    minDistance.put(neighbour.getKey(), neighbour.getValue() + current.distance);
                    parent.put(neighbour.getKey(), current.station);
                    pq.offer(new Node(neighbour.getKey(), neighbour.getValue() + current.distance));
                }
            }
        }

        // Tracking route back to source
        List<String> route = new ArrayList<>();
        route.add(0, destination);


        while(parent.containsKey(route.get(0)) && !route.get(0).equals(source)){
            route.add(0, parent.get(route.get(0)));
        }
        
        // Displaying travelling details
        System.out.println("\n-------- Travelling Details ---------");
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
        if(route.size() == 1){
            System.out.println("Route don't Exist.");
            System.out.println("Try with other Location.");
        }else{
            System.out.println("Minimum Distance is: " + minDistance.get(destination) + " km");
            System.out.println("Estimated time: " + estimatedTime(minDistance.get(destination)) + " mins");
            System.out.print("Metro route: ");
            int i = 0;
            for(i = 0; i< route.size() - 1 ; i++){
                System.out.print(route.get(i) + " -> ");
            }
            System.out.print(route.get(i) + "\n");
        }

        // Returning the min distance of destination from source
        return minDistance.get(destination);
    }

}
