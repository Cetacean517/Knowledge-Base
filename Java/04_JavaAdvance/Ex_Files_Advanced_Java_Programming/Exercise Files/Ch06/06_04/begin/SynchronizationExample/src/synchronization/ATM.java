/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package synchronization;

/**
 *
 * @author betha
 */
public class ATM {    
    
    static void withdraw(BankAccount account, int amount) {  
        int balance = account.getBalance();
        if((balance - amount) < - account.getOverdraft()) {
            System.out.println("Transaction denied!");            
        } else {
            account.debit(amount);
            System.out.println("$" + amount + " successfully withdrawn");
        }
        System.out.println("Current balance: " + account.getBalance());                           
        
    }
    
    
}
