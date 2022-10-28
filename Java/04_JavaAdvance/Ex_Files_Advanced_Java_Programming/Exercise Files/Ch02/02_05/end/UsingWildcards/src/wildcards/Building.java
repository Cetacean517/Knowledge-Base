package wildcards;

/**
 *
 * @author bethan
 */
class Building {

    public int numberOfRooms = 7;

    @Override
    public String toString() {
        return ("building");
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

}
