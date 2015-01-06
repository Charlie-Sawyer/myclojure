package cscie55.hw2;

public class Elevator {
    private static final int MAXFLOOR = Building.FLOORS;
    public static final int CAPACITY = 10;
    enum DIRECTION { UP, DOWN }
    DIRECTION direction;
    private int currentFloor;
    private int passengers[] = new int[Building.FLOORS];
    private Building building;
    public Elevator(Building building) { 
	this.building = building;
	direction = DIRECTION.UP;
	currentFloor = 1;
    }
    private void switchDirection() {
	if (direction == DIRECTION.UP ) {
	    direction = DIRECTION.DOWN;
	} else {
	    direction = DIRECTION.UP;
	}
    }
    private void changeFloorNumber() {
	if (direction == DIRECTION.UP) {
	    currentFloor++;
	} else {
	    currentFloor--;
	}
    }
    private boolean stopAtCurrentFloor() {
	boolean shouldStop = 
	passengers[currentFloor - 1] > 0 
	    || building.getFloor(currentFloor).passengersWaiting() > 0;
	return shouldStop;
    }
    public void move() {
	if (currentFloor == MAXFLOOR) {
	    direction = DIRECTION.DOWN;
	}
	if (currentFloor == 1) {
	    direction = DIRECTION.UP;
	}
	changeFloorNumber();
	if (stopAtCurrentFloor()) {
	    stopAt();
	}
    }
    private void stopAt() {
	int numToBoard =  building.floor(currentFloor).passengersWaiting();
	passengers[currentFloor - 1] = 0; // Discharge any pax on board
	System.out.println("Stopping at floor # " + currentFloor + ", # pax = " + passengers() + " numToBoard = " + numToBoard);
	for (int i = 0; i < numToBoard; i ++) {
	    try {
		boardPassenger(1); // Load pax waiting to go to first floor;
	    } catch (ElevatorFullException ex) {
		System.err.println(ex);
	    }
	}
    }
    public int passengers() {
	int numPax = 0;
	for (int num : passengers) {
	    numPax += num;
	}
	return numPax;
    }

    public String toString() {
	return "Floor " + currentFloor + ": " + passengers() + " passengers";
    }
    public void boardPassenger(int destinationFloorNumber) throws ElevatorFullException {
	    if (passengers() == CAPACITY) {
		System.err.println(";;; throwing exception"); 
		throw new ElevatorFullException("Current load = " + passengers());
	    }
	    passengers[destinationFloorNumber - 1]++;
	    building.floor(currentFloor).decrementWaitListCount();
    }

    public int currentFloor() {
	return currentFloor;
    }
}
