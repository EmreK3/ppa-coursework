/**
 * 
 */
package assignment.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import assignment.controller.AddController;
import assignment.controller.DeleteController;
import assignment.model.Model;

/**
 * @author k1630997
 * @author k1631364
 *
 */

@SuppressWarnings("serial")
public class View extends JFrame implements Observer {
	
	private static JTextField jtfInput;
	
	private JList<String> jlCalendar;
	private JList<String> jlReminder;
	
	public View(AddController addController, DeleteController deleteController) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Widgets(addController, deleteController);
		addController.setView(this);
		deleteController.setView(this);
	}
	
	public void Widgets(AddController controller, DeleteController deleteController) {
		setPreferredSize(new Dimension(900, 450));
		JPanel jpMain = new JPanel();
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		jlCalendar = new JList<String>(new DefaultListModel<String>());

		jlCalendar.addMouseListener(deleteController);
		JScrollPane calendarScroll = new JScrollPane(jlCalendar);
		
		jlReminder = new JList<String>(new DefaultListModel<String>());
		jlReminder.addMouseListener(deleteController);
		JScrollPane reminderScroll = new JScrollPane(jlReminder);
		
		jlCalendar.setName("calendar");
		jlReminder.setName("reminder");
		
		jtfInput = new JTextField();
		jtfInput.addActionListener(controller);
		
		tabbedPane.addTab("Calendar", null, calendarScroll);
		tabbedPane.addTab("Reminder", null, reminderScroll);
		
		jpMain.setLayout(new BorderLayout());
		jpMain.add(tabbedPane, BorderLayout.CENTER);
		jpMain.add(jtfInput, BorderLayout.SOUTH);
		add(jpMain);
		pack();
		
		setVisible(true);
	}
	
	public static String getNaturalText() {
		return jtfInput.getText();
	}
	
	public JList<String> getJlCalendar() {
		return jlCalendar;
	}
	
	public JList<String> getJlReminder() {
		return jlReminder;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Model model = (Model)o;
		
		if (model.getReminder()) {
			((DefaultListModel)jlReminder.getModel()).addElement(model.getDisplayReminder());
		} else {
			((DefaultListModel)jlCalendar.getModel()).addElement(model.getDisplayEvent());
			System.out.println(model.getDisplayEvent());
		}
		/**
		if (model.getDeleteFrom() != null) {
			((DefaultListModel) model.getDeleteFrom().getModel()).remove(model.getIndexOfEvent());
		}
		*/
	}
}
