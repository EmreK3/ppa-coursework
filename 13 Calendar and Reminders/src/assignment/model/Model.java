package assignment.model;

import java.util.ArrayList;
import java.util.Observable;


public class Model extends Observable {
	
	ArrayList<String> east = new ArrayList<String>();
	ArrayList<String> rightCenter = new ArrayList<String>();
	ArrayList<String> leftCenter = new ArrayList<String>();
	ArrayList<String> west = new ArrayList<String>();
	private boolean isGameFinished;
	private String EndMessage;
	
	
	public Model() {
		
		east.add("fox");
		east.add("goose");
		east.add("bagofbeans");
		east.add("farmer");
		rightCenter.add("boat");
		setGameFinished(false);
		
	}
	
	//This method is used to check if the specified icon is in the east array.
	public boolean checkInEastArray(String characterToCheck){
		boolean has = false;
		
		for (String i : east){
			if (i == characterToCheck){
				
				has = true;
			}
		}
		
		return has;
	}
	
	//This method is used to check if the specified icon is in the west array.
	public boolean checkInCentreRightArray(String characterToCheck){
		boolean has = false;
		
		for (String i : rightCenter){
			if (i == characterToCheck){
				
				has = true;
			}
		}
		
		return has;
	}
	
	//This method is used to check if the specified icon is in the left centre array.
	public boolean checkInCentreLeftArray(String characterToCheck){
		boolean has = false;
		
		for (String i : leftCenter){
			if (i == characterToCheck){
				
				has = true;
			}
		}
		return has;
	}
	
	//This method is used to check if the specified icon is in the right centre array.
	public boolean checkInWestArray(String characterToCheck){
		boolean has = false;
		
		for (String i : west){
			if (i == characterToCheck){
				
				has = true;
			}
		}
		return has;
	}
	
	//This is the method to add to the east array.
	public void addToEast(String iconToAdd){

		east.add(iconToAdd);
		setChanged();
		notifyObservers();
	}
	
	//This is the method to remove from the east array.
	public void removeFromEast(String iconToRemove){

		east.remove(iconToRemove);
		setChanged();
		notifyObservers();
	}
	
	//This is the method to add to the right center array.
	public void addToRightCenter(String iconToAdd){
		if(!(rightCenter.size() >= 3)) {
			rightCenter.add(iconToAdd);
			isBeanEaten();
			isGooseEaten();
			setChanged();
			notifyObservers();
		}
	}
	
	//This is the method to remove from the right center array.
	public void removeFromRightCenter(String iconToRemove){

		rightCenter.remove(iconToRemove);
		setChanged();
		notifyObservers();
	}
	
	//This is the method to add to the left center array.
	public void addToLeftCenter(String iconToAdd){
		if(!(leftCenter.size() >= 3)) {
			leftCenter.add(iconToAdd);
			isBeanEaten();
			isGooseEaten();
			setChanged();
			notifyObservers();
		}
	}
	
	//This is the method to remove from the left center array.
	public void removeFromLeftCenter(String iconToRemove){

		leftCenter.remove(iconToRemove);
		setChanged();
		notifyObservers();
	}
	
	//This is the method to add to the west array.
	public void addToWest(String iconToAdd){

		west.add(iconToAdd);
		isBeanEaten();
		isGooseEaten();
		setChanged();
		notifyObservers();
	}
	
	//This is the method to remove from the west array.
	public void removeFromWest(String iconToRemove){

		west.remove(iconToRemove);
		setChanged();
		notifyObservers();
	}
	
	//This is the method will add all elements on the boat and the boat itself from the east to the west.
	public void transferFromEastToWest(){
		int size = rightCenter.size();
		
		if(rightCenter.contains("farmer")) {
			if(size >= 1) {
				for(int i = 0; i < size; i++) {
					leftCenter.add(rightCenter.get(i));
				}
			}
				
			rightCenter.clear();
			isBeanEaten();
			isGooseEaten();
		}	
		setChanged();
		notifyObservers();

	}
	
	//This is the method will add all elements on the boat and the boat itself from the west to the east.
	public void transferFromWestToEast(){
		int size = leftCenter.size();
		if(leftCenter.contains("farmer")) {
			if(size >= 1) {
				for(int i = 0; i < size; i++) {
					rightCenter.add(leftCenter.get(i));
				}
			}
			
			leftCenter.clear();
			isBeanEaten();
			isGooseEaten();
		}
		setChanged();
		notifyObservers();

	}
		
	
	//This is the method used to check how many characters are in the east panel.
	public int checkNoInEast(){

		return east.size();
	}
	
	//This is the method used to check how many characters are in the east side of water.
	public int checkNoInEastWater(){

		return rightCenter.size();
	}
	
	//This is the method used to check how many characters are in the west side of water.
	public int checkNoInWestWater(){

		return leftCenter.size();
	}
	
	//This is the method used to check how many characters are in the west panel.
	public int checkNoInWest(){

		return west.size();
	}
	
	
	
	//This method checks if the goose has been eaten.
	//This method will return true when the fox and goose are the in the same array and they are the only things in the array.
	//This method checks both the east and west arrays.
	public boolean isGooseEaten(){
		if ( (checkInWestArray("fox") == true && checkInWestArray("goose") == true && checkNoInWestWater() == 0 && checkNoInWest() == 2) || (checkInEastArray("fox") && checkInEastArray("goose") && checkNoInEastWater() == 0 && checkNoInEast() == 2) ){
			
			setGameFinished(true);
			setChanged();
			notifyObservers();
			return true;
		}
		
		return false;
	}
	
	//This method checks if the bean has been eaten.
	//This method will return true when the bean and goose are the in the same array and they are the only things in the array.
	//This method checks both the east and west arrays.
	public boolean isBeanEaten(){

		if ( (checkInWestArray("bagofbeans") && checkInWestArray("goose") && checkNoInWestWater() == 0 && checkNoInWest() == 2) || (checkInEastArray("bagofbeans") && checkInEastArray("goose") && checkNoInEastWater() == 0 && checkNoInEast() == 2) ){
			
			setGameFinished(true);
			setChanged();
			notifyObservers();
			return true;
		}
		
		return false;
	}
	
	// Method that checks which end message should be displayed
	public String checkGameDisplay(){
		
		if(isGooseEaten()){	
			EndMessage = "Game over! The Goose has been eaten by the Fox";
		} else if(isBeanEaten()){
			EndMessage = "Game over! The Bean has been eaten by the Goose";
		} else if (!isGooseEaten() && !isBeanEaten() && checkNoInWest() >= 3 ){
			EndMessage = "You Win, all items have arrived safely";
		} else {
			EndMessage = "Fox, Goose and Bag of Beans";
		}
		return EndMessage;
	}

	public ArrayList<String> getEast() {
		return east;
	}

	public ArrayList<String> getRightCenter() {
		return rightCenter;
	}

	public ArrayList<String> getLeftCenter() {
		return leftCenter;
	}

	public ArrayList<String> getWest() {
		return west;
	}

	/**
	 * @return the isGameFinished
	 */
	public boolean isGameFinished() {
		return isGameFinished;
	}

	/**
	 * @param isGameFinished the isGameFinished to set
	 */
	public void setGameFinished(boolean isGameFinished) {
		this.isGameFinished = isGameFinished;
	}
}
