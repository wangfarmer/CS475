package calendar;

import java.util.Calendar;
import java.util.LinkedList;

public class CalendarObject {
	
	private String name;
	private LinkedList<EventObject> event;
	
	public CalendarObject() {
		super();
		
	}
	
	public CalendarObject(String name, LinkedList<EventObject> event) {
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
	
	public LinkedList<EventObject> getEvent() {
		return event;
	}

	public void setEvent(LinkedList<EventObject> event) {
		this.event = event;
	}
	
	public LinkedList<EventObject> retrieveEvent(Calendar startDate, Calendar endDate){
		
		LinkedList<EventObject> resultEventSet = new LinkedList<EventObject>();
		
		for (EventObject e : event){
			for(String name : e.getName()){
				if(name.equals(this.name) && ((startDate.compareTo(e.getEndDate())<=0 && startDate.compareTo(e.getStartDate())>=0 //startdate is between the event
						||endDate.compareTo(e.getEndDate())<=0 && endDate.compareTo(e.getStartDate())>=0) //enddate is between the event
						||(startDate.compareTo(e.getStartDate())<=0 && endDate.compareTo(e.getEndDate())>=0))){
						//the event is in the start and end date
					EventObject resultEvent = e;
					resultEventSet.add(resultEvent);
				}
				 
			}
		}
		
		if(resultEventSet.size() == 0){
			return null;
		}
		return resultEventSet;
	}
	
	public LinkedList<EventObject> retrieveEvent(String user, Calendar startDate, Calendar endDate){
		
		//Calendar c1 = Calendar.getInstance();
				//Calendar c2 = Calendar.getInstance();
				//c1.compareTo(c2);
				
				//the value 0 if the time represented by the argument is equal to the time represented by this Calendar;
				//a value less than 0 if the time of this Calendar is before the time represented by the argument; 
				//and a value greater than 0 if the time of this Calendar is after the time represented by the argument.
		LinkedList<EventObject> resultEventSet = new LinkedList<EventObject>();
		
		for (EventObject e : event){
			for(String name : e.getName()){
				if(name.equals(user) && ((startDate.compareTo(e.getEndDate())<=0 && startDate.compareTo(e.getStartDate())>=0 //startdate is between the event
						||endDate.compareTo(e.getEndDate())<=0 && endDate.compareTo(e.getStartDate())>=0) //enddate is between the event
						||(startDate.compareTo(e.getStartDate())<=0 && endDate.compareTo(e.getEndDate())>=0))){
						//the event is in the start and end date
					EventObject resultEvent = e;
					resultEventSet.add(resultEvent);
				}
				 
			}
		}
		
		if(resultEventSet.size() == 0){
			return null;
		}
		return resultEventSet;
	}
	
	public void scheduleEvent(EventObject newEvent){
		
		for (EventObject e : event){
			for(String name : e.getName()){
				if(name.equals(this.name) && (((newEvent.getStartDate()).compareTo(e.getEndDate())>=0 && (newEvent.getStartDate()).compareTo(e.getStartDate())<=0 //startdate is between the event
						||endDate.compareTo(e.getEndDate())<=0 && endDate.compareTo(e.getStartDate())>=0) //enddate is between the event
						||(startDate.compareTo(e.getStartDate())<=0 && endDate.compareTo(e.getEndDate())>=0))){
						//the event is in the start and end date
					EventObject resultEvent = e;
					resultEventSet.add(resultEvent);
				}
				 
			}
		}
		
		//find all event of the user,
		//for loop:
		//if newevent's starting time and ending time bigger than old events' starting time and less than ending time
		
		//the value 0 if the time represented by the argument is equal to the time represented by this Calendar;
				//a value less than 0 if the time of this Calendar is before the time represented by the argument; 
				//and a value greater than 0 if the time of this Calendar is after the time represented by the argument.
	}
	public void scheduleEvent(LinkedList<String> name, EventObject newEvent){
		
		
		
	}
}
