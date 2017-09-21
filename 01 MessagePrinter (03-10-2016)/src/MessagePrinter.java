public class MessagePrinter {

	public static void main(String[] args) {
		/* 
		Makes a copy of all the code in the Messages class and
		stores it inside a variable; the program can
		interact with the copied code to call methods within
		that code.
		*/
		Messages useClass = new Messages();
		/*
		Call the relevant methods using the variable that holds
		the new copy
		*/
		useClass.namePrinter();
		useClass.wordPrinter();
		useClass.incrementPrinter(8);

	}
	
}
