package assignment.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import assignment.controller.Controller;
import assignment.model.Model;

public class View extends JFrame implements Observer {
	
	private static final long serialVersionUID = 1L;
	private Model model;
	
	private JLabel boat;
	private JLabel fox;
	private JLabel goose;
	private JLabel bagofbeans;
	private JLabel farmer;
	
	private JButton jbLeftBoat;
	private JButton jbRightBoat;
	private JButton jbLeftFox;
	private JButton jbRightFox;
	private JButton jbLeftGoose;
	private JButton jbRightGoose;
	private JButton jbLeftBeans;
	private JButton jbRightBeans;
	private JButton jbLeftFarmer;
	private JButton jbRightFarmer;
	
	private ArrayList<JLabel> items = new ArrayList<JLabel>();
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	
	/**
	 * ImagePanel class
	 */
	class ImagePanel extends JPanel {

		private static final long serialVersionUID = 1L;
		
		private Image img;

		public ImagePanel(Image img) {
		    this.img = img;
		    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		    setPreferredSize(size);
		    setMinimumSize(size);
		    setMaximumSize(size);
		    setSize(size);
		    setLayout(null);
		  }

		  public void paintComponent(Graphics g) {
			  g.drawImage(img, 0, 0, null);
		  }

	}
	
	// Create the Panels for the three sections of the game
	
	private ImagePanel jpWest = new ImagePanel(new ImageIcon("src/assignment/images/grass.png").getImage());
	private ImagePanel jpCenter = new ImagePanel(new ImageIcon("src/assignment/images/water.png").getImage());
	private ImagePanel jpEast = new ImagePanel(new ImageIcon("src/assignment/images/grass.png").getImage());
	
	
	public View(Controller controller, Model model) {
		
		//Here i set the title of the Application to be determined the by the logic calculated in the model class
		super(model.checkGameDisplay());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.model = model;
		widgets(controller);
	}
	
	/**
	 * Main class that sets all the widgets of the main application.
	 * @param controller
	 */
	public void widgets(Controller controller) {
		setLayout(new BorderLayout());
		setSize(1280, 720);
		
		// Create Labels and their corresponding buttons
		JLabel jlBoatTag = new JLabel("Boat:");
		jbLeftBoat = new JButton("<");
		jbRightBoat = new JButton(">");
		
		JLabel jlFoxTag = new JLabel("Fox:");
		jbLeftFox = new JButton("<");
		jbRightFox = new JButton(">");
		
		JLabel jlGooseTag = new JLabel("Goose:");
		jbLeftGoose = new JButton("<");
		jbRightGoose = new JButton(">");
		
		JLabel jlBeanTag = new JLabel("Beans:");
		jbLeftBeans = new JButton("<");
		jbRightBeans = new JButton(">");
		
		JLabel jlFarmerTag = new JLabel("Farmer:");
		jbLeftFarmer = new JButton("<");
		jbRightFarmer = new JButton(">");
		
		// Add the buttons to ArrayList buttons
		buttons.add(jbLeftBoat);
		buttons.add(jbRightBoat);
		buttons.add(jbLeftFox);
		buttons.add(jbRightFox);
		buttons.add(jbLeftGoose);
		buttons.add(jbRightGoose);
		buttons.add(jbLeftBeans);
		buttons.add(jbRightBeans);
		buttons.add(jbLeftFarmer);
		buttons.add(jbRightFarmer);
		
		// Give the buttons names so we can unique identify them in the ActionListeners
		jbLeftBoat.setName("jbLeftBoat");
		jbRightBoat.setName("jbRightBoat");
		jbLeftFox.setName("jbLeftFox");
		jbRightFox.setName("jbRightFox");
		jbLeftGoose.setName("jbLeftGoose");
		jbRightGoose.setName("jbRightGoose");
		jbLeftBeans.setName("jbLeftBeans");
		jbRightBeans.setName("jbRightBeans");
		jbLeftFarmer.setName("jbLeftFarmer");
		jbRightFarmer.setName("jbRightFarmer");
		
		
		JPanel jpSouth = new JPanel(); // Create the panel for all the buttons
		
		// Add all the buttons and labels to the south panel
		jpSouth.add(jlBoatTag);
		jpSouth.add(jbLeftBoat);
		jpSouth.add(jbRightBoat);
		
		jpSouth.add(jlFoxTag);
		jpSouth.add(jbLeftFox);
		jpSouth.add(jbRightFox);
		
		jpSouth.add(jlGooseTag);
		jpSouth.add(jbLeftGoose);
		jpSouth.add(jbRightGoose);
		
		jpSouth.add(jlBeanTag);
		jpSouth.add(jbLeftBeans);
		jpSouth.add(jbRightBeans);
		
		jpSouth.add(jlFarmerTag);
		jpSouth.add(jbLeftFarmer);
		jpSouth.add(jbRightFarmer);
		
		// Give the JLabels icons
		ImageIcon foxIcon = new ImageIcon("src/assignment/images/fox.png");
		ImageIcon gooseIcon = new ImageIcon("src/assignment/images/goose.png");
		ImageIcon beansIcon = new ImageIcon("src/assignment/images/beans.png");
		ImageIcon farmerIcon = new ImageIcon("src/assignment/images/farmer.png");
		ImageIcon boatIcon = new ImageIcon("src/assignment/images/boat.png");
		
		// Set names for the items so they can be uniquely referenced in the actionlisteners
		boat = new JLabel();
		boat.setName("boat");
		boat.setVerticalAlignment(JLabel.TOP);
		boat.setHorizontalAlignment(JLabel.RIGHT);
		
		fox = new JLabel();
		fox.setName("fox");
		fox.setHorizontalAlignment(JLabel.CENTER);
		
		bagofbeans = new JLabel();
		bagofbeans.setName("bagofbeans");
		bagofbeans.setHorizontalAlignment(JLabel.CENTER);
		
		goose = new JLabel();
		goose.setName("goose");
		goose.setHorizontalAlignment(JLabel.CENTER);
		
		farmer = new JLabel();
		farmer.setName("farmer");
		farmer.setHorizontalAlignment(JLabel.CENTER);
		
		// Add all the characters to the items ArrayList
		
		items.add(boat);
		items.add(fox);
		items.add(bagofbeans);
		items.add(goose);
		items.add(farmer);
		
		boat.setIcon(boatIcon);
		fox.setIcon(foxIcon);
		bagofbeans.setIcon(beansIcon);
		goose.setIcon(gooseIcon);
		farmer.setIcon(farmerIcon);
		
		// Add the Icons to the relevant JPanels
		jpEast.setLayout(new GridLayout(4,0));
		jpWest.setLayout(new GridLayout(4,0));
		jpCenter.setLayout(new BorderLayout());
		
		//System.out.println(jpEast.getComponentCount());
		jpEast.add(fox);
		jpEast.add(goose);
		jpEast.add(bagofbeans);
		jpEast.add(farmer);
		
		jpCenter.add(boat);
		
		// Add the ActionListener to the buttons
		jbLeftBoat.addActionListener(controller);
		jbRightBoat.addActionListener(controller);
		jbLeftFox.addActionListener(controller);
		jbRightFox.addActionListener(controller);
		jbLeftGoose.addActionListener(controller);
		jbRightGoose.addActionListener(controller);
		jbLeftBeans.addActionListener(controller);
		jbRightBeans.addActionListener(controller);
		jbLeftFarmer.addActionListener(controller);
		jbRightFarmer.addActionListener(controller);
		
		// Create a main display and add each section to it
		JPanel jpMainDisplay = new JPanel();
		
		jpMainDisplay.setLayout(new BorderLayout());
		
		jpMainDisplay.add(jpWest, BorderLayout.WEST);
		jpMainDisplay.add(jpCenter, BorderLayout.CENTER);
		jpMainDisplay.add(jpEast, BorderLayout.EAST);
		
		// Add the button section and main display to the frame
		add(jpSouth, BorderLayout.SOUTH);
		add(jpMainDisplay, BorderLayout.CENTER);
		
		setVisible(true);
		setResizable(false);
	}
	
