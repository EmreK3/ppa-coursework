package assignment.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import assignment.model.Model;

public class Controller implements ActionListener {
	
	private Model model;

	
	public Controller(Model model) {
		this.model = model;
	}
	
	/**
	 * actionPerformed method that listens to the buttons
	 * in the view and acts accordingly to which button is pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton source = (JButton)e.getSource();
		String buttonName = source.getName();
		System.out.println(buttonName);
		
		if("jbLeftBoat".equals(buttonName) ) {
			model.transferFromEastToWest();
		}else if("jbRightBoat".equals(buttonName)) {
			model.transferFromWestToEast();
		}
		
		if("jbLeftFox".equals(buttonName)) {
			if (model.checkInEastArray("fox") == true && model.checkInCentreRightArray("boat") == true && (model.getRightCenter().size() < 3) ) {			
				model.removeFromEast("fox");
				model.addToRightCenter("fox");	
			} else if (model.checkInCentreLeftArray("fox") == true ){					
				model.removeFromLeftCenter("fox");
				model.addToWest("fox");
			}
		} else if("jbRightFox".equals(buttonName)) {	
			if (model.checkInWestArray("fox") == true && model.checkInCentreLeftArray("boat") == true && (model.getRightCenter().size() < 3) ){	
				model.removeFromWest("fox");
				model.addToLeftCenter("fox");				
			} else if (model.checkInCentreRightArray("fox") == true ){				
				model.removeFromRightCenter("fox");
				model.addToEast("fox");				
			}			
		}
		
		if("jbLeftGoose".equals(buttonName)) {
			if (model.checkInEastArray("goose") == true && model.checkInCentreRightArray("boat") == true && (model.getRightCenter().size() < 3)){	
				model.removeFromEast("goose");
				model.addToRightCenter("goose");		
			} else if (model.checkInCentreLeftArray("goose") == true ){				
				model.removeFromLeftCenter("goose");
				model.addToWest("goose");			
			}
		} else if("jbRightGoose".equals(buttonName)) {		
			if (model.checkInWestArray("goose") == true && model.checkInCentreLeftArray("boat") == true && (model.getRightCenter().size() < 3)){		
				model.removeFromWest("goose");
				model.addToLeftCenter("goose");	
			} else if (model.checkInCentreRightArray("goose") == true ){	
				model.removeFromRightCenter("goose");
				model.addToEast("goose");	
			}
		}
		
		if("jbLeftBeans".equals(buttonName)) {					
			if (model.checkInEastArray("bagofbeans") == true && model.checkInCentreRightArray("boat") == true && (model.getRightCenter().size() < 3)){					
				model.removeFromEast("bagofbeans");
				model.addToRightCenter("bagofbeans");					
			} else if (model.checkInCentreLeftArray("bagofbeans") == true ){					
				model.removeFromLeftCenter("bagofbeans");
				model.addToWest("bagofbeans");					
			}			
		} else if("jbRightBeans".equals(buttonName)) {			
			if (model.checkInWestArray("bagofbeans") == true && model.checkInCentreLeftArray("boat") == true && (model.getRightCenter().size() < 3)){				
				model.removeFromWest("bagofbeans");
				model.addToLeftCenter("bagofbeans");				
			} else if (model.checkInCentreRightArray("bagofbeans") == true ){				
				model.removeFromRightCenter("bagofbeans");
				model.addToEast("bagofbeans");				
			}			
		}
		
		if("jbLeftFarmer".equals(buttonName)) {					
			if (model.checkInEastArray("farmer") == true && model.checkInCentreRightArray("boat") == true && (model.getRightCenter().size() < 3)){	
				model.removeFromEast("farmer");
				model.addToRightCenter("farmer");
			}else if (model.checkInCentreLeftArray("farmer") == true ){
				model.removeFromLeftCenter("farmer");
				model.addToWest("farmer");	
			}
		} else if("jbRightFarmer".equals(buttonName)) {	
			if (model.checkInWestArray("farmer") == true && model.checkInCentreLeftArray("boat") == true ){				
				model.removeFromWest("farmer");
				model.addToLeftCenter("farmer");
			} else if (model.checkInCentreRightArray("farmer") == true ){				
				model.removeFromRightCenter("farmer");
				model.addToEast("farmer");		
			}
		}
	}
}
