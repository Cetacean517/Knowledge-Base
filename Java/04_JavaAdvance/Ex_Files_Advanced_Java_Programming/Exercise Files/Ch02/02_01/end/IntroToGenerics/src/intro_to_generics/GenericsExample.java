
package intro_to_generics;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bethan
 */
public class GenericsExample {
    
    public static void main(String[] args) {
        
        // Example without Generics
        List names = new ArrayList();
        names.add("Kelly");        
        String name = (String) names.get(0); 
        System.out.println("First name: " + name);
        names.add(7);
        
        
        // Example with Generics
        List<String> names2 = new ArrayList();
        names2.add("Kelly");        
        String name2 = names2.get(0);
        System.out.println("First name: " + name2);
        names2.add(7);
        
    }
    
}
