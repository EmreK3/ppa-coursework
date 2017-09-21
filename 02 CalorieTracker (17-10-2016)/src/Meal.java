public class Meal {
	private int totalMealCalories; // defines a variable with type int that will track total calories in a specific meal.
	private String name; // defines a variable with type String that will hold the meals name.
	Dish dishCalc = new Dish(); // creates a copy of the Dish class, assigns it to dishCalc

	/**
	 * Method has four parameters; one string and three integers. 
	 * This method uses the three integers to fill out the parameters 
	 * for the mealCals method in my Dish class.
	 * assings value of dishCalc.sumOfCals() totalMealCalories. 
	 * Using this.name = name; I'm able to assign the String
	 * to the private String outside of the method,
	 * Method then returns totalMealCalories.
	 */

	public int calculateCalories(String name, int starter, int main, int dessert) {
		dishCalc.mealCals(starter,main,dessert);
		totalMealCalories = dishCalc.sumOfCals();
		this.name = name; // assigns the parameter 'name', to the private variable 'name' that is outside the method.
		return totalMealCalories;
	}

	public int getTotalMealCalories() {
		return totalMealCalories; // this method simply returns the variable totalMealCalories.
	}
	
	/**
	 * Method assigns the result of dishCalc.createMeal(name, totalMealCalories);
	 * to the variable 'meal', before printing out the variable.
	 */
	
	public void getMeal() {
		String meal = dishCalc.createMeal(name, totalMealCalories);
		System.out.println(meal);
	}
}