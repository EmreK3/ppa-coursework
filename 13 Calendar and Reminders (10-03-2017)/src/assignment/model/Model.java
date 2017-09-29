package assignment.model;

import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import javax.swing.JList;

public class Model extends Observable {
	
	private String date;
	private String day;
	private String time;
	private String location;
	private String event;
	//return true if it's in reminder
	private boolean reminder = false;
	
	private Map<Integer, String> dayOfWeek;
	private Map<Integer, String> monthNumber;
	private Map<String, Integer> dayNumber;
	
	private LocalDate tempDate;
	private String checkTime;
	
	private String displayReminder = "";
	private String displayEvent = "";
	
	private JList<String> deleteFrom;
	private int indexOfEvent;
	
	public Model() {
		dayOfWeek = new HashMap<Integer, String>();
		dayOfWeek.put(1, "Sunday");
		dayOfWeek.put(2, "Monday");
		dayOfWeek.put(3, "Tuesday");
		dayOfWeek.put(4, "Wednesday");
		dayOfWeek.put(5, "Thursday");
		dayOfWeek.put(6, "Friday");
		dayOfWeek.put(7, "Saturday");
		
		monthNumber = new HashMap<Integer, String>();
		monthNumber.put(0, "January");
		monthNumber.put(1, "February");
		monthNumber.put(2, "March");
		monthNumber.put(3, "April");
		monthNumber.put(4, "may");
		monthNumber.put(5, "June");
		monthNumber.put(6, "July");
		monthNumber.put(7, "August");
		monthNumber.put(8, "September");
		monthNumber.put(9, "October");
		monthNumber.put(10, "November");
		monthNumber.put(11, "December");
		
		dayNumber = new HashMap<String, Integer>();
		dayNumber.put("Sunday", 7);
		dayNumber.put("Monday", 1);
		dayNumber.put("Tuesday", 2);
		dayNumber.put("Wednesday", 3);
		dayNumber.put("Thursday", 4);
		dayNumber.put("Friday", 5);
		dayNumber.put("Saturday", 6);
		dayNumber.put("sunday", 7);
		dayNumber.put("monday", 1);
		dayNumber.put("tuesday", 2);
		dayNumber.put("wednesday", 3);
		dayNumber.put("thursday", 4);
		dayNumber.put("friday", 5);
		dayNumber.put("saturday", 6);
	}
	
	public void setDate(String date) {
		if (date.contains("day")) {
			this.date = date;
		} else {
			this.date = convertDateFormat(date);
		}
	}
	
