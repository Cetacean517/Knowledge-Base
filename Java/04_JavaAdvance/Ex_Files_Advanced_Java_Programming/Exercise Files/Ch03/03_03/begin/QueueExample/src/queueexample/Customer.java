/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queueexample;

/**
 *
 * @author betha
 */
public class Customer {
    
    private boolean hasBeenServed;
    private String name;
    
    
    public Customer(String name) {
        hasBeenServed = false;
        this.name = name;
    }

    public void serve() {
        hasBeenServed = true;  
        System.out.println(name + " has been served");
    }
    
    @Override
    public String toString(){
        return name;
    }
    
}
