import java.util.ArrayList; // import ArrayList library

public class Customer {
	private String name;
	private ArrayList<Product> shoppingBasket;
	private ArrayList<Product> ownedProducts;
	private ArrayList<GoldCoin> purse;
	private int totalPrice;
	
	/**
	 * Constructor that sets the name of the Customer.
	 * It also initialises the three ArrayLists.
	 */
	
	public Customer(String name) {
		this.name = name;
		shoppingBasket = new ArrayList<Product>();
		ownedProducts = new ArrayList<Product>();
		purse = new ArrayList<GoldCoin>();
	}
	
	/**
	 * toString method which is called when I print an 
	 * object of type Product
	 */
	
	public String toString() {
		return "Customer[name=" + name + ",total coins in purse=" + purse.size() + "]";
	}
	
	/**
	 * Removes a suppliedProduct from the shopping basket
	 * by checking if the basket contains the said item.
	 */
	
	public boolean removeFromShoppingBasket(Product suppliedProduct) {
		boolean containsAndRemoved = false;
		if(shoppingBasket.contains(suppliedProduct)) {
			shoppingBasket.remove(suppliedProduct);
			containsAndRemoved = true;
		}
		return containsAndRemoved;
	}
	
	/**
	 * Searches the shoppingBasket using a for-loop. Iterates through
	 * each item and checks if the corresponding items name matches
	 * the suppliedProduct
	 */
	
	public Product searchShoppingBasket(String suppliedProduct) {
		Product foundProduct = null;
		for(int i = 0; i < shoppingBasket.size(); i++) {
			if(shoppingBasket.get(i).getName().equals(suppliedProduct)) {
				foundProduct = shoppingBasket.get(i);
			}
		}
		return foundProduct;
	}
	
	/**
	 * Method takes two parameters, iterates through the shopping basket
	 * and finds the totalPrice for the items. Checks if the customer
	 * has enough coins to purchase the items. If the customer has enough 
	 * money; GoldCoins are transferred one by one from the customer's purse
	 * to the Shop's coinBox. Then the shopping basket is cleared.
	 */
	
	public boolean purchaseProducts(Customer customer, Shop shop) {
		boolean transaction = false;
		
		for(int i = 0; i < shoppingBasket.size(); i++) {
			int price = shoppingBasket.get(i).getPrice();
			totalPrice += price;
		}
		
		if(totalPrice > purse.size()) {
			transaction = false;
			System.out.println("You do not have enough coins! You need " + (totalPrice - purse.size()) + " more.");
		} else {
			// for loop that transfers money from purse to coinBox
			for(int x = 0; x < totalPrice; x++) {
				shop.addGoldCoin(purse.get(purse.size() - 1));
				purse.remove(purse.size() - 1);
			}
			// for loop that transfers products from shoppingBasket to ownedProducts
			for(int y = 0; y < shoppingBasket.size(); y++) {
				addOwnedProducts(shoppingBasket.get(y));
			}
			
			// clears shoppingBasket
			shoppingBasket.clear();
			// updates Customer's running total spend
			shop.updateTotalSpend(customer, totalPrice);
			System.out.println("Item(s) purchased!");
			transaction = true;
		}
		return transaction;
	}
	
	// Adds a suppliedProduct to the shopping basket.
	
	public void addToShoppingBasket(Product suppliedProduct) {
		shoppingBasket.add(suppliedProduct);
	}
	
	// Adds a suppliedProduct to the ownedProducts ArrayList
	
	public void addOwnedProducts(Product suppliedProduct) {
		ownedProducts.add(suppliedProduct);
	}
	
	// Adds a suppliedCoin to the purse.
	
	public void addCoin(GoldCoin suppliedCoin) {
		purse.add(suppliedCoin);
	}
	
	// Four getters that allow me to access private variables from outside the class
	
	public ArrayList<Product> getOwnedProducts() {
		return ownedProducts;
	}
	
	public ArrayList<Product> getShoppingBasket() {
		return shoppingBasket;
	}
	
	public ArrayList<GoldCoin> getPurse() {
		return purse;
	}
	
	public String getName() {
		return name;
	}
}
