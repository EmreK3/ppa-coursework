package assignment.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;

import assignment.model.Model;
import assignment.view.View;

public class AddController implements ActionListener {
	
//	private static Pattern day = Pattern.compile("(Mon|mon|Tues|tues|Wednes|wednes|Thurs|thurs|Fri|fri|Satur|satur|Sun|sun)day");
//	private static Pattern month = Pattern.compile("(Jan|jan|Feb|feb)uary|March|march|April|april|May|may|June|june|July|july|August|august|(Septem|septem|Octo|octo|Novem|novem|Decem|decem)ber");
//	private static Pattern dayNumber = Pattern.compile("(?<!1)([2-9]*1)(st)|(?<!1)([2-9]*2)(nd)|(?<!1)([2-9]*3)(rd)|(\\d[0,4-9]|[4-9]|1[0-9])(th)");
	
	
	private static Pattern numericalDate = Pattern.compile("\\d\\d[/\\-]\\d\\d[/\\-]\\d\\d\\d\\d");
	private static Pattern fullDate = Pattern.compile("((Mon|mon|Tues|tues|Wednes|wednes|Thurs|thurs|Fri|fri|Satur|satur|Sun|sun)day)\\s((?<!1)([2-9]*1)(st)|(?<!1)([2-9]*2)(nd)|(?<!1)([2-9]*3)(rd)|(\\d[0,4-9]|[4-9]|1[0-9])(th))\\s((Jan|jan|Feb|feb)uary|March|march|April|april|May|may|June|june|July|july|August|august|(Septem|septem|Octo|octo|Novem|novem|Decem|decem)ber)");
	private static Pattern onDay = Pattern.compile("(On|on)\\s((Mon|mon|Tues|tues|Wednes|wednes|Thurs|thurs|Fri|fri|Satur|satur|Sun|sun)day)");
	private static Pattern nextDay = Pattern.compile("(Next|next)\\s((Mon|mon|Tues|tues|Wednes|wednes|Thurs|thurs|Fri|fri|Satur|satur|Sun|sun)day)");
	
	private static Pattern evening = Pattern.compile("in\\sthe\\sEvening|in\\sthe\\sevening|Evening|evening");
	private static Pattern morning = Pattern.compile("in\\sthe\\sMorning|in\\sthe\\smorning|Morning|morning");
	private static Pattern am = Pattern.compile("([0-1][0-2]|(?<!1)[0-9])(am|AM)");
	private static Pattern pm = Pattern.compile("([0-1][0-2]|(?<!1)[0-9])(pm|PM)");
	private static Pattern twentyFourHour = Pattern.compile("(([0-1][0-9]|2[0-3]):([0-5]\\d))|(24:00)");
	
	private static Pattern firstLocation = Pattern.compile("(At|at)\\s(.*)");
	private static Pattern location = Pattern.compile("\\s(At|at)\\s[^\\s]+");
	
	private static Pattern reminder = Pattern.compile("(R|r)emind\\sme\\sto");
	
	private Model model;
	private View view;

	public AddController(Model model) {
		this.model = model;
	}
	
	public void setView(View view) {
		this.view = view;
	}
	
	public void eventVerify(String naturalText) {
		String nonEvent = "";
		Matcher matcher = numericalDate.matcher(naturalText);
		Matcher matcher2 = fullDate.matcher(naturalText);
		Matcher matcher3 = onDay.matcher(naturalText);
		Matcher matcher4 = nextDay.matcher(naturalText);
		Matcher matcher5 = evening.matcher(naturalText);
		Matcher matcher6 = morning.matcher(naturalText);
		Matcher matcher7 = am.matcher(naturalText);
		Matcher matcher8 = pm.matcher(naturalText);
		Matcher matcher9 = twentyFourHour.matcher(naturalText);
		Matcher matcher10 = firstLocation.matcher(naturalText);
		Matcher matcher11 = location.matcher(naturalText);
		Matcher matcher12 = reminder.matcher(naturalText);
		while (matcher.find()) {
			nonEvent += matcher.group() + " ";
		}
		while (matcher2.find()) {
			nonEvent += matcher2.group() + " ";
		}
		while (matcher3.find()) {
			nonEvent += matcher3.group() + " ";
		}
		while (matcher4.find()) {
			nonEvent += matcher4.group() + " ";
		}
		while (matcher5.find()) {
			nonEvent += matcher5.group() + " ";
		}
		while (matcher6.find()) {
			nonEvent += matcher6.group() + " ";
		}
		while (matcher7.find()) {
			nonEvent += matcher7.group() + " ";
		}
		while (matcher8.find()) {
			nonEvent += matcher8.group() + " ";
		}
		while (matcher9.find()) {
			nonEvent += matcher9.group() + " ";
		}
		while (matcher10.find()) {
			nonEvent += matcher10.group() + " ";
		}
		while (matcher11.find()) {
			nonEvent += matcher11.group() + " ";
		}
		while (matcher12.find()) {
			nonEvent += matcher12.group();
		}
		String textString = "[ ]+";
		String[] textTokens = naturalText.split(textString);
		String nonEventString = "[ ]+";
		String[] nonEventTokens = nonEvent.split(nonEventString);
		
		for (String currentToken: nonEventTokens) {
			for (int i = 0; i < textTokens.length; i++) {
				if (currentToken.equals(textTokens[i])) {
					textTokens[i] = null;
				}
			}
		}
		String event = "";
		for (int i = 0; i < textTokens.length; i++) {
			if (textTokens[i] != null) {
				event += textTokens[i] + " ";
			}
		}
		model.setEvent(event);
		System.out.println(event);
	}
	
