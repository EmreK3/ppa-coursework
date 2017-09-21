import java.util.Scanner; // import the Scanner class

public class ShoppingTrip {
	public static void main(String[] args) {
		
		// Creates objects of the products
		
		Product diamond = new Product("Diamond", 40);
		Product crownjewels = new Product("Crown Jewels", 100);
		Product silverlocket = new Product("Silver Locket", 60);
		
		// Creates the shop
		
		Shop hiddenhideway = new Shop("Hidden Hideway");
		
		// Fills the coinBox with 125 coins.
		
		for(int i = 0; i < 125; i++) {
			GoldCoin coin = new GoldCoin();
			hiddenhideway.addGoldCoin(coin);
		}
		
		// Adds the three products to the shop
		
		hiddenhideway.addProduct(diamond);
		hiddenhideway.addProduct(crownjewels);
		hiddenhideway.addProduct(silverlocket);
		
		System.out.println(hiddenhideway);
		
		// Creates the customer
		
		Customer blackbeard = new Customer("BlackBeard");
		
		// Fills the customer's purse with 100 coins 
		
		for(int i = 0; i < 100; i++) {
			GoldCoin coin = new GoldCoin();
			blackbeard.addCoin(coin);
		}
		
		System.out.println(blackbeard);
		
		String crowdControl = "--------------------------"; // xD
		
		System.out.println(crowdControl);
		//Introductory Message
		System.out.println("Welcome to the shop!");
		System.out.println(crowdControl);
		
		// Main message that presents options to the user
		String primaryMessage = "Type 'add product' to add a specific product to your basket, type 'remove product' to remove a specific product from your shopping basket. Or type 'purchase' to purchase all the items currently in your shopping basket. If you wish to leave, type 'exit'";
		System.out.println("Products currently in this store: " + hiddenhideway.getProducts());
		System.out.println("Products currently in your shopping basket: " + blackbeard.getShoppingBasket());
		System.out.println(blackbeard.getPurse().size() + " coins in your wallet.");
		System.out.println(crowdControl);
		System.out.println(primaryMessage);
		
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		
		// This block of code repeats until the userInput is "exit"
		
		while(!(userInput.equals("exit"))) {
			
			// if the user's input is something not expected, it will tell them that they entered an unknown command.
			
			if(!(userInput.equals("add product") || userInput.equals("remove product") || userInput.equals("purchase") || userInput.equals("exit"))) {
				System.out.println("Unknown command.");
				System.out.println(crowdControl);
				System.out.println("Products currently in this store: " + hiddenhideway.getProducts());
				System.out.println("Products currently in your shopping basket: " + blackbeard.getShoppingBasket());
				System.out.println(blackbeard.getPurse().size() + " coins in your wallet.");
				System.out.println(crowdControl);
				System.out.println(primaryMessage);
				userInput = input.nextLine();
			}
			
			// if the user entered 'add product' then this block of code will execute
			
			if(userInput.equals("add product")) {
				boolean added = false;
				System.out.println("Input name of product you wish to add to your shopping basket:");
				while(added == false) {
					userInput = input.nextLine();
				
					if(!(hiddenhideway.searchProduct(userInput) == null)) {
						Product requiredProduct = hiddenhideway.searchProduct(userInput);
						blackbeard.addToShoppingBasket(requiredProduct);
						hiddenhideway.removeProduct(requiredProduct);
						added = true;
						System.out.println("Product added to shopping basket");
					} else {
						System.out.println("Product not found! Try again.");
					}
					
					if(added == true) {
						System.out.println(crowdControl);
						System.out.println("Products currently in this store: " + hiddenhideway.getProducts());
						System.out.println("Products currently in your shopping basket: " + blackbeard.getShoppingBasket());
						System.out.println(blackbeard.getPurse().size() + " coins in your wallet.");
						System.out.println(crowdControl);
						System.out.println(primaryMessage);
						userInput = input.nextLine();
					}
				}
			}
			
			// if the user entered 'remove product' then this block of code will execute
			
			if(userInput.equals("remove product")) {
				if(!(blackbeard.getShoppingBasket().isEmpty())) {
					boolean removed = false;
					boolean unableToFind = false;
					System.out.println("Input name of product you wish to remove from your shopping basket:");
					
					
					while(removed == false || unableToFind == false) {
						userInput = input.nextLine();
		
						Product inList = blackbeard.searchShoppingBasket(userInput);
						
						if(!(inList == null)) {
							blackbeard.removeFromShoppingBasket(inList);
							hiddenhideway.addProduct(inList);
							
							if(!(blackbeard.getShoppingBasket().contains(inList))) {
								removed = true;
								System.out.println("Product removed from your shopping basket.");
								System.out.println(crowdControl);
								System.out.println("Your shopping basket is currently empty!");
								System.out.println("Products currently in this store: " + hiddenhideway.getProducts());
								System.out.println("Products currently in your shopping basket: " + blackbeard.getShoppingBasket());
								System.out.println(blackbeard.getPurse().size() + " coins in your wallet.");
								System.out.println(crowdControl);
							} else {
								unableToFind = true;
								System.out.println("Unable to find product");
								System.out.println("Try again:");
							}
						}
					}
				} else {
					System.out.println(crowdControl);
					System.out.println("Your shopping basket is currently empty!");
					System.out.println("Products currently in this store: " + hiddenhideway.getProducts());
					System.out.println("Products currently in your shopping basket: " + blackbeard.getShoppingBasket());
					System.out.println(blackbeard.getPurse().size() + " coins in your wallet.");
					System.out.println(crowdControl);
					System.out.println(primaryMessage);
					userInput = input.nextLine();
				}
			}
			
			// if the user entered 'purchase' then this block of code will execute
			
			if(userInput.equals("purchase")) {
				if(blackbeard.getShoppingBasket().isEmpty()) {
					System.out.println("Your shopping basket is currently empty!");
				} else {
					blackbeard.purchaseProducts(blackbeard, hiddenhideway);
				}
				System.out.println(crowdControl);
				System.out.println("Products currently in this store: " + hiddenhideway.getProducts());
				System.out.println("Products currently in your shopping basket: " + blackbeard.getShoppingBasket());
				System.out.println(blackbeard.getPurse().size() + " coins in your wallet.");
				System.out.println(crowdControl);
				System.out.println(primaryMessage);
				userInput = input.nextLine();
			}
		}
		
		// if the user entered 'exit' then this block of code will execute.
		
		if(userInput.equals("exit")) {
			System.out.println("Thank for you visiting this store.");
			input.close();
		}
	}
}
