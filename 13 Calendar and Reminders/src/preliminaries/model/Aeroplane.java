package preliminaries.model;


public class Aeroplane {
	
	private int X;
	private int Y;
	private int speed;
	private int elevation;
	private int runUP;
	private int up;
	
	
	public Aeroplane(int X, int Y, int speed, int elevation) {
		
		this.X = X;
		this.Y = Y;
		this.speed = speed; 
		this.setElevation(elevation);
	}

	/**
	 * @return the elevation
	 */
	public int getElevation() {
		return elevation;
	}
	
	/**
	 * check if elevation is less than 4
	 */
	
	public boolean inFlight(){
		if(elevation < 6){
			return false;
		}else{
			return true;
		}
	}


	/**
	 * @param elevation the elevation to set
	 */
	public void setElevation(int elevation) {
		this.elevation = elevation;
		if(elevation < 0){
			setElevation(0);
		}
	}
	/**
	public boolean inTakeOffPosition(){
		if(X!=5){
			return false;
		}else{
			return true;
		}
	}
	*/

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		
		return speed;
	}

	/**
	 * @param supply a value for the speed to set, and record if the aeroplane is running in maximum speed.
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
		
		if(speed==10){
			
			runUP++;
		}
		
	}
	
	/**
	 * return how many seconds the aeroplane has ran with maximum speed.
	 * @return
	 */
	public int retrunUP(){
		return runUP;
	}

	/**
	 * sets the runUP value
	 * @param runUP
	 */
	public void setRunUP(int runUP){
		this.runUP = runUP;
		
	}
	
	/**
	 * @return the y
	 */
	public int getY() {
		return Y;
	}

	/**
	 * @param set the y distance of the plane
	 */
	public void setY(int ytoset) {
		Y = Y += ytoset;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return X;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.X= x;
	}
	
	public void elevation(){
		
		// have to make sure elevation only occurs after it has reached maximum speed for 5 seconds.
		
		if (runUP > 4){
			setElevation(up++);
		}
		else{
			setElevation(0);
		}
	}
	// this method must implement on the timer = where if it maintains more than 4 seconds, this elevation activates.

	@Override
	public String toString() {
		return " X: " + getX() + " Y: " + getY() + " Speed: "+ getSpeed() + " Elevation: "+ elevation;
	}
	
	// implement on the timer for GUI, so it becomes more easier to see the outcome.
	

}
