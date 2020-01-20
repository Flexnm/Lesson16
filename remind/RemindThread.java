package remind;

import java.util.Calendar;
import java.util.HashMap;

public class RemindThread extends Thread {

	private HashMap<Reminder, Integer> reminders;

	public RemindThread(HashMap<Reminder, Integer> reminders) {
		this.reminders = reminders;
	}

	public void run() {
		while (true) {
			for (Reminder reminder : reminders.keySet()) {
				if (reminder.getLine().getTimeInMillis() < Calendar.getInstance().getTimeInMillis()) {
					if (reminders.get(reminder) < 3) {
						if (reminder.getImp()) {
							System.out.println("imp " + reminder.getTxt());
							reminders.put(reminder, reminders.get(reminder) + 1);
						} else {
							System.out.println("not imp " + reminder.getTxt());
							reminders.put(reminder, reminders.get(reminder) + 1);
						}

					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}
	}

}
