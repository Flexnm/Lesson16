package remind;

import java.util.HashMap;

public class Reminders {
	
	private HashMap<Reminder, Integer> reminders;
	
	public Reminders() {
		this.reminders = new HashMap<Reminder, Integer>();
	}
	
	public HashMap<Reminder, Integer> getRems(){
		return reminders;
	}
	
	

}
