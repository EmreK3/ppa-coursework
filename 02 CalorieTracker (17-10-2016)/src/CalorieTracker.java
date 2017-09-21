public class CalorieTracker {
	public static void main(String[] args) {
		Person emreK = new Person(); // creates a copy of the Person class and assigns to 'emreK'
		emreK.getTotalCalories(); // dot notation is used to call a method from the class

		Meal mealCalculator = new Meal(); // creates a copy of the Meal class and assigns to 'mealCalculator'

		mealCalculator.calculateCalories("Omelette Breakfast", 60, 300, 105);
		emreK.eatMeal(mealCalculator.getTotalMealCalories());
		mealCalculator.getMeal();
		emreK.getTotalCalories();

		mealCalculator.calculateCalories("Chow Mein Dinner", 260, 605, 135);
		emreK.eatMeal(mealCalculator.getTotalMealCalories());
		mealCalculator.getMeal();
		emreK.getTotalCalories();

		mealCalculator.calculateCalories("Halloumi Lunch", 130, 780, 350);
		emreK.eatMeal(mealCalculator.getTotalMealCalories());
		mealCalculator.getMeal();
		emreK.getTotalCalories();

		emreK.goWalk(725);
	}
}