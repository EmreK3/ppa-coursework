public class Aeroplane {
	private String name;
	private Coordinates coordinates;
	private int speed;
	private int totalDistance;
	private int repairDistance;
	private int journeyDistance;

	public Aeroplane(String name, Coordinates coordinates, int speed, int totalDistance, int repairDistance) {
		this.name = name;
		this.coordinates = coordinates;
		this.speed = speed;
		this.totalDistance = totalDistance;
		this.repairDistance = repairDistance;
	}

	public int singleFlight(Coordinates destination) {
		int totalDistanceX = 0;
		int totalDistanceY = 0;

		while(coordinates.getX() < destination.getX()) {
			if(destination.getX() - coordinates.getX() >= speed) {
				coordinates.addX(speed);
				totalDistanceX += speed;
			} else if(destination.getX() - coordinates.getX() < speed) {
				int differenceX = destination.getX() - coordinates.getX();
				coordinates.addX(differenceX);
				totalDistanceX += differenceX;
			}
		}

		while(coordinates.getX() > destination.getX()) {
			if(coordinates.getX() - destination.getX() >= speed) {
				coordinates.subX(speed);
				totalDistanceX += speed;
			} else if(coordinates.getX() - destination.getX() < speed) {
				int differenceX = coordinates.getX() - destination.getX();
				coordinates.subX(differenceX);
				totalDistanceX += differenceX;
			}
		}

		while(coordinates.getY() < destination.getY()) {
			if(destination.getY() - coordinates.getY() >= speed) {
				coordinates.addY(speed);
				totalDistanceY += speed;
			} else if(destination.getY() - coordinates.getY() < speed) {
				int differenceY = destination.getY() - coordinates.getY();
				coordinates.addY(differenceY);
				totalDistanceY += differenceY;
			}
		}

		while(coordinates.getY() > destination.getY()) {
			if(coordinates.getY() - destination.getY() >= speed) {
				coordinates.subY(speed);
				totalDistanceY += speed;
			} else if(coordinates.getY() - destination.getY() < speed) {
				int differenceY = coordinates.getY() - destination.getY();
				coordinates.subY(differenceY);
				totalDistanceY += differenceY;
			}
		}

		totalDistance += totalDistanceX + totalDistanceY;
		journeyDistance = totalDistanceX + totalDistanceY;
		return totalDistance;
	}

	public int getJourneyDistance() {
		return journeyDistance;
	}

	public void zeroTotalDistance() {
		totalDistance = 0;
	}

	public int getTotalDistance() {
		return totalDistance;
	}

	public String getName() {
		return name;
	}
	
	public int getRepairDistance() {
		return repairDistance;
	}
}