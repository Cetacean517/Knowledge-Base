package methodreferencesexample;

/**
 *
 * @author bethan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Square s = new Square(4);

        Shapes shapes = Square::calculateArea;

        System.out.println("Area: " + shapes.getArea(s));

    }

}
