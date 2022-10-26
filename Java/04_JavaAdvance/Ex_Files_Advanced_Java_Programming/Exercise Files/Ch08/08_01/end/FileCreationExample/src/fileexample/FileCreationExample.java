
package fileexample;

import java.io.File;
import java.io.IOException;


public class FileCreationExample {

    public static void main(String[] args) {
        
        File myFile = new File("C:\\Users\\Bethan Palmer\\Desktop\\myFile.txt");
        try {
            boolean fileCreated = myFile.createNewFile();
            System.out.println(fileCreated);
        } catch (IOException ioe) {
            
        }

    }
    
}