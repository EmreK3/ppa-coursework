package simulation;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultCaret;

public class Simulator extends JFrame implements ChangeListener, ActionListener {
	
	private static Runway runway = new Runway();
	private static JTextArea output = new JTextArea();
	private static JSlider xposition = new JSlider(JSlider.HORIZONTAL, 0, runway.getWidth(), 5);
	private static JSlider speed = new JSlider(JSlider.VERTICAL, 0, 10, 0);
	
	public static void main(String[] args) {
		new Simulator().setVisible(true);
		startSimulation();
	}
	
	public Simulator() {
		super("Simulator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		widgets();
	}
	
	/**
	 * Method that starts the simulation, updates the JTextArea
	 * according to the values on the sliders and the constraints
	 * involved (example: speed needs to be 10 for the elevation
	 * to increase)
	 */
	
	public static void startSimulation() {
		// Create plane object
		Plane plane = new Plane(output);
		int elevationCount = 0;
		
		// Add ChangeListeners to the two sliders
		
		xposition.setName("xposition");
		xposition.addChangeListener(plane);
		
		speed.setName("speed");
		speed.addChangeListener(plane);
		
		/*
		 *  While loop that continues to loop as long as the plane's y+speed 
		 *  is less than the runway's length, and that the boolean getFlightStatus
		 *  is false
		 */
		
		while((plane.getY() + plane.getSpeed()) <= runway.getLength() && !plane.getFlightStatus()) {
			
			plane.updatePosition();
			
			/*
			 * Nested if statements that check the speed, elevation and x coordinate
			 * and acts accordingly (i.e if speed is 10 then increase elevation count 
			 * by one
			 */
			
			if(plane.getSpeed() == 10) {
				elevationCount += 1;
				if(elevationCount >= 5) {
					plane.updatePositiveElevation();
					if(plane.getElevation() == 5 && plane.getX() == 5) {
						plane.setFlightStatus(true);
					}
				}
			} else {
				plane.updateNegativeElevation();
			}
			
			output.setText(output.getText() + "Seconds: " + runway.getSeconds() + "\n");
			output.setText(output.getText() + "X: " + plane.getX() + " Y: " + plane.getY() + " Speed: " + plane.getSpeed() + " Elevation: " + plane.getElevation() + "\n");
			
			try{
				Thread.sleep(1000);
			} catch(InterruptedException e){}
			
			runway.incrementSeconds();
			
		}
		
		if(plane.getFlightStatus()) {
			output.setText(output.getText() + "Plane in air.");
		} else {
			output.setText(output.getText() + "Takeoff failed.");
		}
	}
	
	/**
	 * Class that holds the widgets for the main GUI
	 * (button, two sliders, text area)
	 */
	
	public void widgets() {
		
		// Styling for the text area
		output.setWrapStyleWord(true);
		DefaultCaret caret = (DefaultCaret)output.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		// ScrollPane for when the text is too long for the JTextArea
		JScrollPane scrollPane = new JScrollPane(output);
		scrollPane.setViewportView(output);
		
		// Reset button
		JButton reset = new JButton("Reset");
		
		/*class ResetListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				output.setText("");
				//startSimulation();
			}
			
		}
		
		reset.addActionListener(new ResetListener());
		*/
		
		// Main panel that uses the layout manager GridLayout
		
		JPanel main = new JPanel(new GridLayout(2,1));
		this.add(main);
		
		// Text panel that uses the layout manager BorderLayout
		
		JPanel text = new JPanel(new BorderLayout());
		text.add(scrollPane, BorderLayout.CENTER);
		main.add(text);
		
		// Controls panel that uses the layout manager BorderLayout
		
		JPanel controls = new JPanel(new BorderLayout());
		controls.add(xposition, BorderLayout.NORTH);
		controls.add(speed, BorderLayout.CENTER);
		controls.add(reset, BorderLayout.SOUTH);
		main.add(controls);
		
		this.pack();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
