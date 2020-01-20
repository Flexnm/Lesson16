package remind;

import java.util.Calendar;

public class Program {
	
	public static void main(String[] args) {
		
		
		Reminders rems = new Reminders();
		
		Calendar deadline1 = Calendar.getInstance();
		deadline1.set(2021, 23, 45, 45, 64);
		Calendar deadline2 = Calendar.getInstance();
		deadline2.set(2020, 4, 6, 7, 8);
		Calendar deadline3 = Calendar.getInstance();
		deadline3.set(2020, 7, 8, 9, 10);
		Calendar deadline4 = Calendar.getInstance();
		deadline4.set(2020, 1, 2, 3, 4);
		Reminder r1 = new Reminder(deadline1, "notimp1", false);
		Calendar deadline5 = Calendar.getInstance();
		deadline5.set(2020, 1, 2, 3, 4);
		Reminder r5 = new Reminder(deadline5, "notimp2", false);
		Reminder r2 = new Reminder(deadline2, "imp1", true);
		Reminder r3 = new Reminder(deadline3, "imp2", true);
		Reminder r4 = new Reminder(deadline4, "imp3", true);
		
		rems.getRems().put(r1, r1.getNum());
		rems.getRems().put(r2, r2.getNum());
		rems.getRems().put(r3, r3.getNum());
		rems.getRems().put(r4, r4.getNum());
		rems.getRems().put(r5, r5.getNum());
		
		System.out.println(rems.getRems());
		
		RemindThread t1 = new RemindThread(rems.getRems());
		t1.start();
	}

}
