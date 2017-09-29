package preliminaries.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import preliminaries.model.Aeroplane;
import preliminaries.view.GUI;

public class Controller implements ChangeListener {
	
	private Aeroplane aeroplane;
	public Controller(Aeroplane aeroplane) {
		this.aeroplane = aeroplane;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
				// 1. get Int values from the Slider.
				//int xValue = aeroplane.ge.getValue();

				// 2. set this xValue in the Aeroplane object.
				//aeroplanetocontrol.setX(xValue);

	}
}
