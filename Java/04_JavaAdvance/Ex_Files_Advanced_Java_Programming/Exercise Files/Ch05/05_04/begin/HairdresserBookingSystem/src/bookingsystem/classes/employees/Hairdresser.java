/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees;

import java.util.ArrayList;

/**
 *
 * @author Bethan
 */
public class Hairdresser {
    
    private String name;
    private ArrayList<String> daysAvailable = new ArrayList<>();
    
    public Hairdresser(String name) {
        this.name = name;
    }
    
    public void setDaysAvailable(String...days) {
        for(String day : days) {
            daysAvailable.add(day);
        }
    }
    
    public void removeDay(String day) {
        if(daysAvailable.contains(day)) {
            daysAvailable.remove(day);
        }
    }

    public ArrayList<String> getDaysAvailable() {
        return daysAvailable;
    }

    public String getName() {
        return name;
    }

        
    
}
