public class Person {
	private int totalCalories; // private integer totalCalories, not set to any value so is 0 by default.

	public void eatMeal(int mealCalories) {
		totalCalories += mealCalories; // adds and assigns (totalCalories = totalCalories + mealCalories).
	}

	public void getTotalCalories() {
		System.out.println("Emre's current total calories: " + totalCalories);
	}

	public void goWalk(int mins) {
		totalCalories -= mins; // subtracts then assigns (totalCalories = totalCalories - minutes)
		System.out.println("Walk for " + mins + " minutes.");
	}
}