	/**
	 * This method updates the gui by comparing the ArrayList's for each section
	 * in the Model to the JLabels that exist in this class.
	 * For example: if a JLabel is found in the ArrayList east, then that JLabel
	 * is added to the east panel (jpEast).
	 * This is done for each panel.
	 */
	public void updateGUI() {
			jpEast.removeAll();
			jpCenter.removeAll();
			jpWest.removeAll();
			
			for(int i = 0 ; i < items.size(); i++) {
				for(int j = 0; j < model.getEast().size(); j++) {
					if(items.get(i).getName().equals(model.getEast().get(j))) {
						jpEast.add(items.get(i));
						items.get(i).setHorizontalAlignment(JLabel.CENTER);
					}
				}
			}
		
			for(int i = 0 ; i < items.size(); i++) {
				for(int j = 0; j < model.getWest().size(); j++) {
					if(items.get(i).getName().equals(model.getWest().get(j))) {
						jpWest.add(items.get(i));
						items.get(i).setHorizontalAlignment(JLabel.CENTER);
					}
				}
			}

			for(int i = 0 ; i < items.size(); i++) {
				for(int j = 0; j < model.getRightCenter().size(); j++) {
					if(items.get(i).getName().equals(model.getRightCenter().get(j))) {
						jpCenter.add(items.get(i), BorderLayout.EAST);
						items.get(i).setHorizontalAlignment(JLabel.RIGHT);
						if(items.get(i) != boat) {
							items.get(i).setVerticalAlignment(JLabel.TOP);
						}
					}
				}
			}
			
			for(int i = 0 ; i < items.size(); i++) {
				for(int j = 0; j < model.getLeftCenter().size(); j++) {
					if(items.get(i).getName().equals(model.getLeftCenter().get(j))) {
						jpCenter.add(items.get(i));
						items.get(i).setHorizontalAlignment(JLabel.LEFT);
						if(items.get(i) != boat) {
							items.get(i).setVerticalAlignment(JLabel.TOP);
						}
					}
				}
			}
			
			jpWest.repaint();
			jpCenter.repaint();
			jpEast.repaint();
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		 EventQueue.invokeLater(new Runnable(){
			  public void run()
			  { 
					updateGUI();
				  	System.out.println(model.getLeftCenter());
				  	System.out.println(model.getRightCenter());
					if(model.isGameFinished()) {
						setTitle(model.checkGameDisplay());
						for(int i = 0; i < buttons.size(); i++) {
							buttons.get(i).setEnabled(false);
						}
					}
			  }
			 });
	}
	
	
}
