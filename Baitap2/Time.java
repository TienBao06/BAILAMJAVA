package Baitap2;

public class Time {
	private int hour;
	private int minute;
	private int second;
	
	public Time(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public void setTime ( int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public String toString () {
		return String.format("%02d : %02d : %02d", this.hour, this.minute, this.second);
	} 
	
	public Time nextSecond () {
		second++;
		  if (second >= 60) {
		   second = 0;
		   minute++;
		   if (minute >= 60) {
		    hour++;
		    minute = 0;
		    if (hour >= 24) {
		     hour = 0;
		    }
		   }
		  }
		  return this; 
	}
	
	public Time previousSecond() {
		second--;
		  if (second <0) {
		   second = 59;
		   minute--;
		   if (minute <0) {
		    hour--;
		    minute = 59;
		    if (hour <0) {
		     hour = 23;
		    }
		   }
		  }
		  return this;
	}

}