	public String convertDateFormat(String date) {
		java.util.Date formattedDate = null;
		if (date.contains("/")) {
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
		    try {
		        formattedDate = df.parse(date);
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		} else {
			DateFormat df = new SimpleDateFormat("MM-dd-yyyy"); 
		    try {
		        formattedDate = df.parse(date);
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(formattedDate);
		
		int intDay = calendar.get(Calendar.DAY_OF_WEEK);
		String day = dayOfWeek.get(intDay);
		
		String datePostfix = null;
		int intDate = calendar.get(Calendar.DATE);
		if (intDate >= 11 && intDate <= 13) {
			datePostfix = "th";
		}
		switch (intDate % 10) {
			case 1:
				datePostfix = "st";
				break;
			case 2:
				datePostfix = "nd";
				break;
			case 3:
				datePostfix = "rd";
				break;
			default:
				datePostfix = "th";
				break;
		}
		String dateDisplay = intDate + datePostfix;
		
		int intMonth  = calendar.get(Calendar.MONTH);
		String month = monthNumber.get(intMonth);
		String convertedDate = day + " " + dateDisplay + " " + month;
		return convertedDate;
	}
	
	public void setOnDay(String day) {
		this.date = convertOnDay(day);
	}
	
	public String convertOnDay(String day) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate today = LocalDate.now();
		String string = "[ ]+";
		String[] tokens = day.split(string);
		if (today.getDayOfWeek().getValue() <= dayNumber.get(tokens[1])) {
			int dayDifference = dayNumber.get(tokens[1]) - today.getDayOfWeek().getValue();
			today = today.plusDays(dayDifference);
		} else {
			switch (today.getDayOfWeek().getValue()) {
				case 6:
					today = today.plusDays(1 + dayNumber.get(tokens[1]));
					break;
				case 5:
					today = today.plusDays(2 + dayNumber.get(tokens[1]));
					break;
				case 4:
					today = today.plusDays(3 + dayNumber.get(tokens[1]));
					break;
				case 3:
					today = today.plusDays(4 + dayNumber.get(tokens[1]));
					break;
				case 2:
					today = today.plusDays(5 + dayNumber.get(tokens[1]));
					break;
			}
		}
		tempDate = today;
		String convertedDate = convertDateFormat(dateFormat.format(today));
		return convertedDate;
	}
	
	public void setNextDay(String day) {
		convertOnDay(day);
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		this.date = convertDateFormat(dateFormat.format(tempDate.plusDays(7)));
	}
	
	public void setTime(String time) {
		if(time.equals("evening") || time.equals("in the evening") || time.equals("Evening") || time.equals("in the Evening")) {
			this.time = "20:00";
		} else if(time.equals("morning") || time.equals("in the morning") || time.equals("Morning") || time.equals("in the Morning")) {
			this.time = "09:00";
		} else if(time.contains("am")) {
			if(time.length() == 3) {
				this.time = "0" + String.valueOf(time.charAt(0)) + ":00";
			} else if(time.length() == 4) {
				this.time = String.valueOf(time.charAt(0)) + String.valueOf(time.charAt(1)) + ":00";
			}
		} else if(time.contains("pm")) {
			if(time.length() == 3) {
				int temp = Integer.parseInt(String.valueOf(time.charAt(0)));
				temp += 2;
				this.time = "1" + temp + ":00";
			} else if (time.length() == 4) {
				int temp = Integer.parseInt(String.valueOf(time.charAt(1)));
				temp += 2;
				this.time = "2" + temp + ":00";
			}
		} else {
			this.time = time;
		}
	}
	
	public void setLocation(String location) {
		String string = "[ ]+";
		String[] tokens = location.split(string);
		System.out.println(tokens.length);
		System.out.println(tokens[2]);
		if (tokens.length == 2) {
			if (tokens[1].equals(checkTime)) {
			} else {
				this.location = tokens[1];
			}
		} else if (tokens.length == 3) {
			if( tokens[2].equals(checkTime)) {
			} else {
				this.location = tokens[2];
			}
		}
	}
	
	public void setReminder() {
		this.reminder = true;
	}
	
	public void setEvent(String event) {
		this.event = event;
	}
	
	public void resetReminder() {
		this.reminder = false;
	}
	
	public void setCheckTime(String checkTime) {
		String string = "[ ]+";
		String[] tokens = checkTime.split(string);
		this.checkTime = checkTime;
	}
	
	//return true if it is time
	public boolean checkTime(String location) {
		if (location.equals(checkTime)) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getTime() {
		return time;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getLocation() {
		return location;
	}
	
	public boolean getReminder() {
		return reminder;
	}

	public void createReminder(String naturalText) { 
		String string = "[ ]+";
		String[] tokens = naturalText.split(string);
		//System.out.println(tokens[3]);
		for (int i = 3; i < tokens.length; i++) {
			displayReminder += " " + tokens[i];
		}
		if (date != null) {
			displayReminder += " | " + "Date: " + date;
		}
		if (time != null) {
			displayReminder += " | " + "Time: " + time;
		}
		if (location != null) {
			displayReminder += " | " + "Location: " + location;
		}
		setChanged();
		notifyObservers();
	}
	
	public void createEvent() {
		if (date == null) {
			this.date = "-";
		}
		if (time == null) {
			this.time = "-";
		}
		if (location == null) {
			this.location = "-";
		}
		displayEvent = "Event: " + event + " | " + "Date: " + date + " | " + "Time: " + time + " | " + "Location: " + location;
		setChanged();
		notifyObservers();
	}
	
	public void resetFields() {
		date = null;
		time = null;
		location = null;
		displayReminder = "";
		displayEvent = "";
		deleteFrom = null;
		indexOfEvent = 0;
	}
	
	public String getDisplayReminder() {
		return displayReminder;
	}
	
	public String getDisplayEvent() {
		return displayEvent;
	}
	
	public void deleteList(MouseEvent mouseEvent) {
			JList listClicked = (JList) mouseEvent.getSource();
			int index = listClicked.locationToIndex(mouseEvent.getPoint());
			setChanged();
			notifyObservers();
	}
	
	public JList<String> getDeleteFrom() {
		return deleteFrom;
	}
	
	public int getIndexOfEvent() {
		return indexOfEvent;
	}
	
}
