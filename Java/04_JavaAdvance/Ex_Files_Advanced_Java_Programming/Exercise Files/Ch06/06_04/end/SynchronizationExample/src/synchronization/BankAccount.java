
package synchronization;

/**
 *
 * @author bethan
 */
public class BankAccount {
    
    private int balance = 0;
    private final int overdraft;
     
    public BankAccount(int overdraft) {
        this.overdraft = overdraft;
    }

    void topUp(int amount) {
        balance += amount;
    }
    
    void debit(int amount) {
        balance -= amount;
    }
    
    int getBalance() {
       return balance; 
    }
    
    int getOverdraft() {
        return overdraft;
    } 
        
    
}
