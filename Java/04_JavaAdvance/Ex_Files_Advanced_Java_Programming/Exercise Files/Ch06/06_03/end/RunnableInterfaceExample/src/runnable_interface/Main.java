
package runnable_interface;

/**
 *
 * @author bethan
 */
public class Main {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableExample());
        thread1.start();
        
        Thread thread2 = new Thread(() -> {
            int i = 0;
            while (i <= 100) {
                System.out.println(i + " " + Thread.currentThread().getName());
                i++;
            }
        });
        
        thread2.start();

    }

}
