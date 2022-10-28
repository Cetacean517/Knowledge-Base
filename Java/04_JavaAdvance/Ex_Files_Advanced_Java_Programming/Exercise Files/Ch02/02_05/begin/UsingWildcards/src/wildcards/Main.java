
package wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bethan
 */
public class Main {
    
    
    public static void main(String[] args) {
        
        // List of buildings
        List<Building> buildings = new ArrayList();
        buildings.add(new Building());
        buildings.add(new Building());
        printBuildings(buildings);
        
        // List of offices
        List<Office> offices = new ArrayList();
        offices.add(new Office());
        offices.add(new Office());
        //printBuildings(offices);

        // List of houses
        List<House> houses = new ArrayList();
        houses.add(new House());
        houses.add(new House());
        //printBuildings(houses);
        
//        addHouseToList(houses);
//        addHouseToList(buildings);        
        
    }

    
    static void printBuildings(List<Building> buildings) {
        for(int i = 0; i < buildings.size(); i++) {
            System.out.println(buildings.get(i).toString() + " " + (i + 1));
        }
        System.out.println();
    }
    
    
    static void addHouseToList(List<House> buildings) {
        buildings.add(new House());
        System.out.println();
    }
    
    
}
