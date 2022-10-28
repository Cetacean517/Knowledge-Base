/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methodreferencesexample;

/**
 *
 * @author betha
 */
public class Square {
    
    int sideLength;
    
    public Square(int sideLength) {
        this.sideLength = sideLength;
    }

    public int calculateArea() {
        return sideLength*sideLength;
    }
    
    
    
}
