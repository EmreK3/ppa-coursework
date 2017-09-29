package assignment.game;

import assignment.controller.Controller;
import assignment.model.Model;
import assignment.view.View;

public class Game {
	public static void main(String[] args) {

		Model model = new Model();
		Controller controller = new Controller(model);
		View gui = new View(controller, model);
		
		model.addObserver(gui);
	}
}
