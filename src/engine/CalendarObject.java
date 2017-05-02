package calendar;

import java.util.LinkedList;

public class CalendarObject {
	
	private String name;
	private LinkedList<EventObj> event;
	
	public CalendarObject() {
		super();
		
	}
	
	public CalendarObject(String name, LinkedList<EventObj> event) {
		super();
		this.name = name;
		this.event = event;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public LinkedList<EventObj> getEvent() {
		return event;
	}

	public void setEvent(LinkedList<EventObj> event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Calendar: [Name: " + name + ", Event: " + event + "]";
	}
	
	
}