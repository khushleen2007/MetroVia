package StandardMap;

// Check whether entered station names exist in the relevant graph.
public class Validation {

    // To chheck is station exists in given Map
    public boolean isValid(String station){
        StandardGraph graph = new StandardGraph();
        return graph.map.containsKey(station);
    }
}
