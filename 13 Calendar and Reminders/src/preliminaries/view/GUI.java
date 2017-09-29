package preliminaries.view;


import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.DefaultCaret;

import preliminaries.controller.Controller;
import preliminaries.model.Aeroplane;
import preliminaries.simulator.FlightSimulator;

import java.util.Hashtable;

/*
 * directory.
 */
public class GUI extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame myFrame = new JFrame("Flight Simulator");
	JButton jbreset = new JButton("Reset");
	JTextArea jlOutput = new JTextArea();
	DefaultCaret caret = (DefaultCaret)jlOutput.getCaret();
	JScrollPane jspOutput = new JScrollPane(jlOutput);
	JPanel jpSouth = new JPanel();

	
	
	// Set up plane parameters.
	private static final int xpos_MIN = 0;
	private static final int xpos_MAX = 10;
	private static final int xpos_INIT = 5; // initial x position

	private static final int speed_MIN = 0;
	private static final int speed_MAX = 10;


	boolean frozen = false;

	static FlightSimulator flightSimulator = new FlightSimulator();

	
	// Create the x position slider.
	private JSlider xposition = new JSlider(JSlider.HORIZONTAL, xpos_MIN, xpos_MAX, xpos_INIT);
	// Create the speed slider.
	private JSlider speed = new JSlider(JSlider.VERTICAL, speed_MIN, speed_MAX, speed_MIN);

	

	public JSlider getXposition() {
		return xposition;
	}

	public JSlider getSpeed() {
		return speed;
	}

	public GUI(Aeroplane aeroplanetocontrol, Controller controller) {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		myFrame.setSize(500, 700);
		myFrame.setLayout(new GridLayout(2, 1));
		
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		

		
		
		// first at the aeroplane x value.
		aeroplanetocontrol.setX(xpos_INIT);
		// Create the label table for the xposition table.
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put(new Integer(0), new JLabel("WEST"));
		labelTable.put(new Integer(xpos_MAX / 2), new JLabel("CENTRE"));
		labelTable.put(new Integer(xpos_MAX), new JLabel("EAST"));
		xposition.setLabelTable(labelTable);
		xposition.setPaintLabels(true);
		xposition.setMajorTickSpacing(1);
		xposition.setPaintTicks(true);
		xposition.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		// potential change of the slider size

		xposition.addChangeListener(controller);

		
		
		// Create the label table for the speed slider.
		Hashtable<Integer, JLabel> labelTable2 = new Hashtable<Integer, JLabel>();
		labelTable2.put(new Integer(0), new JLabel("SLOW"));
		labelTable2.put(new Integer(speed_MAX / 2), new JLabel("AVERAGE"));
		labelTable2.put(new Integer(speed_MAX), new JLabel("FAST"));
		speed.setLabelTable(labelTable2);
		speed.setPaintLabels(true);
		speed.setMajorTickSpacing(2);
		speed.setPaintTicks(true);

		class yChangeListener implements ChangeListener {

			@Override
			public void stateChanged(ChangeEvent e) {
				// 1. get Int values from the Slider.
				int speedValue = speed.getValue();

				// 2. set this xValue in the Aeroplane object.
				aeroplanetocontrol.setSpeed(speedValue);

			}
		}

		speed.addChangeListener(new yChangeListener());
		

		
		jlOutput.setAlignmentX(TOP_ALIGNMENT);
		jlOutput.setAlignmentY(TOP_ALIGNMENT);
		
		jspOutput.setAlignmentX(JScrollPane.LEFT_ALIGNMENT);
		jspOutput.setAlignmentY(JScrollPane.TOP_ALIGNMENT);
		jspOutput.setSize(700, 400);

	
		// make the textArea uneditable.
		jlOutput.setEditable(false);

		
		myFrame.add(jspOutput);
		myFrame.add(jpSouth);

		// Put everything together.
		jpSouth.setLayout(new BorderLayout());
		jpSouth.add(xposition, BorderLayout.NORTH);
		jpSouth.add(speed, BorderLayout.CENTER);
		jpSouth.add(jbreset, BorderLayout.SOUTH);
	 	
		myFrame.setVisible(true);
		myFrame.setResizable(false);
		
		
	}
	
	//  returns the value of the x slider.
	public int getXValue(){
		
		return xposition.getValue();
	}
	
	//  returns the value of the speed slider.
	public int getSpeedValue(){
		
		return speed.getValue();
	}

	//  Allows us to set the message to show on screen.
	public void setOutputText(String stringtoadd) {
		
		jlOutput.setText(stringtoadd);
		
	}
	
}
