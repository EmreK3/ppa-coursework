package preliminaries.simulator;

import java.awt.event.*;

import preliminaries.controller.Controller;
import preliminaries.model.Aeroplane;
import preliminaries.view.GUI;

/*
 * directory.
 */

//This is our flight simulator class, where the calculations for the simulation will take place.
public class FlightSimulator implements ActionListener{
	
	//Here we have created our plane object that will be controlled within this simulation.
	private static Aeroplane aeroplane = new Aeroplane(5, 0, 0, 0); //changed
	private static Controller controller = new Controller(aeroplane);
	
	//Below are the local variables we will use 
	private static int runway;
	private static int seconds; // changed to static
	private static GUI simulator = new GUI(aeroplane, controller);
	private static int elevation;
	static int runUP;

		//Below is our main method of this program, this is where the program will be executed from.
	public static void main(String[] args) {
		System.out.println("Adding the MVC functionality to this program was hard due to the fact");
		System.out.println("that the program was already quite tightly-coupled, this meant that providing total");
		System.out.println("seperation between the model and the view to the point that the model cannot access the view was a challange.");
		System.out.println("I implemented a Controller class that was meant to handle the ChangeListeners for the JSliders, and");
		System.out.println("I treated the class Aeroplane.java as the Model as this class held all the information about");
		System.out.println("The aeroplane, information that the GUI could act upon with the use of a Controller");
		System.out.println("-----");
		System.out.println("We understand fully the benefits of adhereing to the MVC paradigm, as we saw in the preliminaries and actual");
		System.out.println("assignment, we are able to create a more loosly coupled program where you are able to change certain aspects (like the gui)");
		System.out.println("and not render a couple other classes unsuable while doing so.");
		String fulloutput = "";

			//This is the while loop that will assess the status of the plane every second, this will determine the changes that are made on the plane. 
		while(aeroplane.inFlight () == false){
			
			//These variables allow the program to increase in seconds.
			//This also allows us to set the Y value of the plane object.
			runway = simulator.getSpeedValue();
			aeroplane.setY(runway);
			seconds++;
			
				//This is the if statement that checks if the plane has reached the end of the runway.
				if(aeroplane.getY() > 110){
					  
					  simulator.setOutputText(fulloutput + "Plane did not take off, reached end of runway");
					  break;
					}
				
				//This if statement  will run if the plane is still on the runway.
			else if (aeroplane.getSpeed() >= 0){
				
				//This then checks the spped of the plane to check if elevation should be started.
				if ( aeroplane.getSpeed() == 10){
					/**
				 	* sets the value of runUP and elevation in this class
				 	*/
					
					
						runUP++;
						if (runUP > 5){
							
							elevation ++;
						}
							
						/**
						 * sets the actual elevation to the aeroplane.
						 */
			
					aeroplane.setElevation(elevation);
					
					//if the planes speed is not equal to 10, then the elevation of the plane will be changed within one of the if statements below.
				}else{
					//If the elevation is not equal to 0 but the speed is not 10, then the elevation of the plane will decrease.
					if(elevation!=0){
						aeroplane.setElevation(elevation--);
						setRunUP(runUP--);
					}
					//If the planes elevation reaches 0 then a warning will be shown.
					else{
						aeroplane.setElevation(0);
						simulator.setOutputText(fulloutput +"PLane speed at 0, increase speed");
						
					}
				
				}
				
				//If the plane does achieve the correct elevation and speed, but is not in the centre of the runway, then the takeoff will fail.
				if(elevation > 5 && aeroplane.getX()!=5){
					  simulator.setOutputText(fulloutput +"Take off failed, plane not in the center of the runway!");
					  break;
				  }
				
				//If the plane reaches the end of the runway then the take off will also fail.
				if(aeroplane.getY() > 110){
				  
				  simulator.setOutputText(fulloutput + "Plane did not take off, reached end of runway");
				  break;
				}
			
				//If the plane has achieved the correct speed, elevation and x position.
				//Then a sucessful take off will be shown.
				if(elevation > 5 && aeroplane.getX()==5){
				
				  simulator.setOutputText(fulloutput +"Plane successfully took off!!");
				  
				  break;
				  }
				

			  }
			/**
			
			
			 * copies the toString output from aeroplane.
			 */
			
			fulloutput += "Seconds: " + seconds + "\n" + aeroplane.toString() + "\n";	
			
			/**
			 * 
			 */
		
			
			// this below is the "timer" which is meant to delay the program for 1 sec every time it outputs the result
			  try { 
				  Thread.sleep(1000); }
			  catch (InterruptedException e) {
			  
			  }
			  
			  
			  simulator.setOutputText(fulloutput);
			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//This method returns how many seconds the plane has ran with a speed of 10.
	public int retrunUP(){

		return runUP;
	}

	/**
	 * sets the runUP value
	 * @param runUP
	 */
	public static void setRunUP(int runUPtime){
		runUPtime = runUP;
		
	}

}
