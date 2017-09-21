public class Product {
	private String name;
	private int price;
	
	/**
	 * Constructor that sets the name
	 * and price of a certain product
	 */
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	/**
	 * toString method which is called when I print an 
	 * object of type Product
	 */
	
	public String toString() {
		return "Product[" + "name=" + name + "," + "price=" + price + "]"; 
	}
	
	// Two getters that allow me to access name and price.
	
	public String getName() {
		return name;
	}
	
	public int getPrice () {
		return price;
	}
}
