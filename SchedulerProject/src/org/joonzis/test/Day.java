package org.joonzis.test;

public class Day {
	String schedule;
	
	public Day() {
	}	
	
	public Day(String schedule) {
		this.schedule = schedule;
	}
	
	String getSchedule() {
		return schedule;
	}
	
	void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	
	String output() {
		return (this.schedule != null ? this.schedule : "없음");
	}
}
