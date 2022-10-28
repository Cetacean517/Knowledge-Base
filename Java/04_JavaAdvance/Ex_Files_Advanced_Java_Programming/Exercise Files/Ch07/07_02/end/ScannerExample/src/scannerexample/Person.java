/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scannerexample;

/**
 *
 * @author betha
 */
public class Person {
    
    private String name;
    private int age;
    private long phoneNumber;
    
    public Person(String name, int age, long phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        System.out.println("Person Created. Name: " 
                + name + ", Age: " + age + ", phone number: " + phoneNumber);
    }
    
}
