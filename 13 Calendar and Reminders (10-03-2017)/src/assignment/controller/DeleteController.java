package assignment.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import assignment.model.Model;
import assignment.view.View;

public class DeleteController implements MouseListener {
	
	private View view;
	private Model model;
	
	public DeleteController(Model model) {
		this.model = model;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		JList deleteFrom = (JList)e.getSource();
		
		if(deleteFrom.getName().equals("calendar")) {
			if (e.getClickCount() == 2) {
				int index = deleteFrom.locationToIndex(e.getPoint());
				((DefaultListModel)view.getJlCalendar().getModel()).remove(index);
			}
		} else if(deleteFrom.getName().equals("reminder")) {
			if (e.getClickCount() == 2) {
				int index = deleteFrom.locationToIndex(e.getPoint());
				((DefaultListModel)view.getJlReminder().getModel()).remove(index);
			}
		}
	}
	
	public void setView(View view) {
		this.view = view;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
			
	}

	@Override
	public void mouseExited(MouseEvent e) {
	
	}

}
