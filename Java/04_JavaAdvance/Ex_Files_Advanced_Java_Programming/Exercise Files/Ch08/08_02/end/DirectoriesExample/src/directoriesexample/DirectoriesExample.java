/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directoriesexample;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author Bethan Palmer
 */
public class DirectoriesExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        FilenameFilter filter = (file, fileName) -> {
            return fileName.contains(".");
        };
   
        
        String[] contents = new File(".").list(filter);
        for(String file: contents) {
            System.out.println(file);
        }
        new File("myDirectory").mkdir();
        
    }
    
}
