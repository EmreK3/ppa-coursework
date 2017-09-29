package assignment.main;

import assignment.controller.AddController;
import assignment.controller.DeleteController;
import assignment.model.Model;
import assignment.view.View;

public class App {
	public static void main(String[] args) {
		Model model = new Model();
		AddController addController =  new AddController(model);
		DeleteController deleteController = new DeleteController(model);
		//ListController listController = new ListController(model);
		View view = new View(addController, deleteController);
		model.addObserver(view);
	}
}
