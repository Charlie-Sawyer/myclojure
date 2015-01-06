package cscie55.hw2;

public class Floor {
    private int passengersWaiting = 0;
    private int floorNumber;
    private Building building;
    static final int FLOORS = 7;

    public int passengersWaiting() { return passengersWaiting; }

    public Floor(Building building, int floorNumber) {
	this.building = building;
	this.floorNumber = floorNumber;
    }
    public void waitForElevator() {
	passengersWaiting++;
    }
    public void decrementWaitListCount() {
	passengersWaiting--;
    }
}