	public void numericalDateVerify(String naturalText) {
		Matcher matcher = numericalDate.matcher(naturalText);
		while (matcher.find()) {
			model.setDate(matcher.group());
		}
	}
	
	public void fullDateVerify(String naturalText) {
		Matcher matcher = fullDate.matcher(naturalText);
		while (matcher.find()) {
			model.setDate(matcher.group());
		}
	}
	
	public void onDayVerify(String naturalText) {
		Matcher matcher = onDay.matcher(naturalText);
		while (matcher.find()) {
			model.setOnDay(matcher.group());
		}
	}
	
	public void nextDayVerify(String naturalText) {
		Matcher matcher = nextDay.matcher(naturalText);
		while (matcher.find()) {
			model.setNextDay(matcher.group());
		}
	}
	
	public void eveningVerify(String naturalText) {
		Matcher matcher = evening.matcher(naturalText);
		while (matcher.find()) {
			model.setTime(matcher.group());
		}
	}
	
	public void morningVerify(String naturalText) {
		Matcher matcher = morning.matcher(naturalText);
		while (matcher.find()) {
			model.setTime(matcher.group());
		}
	}
	
	public void amVerify(String naturalText) {
		Matcher matcher = am.matcher(naturalText);
		while (matcher.find()) {
			model.setCheckTime(matcher.group());
			model.setTime(matcher.group());
		}
	}
	
	public void pmVerify(String naturalText) {
		Matcher matcher = pm.matcher(naturalText);
		while (matcher.find()) {
			model.setCheckTime(matcher.group());
			model.setTime(matcher.group());
		}
	}

	public void twentyFourHourVerify(String naturalText) {
		Matcher matcher = twentyFourHour.matcher(naturalText);
		while (matcher.find()) {
			model.setCheckTime(matcher.group());
			model.setTime(matcher.group());
		}
	}
	
	public void locationVerify(String naturalText) {
		String string = "[ ]+";
		String[] tokens = naturalText.split(string);
		if (tokens[0].equals("at")) {
			Matcher matcher = firstLocation.matcher(naturalText);
			while (matcher.find()) {
				model.setLocation(matcher.group());
			}
		} else {
			Matcher matcher = location.matcher(naturalText);
			while (matcher.find()) {
				model.setLocation(matcher.group());
			}
		}
	}
	
	public void reminderVerify(String naturalText) {
		model.resetReminder();
		Matcher matcher = reminder.matcher(naturalText);
		while (matcher.find()) {
			model.setReminder();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		eventVerify(View.getNaturalText());
		
		morningVerify(View.getNaturalText());
		eveningVerify(View.getNaturalText());
		amVerify(View.getNaturalText());
		pmVerify(View.getNaturalText());
		twentyFourHourVerify(View.getNaturalText());
		
		numericalDateVerify(View.getNaturalText());
		fullDateVerify(View.getNaturalText());
		onDayVerify(View.getNaturalText());
		nextDayVerify(View.getNaturalText());
		
		locationVerify(View.getNaturalText());
		
		reminderVerify(View.getNaturalText());

		if (model.getReminder()) {
			model.createReminder(View.getNaturalText());
		} else {
			model.createEvent();
		}
		model.resetFields();
	}
	
}
