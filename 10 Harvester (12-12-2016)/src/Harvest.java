public class Harvest {
	public static void main(String[] args) {
		Farm farm = new Farm();
		
		farm.addHarvester(new Harvester(1,1));
		farm.addHarvester(new CombineHarvester(2,2,3));
		
		for(int i = 0; i < 5; i++) {
			farm.addField(new Field("Corn", 20));
			farm.addField(new Field("Wheat", 20));
			farm.addField(new Field("Oats", 20));
			farm.addField(new Field("Barley", 20));
		}
		
		farm.harvest(); // Harvests the farm.
		System.out.println("Total profit: £" + farm.getProfit()); // Prints out total profit.
	}
}
