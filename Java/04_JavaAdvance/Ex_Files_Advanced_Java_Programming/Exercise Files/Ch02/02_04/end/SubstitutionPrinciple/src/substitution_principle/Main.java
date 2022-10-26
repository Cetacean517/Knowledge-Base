
package substitution_principle;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bethan
 */
public class Main {
    
    
    public static void main(String[] args) {
        Building building = new Building();        
        Office office = new Office();
        build(building);
        build(office);
        
        List<Building> buildings = new ArrayList();
        buildings.add(new Building());
        buildings.add(new Office());
        printBuildings(buildings);
        
        List<Office> offices = new ArrayList();
        offices.add(new Office());
        offices.add(new Office());
        printBuildings(offices);
        
    }
    
    static void build(Building building) {
        System.out.println("Constructing a new " + building.toString());
    }
    
    static void printBuildings(List<Building> buildings) {
        for(int i = 0; i < buildings.size(); i++) {
            System.out.println(i + 1 + ": " + buildings.get(i).toString());
        }
    }
    
}
