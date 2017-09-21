import java.util.ArrayList;
import java.util.TreeMap;

public class Shop {
	private String name;
	private ArrayList<Product> products;
	private ArrayList<GoldCoin> coinBox;
	private TreeMap<String, Integer> customerTotalSpend;
	
	/**
	 * toString method which is called when I print an 
	 * object of type Shop
	 */
	
	public String toString() {
		return "Shop[name=" + name + ",number of gold coins=" + coinBox.size() + ",products in this store = " + products.toString() + "]";
	}
	
	/**
	 * Constructor that sets the name
	 * of the shop, also initialises the 
	 * ArrayLists and the TreeMap
	 */
	
	public Shop(String name) {
		this.name = name;
		products = new ArrayList<Product>();
		coinBox = new ArrayList<GoldCoin>();
		customerTotalSpend = new TreeMap<String, Integer>();
	}
	
	// Adds a suppliedProduct to the products ArrayList
	
	public void addProduct(Product suppliedProduct) {
		products.add(suppliedProduct);
	}
	
	/**
	 * For loop that iterates through each index of the products ArrayList,
	 * if an index contains the same name as the suppliedProduct, then this product
	 * is returned
	 */
	
	public Product searchProduct(String suppliedProduct) {
		Product containsProduct = null;
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getName().equals(suppliedProduct)) {
				containsProduct = products.get(i);
			}
		}
		return containsProduct;
	}
	
	public boolean removeProduct(Product suppliedProduct) {
		boolean isRemoved = false;
		if(products.contains(suppliedProduct)) {
			products.remove(suppliedProduct);
			isRemoved = true;
		} else {
			isRemoved = false;
		}
		return isRemoved;
	}
	
	// Adds a suppliedCoin to the coinBox ArrayList
	
	public void addGoldCoin(GoldCoin suppliedCoin) {
		coinBox.add(suppliedCoin);
	}
	
	/**
	 * Updates the user's totalSpend by associating their name
	 * with an amount of coins using a TreeMap
	 */
	public void updateTotalSpend(Customer customer, int coins) {
		if(customerTotalSpend.isEmpty()) {
			customerTotalSpend.put(customer.getName(), coins);
		} else {
			int currentSpend = customerTotalSpend.get(customer.getName()).intValue();
			customerTotalSpend.put(customer.getName(), coins + currentSpend);
		}
	}
	
	// Four getters that give me access to the private variables from outside the class
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public ArrayList<GoldCoin> getCoinBox() {
		return coinBox;
	}
	
	public TreeMap<String,Integer> getCustomerTotalSpend() {
		return customerTotalSpend;
	}
	
	public String getName() {
		return name;
	}
}
