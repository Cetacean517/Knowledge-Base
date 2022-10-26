/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread_class;

/**
 *
 * @author bethan
 */
public class ThreadExample extends Thread {
    
    @Override
    public void run() {
        int i = 1;
        while(i <= 100) {
            System.out.println(i + " " + this.getName());
            i++;
        }
    }
    
    
    
}
