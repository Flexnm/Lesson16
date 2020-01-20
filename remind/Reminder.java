package remind;

import java.util.Calendar;

public class Reminder {
	
	private Calendar deadline;
	private String text;
	private boolean important;
	private int remindnum;
	
	public Reminder(Calendar deadline, String text, boolean important) {
		setLine(deadline);
		setTxt(text);
		setImp(important);
		if(important) {
			setNum(0);
		} else {
			setNum(2);
		}
	}
	
	public Calendar getLine() {
		return deadline;
	}
	
	public String getTxt() {
		return text;
	}
	
	public boolean getImp() {
		return important;
	}
	
	public int getNum() {
		return remindnum;
	}
	
	public void setLine(Calendar deadline) {
		this.deadline = deadline;
	}
	
	public void setTxt(String text) {
		this.text = text;
	}
	
	public void setImp(boolean important) {
		this.important = important;
	}
	
	public void setNum(int remindnum) {
		this.remindnum = remindnum;
	}
	
	public String toString() {
		String passed;
		if(getNum() == 0) {
			passed = "Yet to be reminded";
		} else {
			passed = "Reminded already";
		}
		return text + " " + deadline.getTime() + " " + important + " " + passed;
	}

}
