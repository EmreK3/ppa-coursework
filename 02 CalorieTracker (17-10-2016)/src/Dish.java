public class Dish {
	private int starterDish; // private variables can only be accessed
	private int mainDish; // from the class that they're defined in.
	private int dessertDish;
	private int sumOfCalories;

	/**
	 * Takes three parameters, all of type int:
	 * uses 'this.' to assign the parameters to the private
	 * variables defined outside of the method.
	 */

	public void mealCals(int starterDish, int mainDish, int dessertDish) {
		this.starterDish = starterDish;
		this.mainDish = mainDish;
		this.dessertDish = dessertDish;
	}

	public int sumOfCals() {
		sumOfCalories = starterDish + mainDish + dessertDish; // sums the three variables and returns.
		return sumOfCalories;
	}

	public String createMeal(String mealName, int mealCalories) {
		return (mealName + ": there are " + mealCalories + " calories in this meal.");
	}
}