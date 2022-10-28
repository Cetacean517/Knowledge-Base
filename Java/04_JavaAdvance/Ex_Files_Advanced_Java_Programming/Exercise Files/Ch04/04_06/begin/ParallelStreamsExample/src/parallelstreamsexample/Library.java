
package parallelstreamsexample;

import java.util.ArrayList;

/**
 *
 * @author bethan
 */
public class Library {
    
    
        public static void main(String[] args) {
            
        ArrayList<Book> books = populateLibrary();
                
        books.stream().filter(book -> {
            return book.getAuthor().startsWith("J");
        }).forEach(System.out::println);                               

    }

    static ArrayList<Book> populateLibrary() {
        ArrayList<Book> bookCollection = new ArrayList();
        bookCollection.add(new Book("Alice Walker", "The Color Purple"));
        bookCollection.add(new Book("Alice Walker", "Meridian"));
        bookCollection.add(new Book("Toni Morrison", "Beloved"));
        bookCollection.add(new Book("Toni Morrison", "Jazz"));
        bookCollection.add(new Book("Toni Morrison", "Paradise"));
        bookCollection.add(new Book("John Steinbeck", "The Grapes of Wrath"));
        bookCollection.add(new Book("John Steinbeck", "East of Eden"));
        bookCollection.add(new Book("Kazuo Ishiguro", "The Remains of the Day"));
        bookCollection.add(new Book("Kazuo Ishiguro", "Never Let Me Go"));
        bookCollection.add(new Book("Kazuo Ishiguro", "The Buried Giant"));
        bookCollection.add(new Book("Jane Austen", "Pride and Prejudice"));
        bookCollection.add(new Book("Jane Austen", "Emma"));
        bookCollection.add(new Book("Jane Austen", "Persuasion"));
        bookCollection.add(new Book("Jane Austen", "Mansfield Park"));
        bookCollection.add(new Book("Chinua Achebe", "Things Fall Apart"));
        bookCollection.add(new Book("Chinua Achebe", "No Longer at Ease"));
        bookCollection.add(new Book("Chinua Achebe", "Home and Exile"));
        return bookCollection;
    }
    
}
