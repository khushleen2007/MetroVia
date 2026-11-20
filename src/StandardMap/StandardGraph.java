package StandardMap;

import java.util.HashMap;

// Initialises the predefined weighted metro graph.
public class StandardGraph{
    // Stores the standardGraph.
    public HashMap<String, HashMap<String, Double>> map = new HashMap<>(); 
    
    public StandardGraph(){
        // Hardcoded graph 
        // Station name - List of Adjacent stations and distance from it.
        HashMap<String, Double> n = new HashMap<>();
        n.put("Kharghar", 7.0);
        map.put( "Uran", new HashMap<>(n));
        n.clear();
        n.put("Uran", 7.0);
        n.put("Seawoods", 12.0);
        n.put("Khandeshwar", 3.0);
        n.put("Belapur", 5.0);
        map.put( "Kharghar", new HashMap<>(n));
        n.clear();
        n.put("Kharghar", 12.0);
        n.put("Belapur", 13.0);
        n.put("Nerul", 6.0);
        map.put( "Seawoods", new HashMap<>(n));
        n.clear();
        n.put("Kharghar", 3.0);
        n.put("Belapur", 4.0);
        map.put( "Khandeshwar", new HashMap<>(n));
        n.clear();
        n.put("Khandeshwar", 4.0);
        n.put("Kharghar", 5.0);
        n.put("Seawoods", 13.0);
        map.put( "Belapur", new HashMap<>(n));
        n.clear();
        n.put("Seawoods", 6.0);
        n.put("Chembur", 15.0);
        map.put("Nerul", new HashMap<>(n));
        n.clear();
        n.put("Nerul", 15.0);
        map.put( "Chembur", new HashMap<>(n));
    }

}