package simulation;

import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Plane implements ChangeListener {
	private int x,y,speed,elevation;
	private boolean takeOffSuccessful;
	
	public Plane(JTextArea output) {
		x = 5;
		y = 0;
		elevation = 0;
		speed = 0;
	}
	
	/**
	 * ChangeListener that gets the values from the
	 * two sliders and assigns them to the private variables
	 * x and speed.
	 */
	
	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider)e.getSource();
		if(!source.getValueIsAdjusting()) {
			String sliderName = source.getName();
			if("xposition".equals(sliderName)) {
				x = source.getValue();
			} else if("speed".equals(sliderName)) {
				speed = source.getValue();	
			}
		}
	}
	
	// Setter that sets the boolean takeOffSuccessful
	
	public void setFlightStatus(boolean takeOffSuccessful) {
		this.takeOffSuccessful = takeOffSuccessful;
	}
	
	// Method that increments elevation
	
	public void updatePositiveElevation() {
		elevation += 1;
	}
	
	// Method that reduces the elevation by one, only if the elevation is greater than 0
	
	public void updateNegativeElevation() {
		if(elevation > 0) {
			elevation -= 1;
		}
	}
	
	// Method that adds speed to the y
	
	public void updatePosition() {
		y += speed;
	}
	
	// Getters to access the private variables from outside the class
	
	public boolean getFlightStatus() {
		return takeOffSuccessful;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getElevation() {
		return elevation;
	}
}
