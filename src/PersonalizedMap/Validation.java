package PersonalizedMap;

// Check whether entered station names exist in the relevant graph.
public class Validation {
    PersonalizedGraph graph = new PersonalizedGraph(); 

    // To check is station exists in given Map
    public boolean isValid(String station){
        return graph.personalizedMap.containsKey(station);
    }
}
