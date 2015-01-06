package cscie55.hw2;

public class Building {
    public static final int FLOORS = 7;
    private Floor[] floors = new Floor[FLOORS];
    private Elevator elevator;

    public Building() {
	for (int i = 0; i < Floor.FLOORS; i++) {
	    floors[i] = new Floor(this, i);
	}
	elevator = new Elevator(this);
    }
    public Floor floor(int floorNumber) {
	return floors[floorNumber - 1];
    }
    public Elevator elevator() {
	return elevator;
    }
    Floor getFloor(int floorNum) {
	return floors[floorNum - 1];
    }
}
