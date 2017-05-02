package calendar;

import java.util.Calendar;
import java.util.LinkedList;

public class CalendarManager {
	private String userName;
	private LinkedList<CalendarObject> calendar;

	public CalendarManager() {
		super();
	}
	
	public CalendarManager(LinkedList<CalendarObject> calendar) {
		this.calendar = calendar;
	}
	
	public LinkedList<CalendarObject> getCalendar() {
		return calendar;
	}

	public void setCalendar(LinkedList<CalendarObject> calendar) {
		this.calendar = calendar;
	}
	
	public LinkedList<EventObj> retrieveEvent(Calendar startDate, Calendar endDate){
		
		//initialize a list for return
		LinkedList<EventObj> resultEventSet = new LinkedList<EventObj>();
		
		boolean userExist = false;
		//iterate from beginning, search the name same as the username
		for (CalendarObject e : calendar){
			if(userName.equals(e.getName())){
				userExist =  true;
				//once find the name's calendar object, get eventlist
				for(EventObj retrieveEvent : e.getEvent()){
					//if there are matching, then add the event  to result set
					if((startDate.compareTo(retrieveEvent.getEndDate())<=0 && startDate.compareTo(retrieveEvent.getStartDate())>=0) //startdate is between the event
							||(endDate.compareTo(retrieveEvent.getEndDate())<=0 && endDate.compareTo(retrieveEvent.getStartDate())>=0) //enddate is between the event
							||(startDate.compareTo(retrieveEvent.getStartDate())<=0 && endDate.compareTo(retrieveEvent.getEndDate())>=0)//the event is in the start and end date
							){
						
						resultEventSet.add(retrieveEvent);
					}
				}	
			}
		}
		
		
		
		if(userExist == false){
			//check if parameter user does not exist
			System.out.print(userName + " is not in userlist: ");
			return null;
		}else{
			if(resultEventSet.size() == 0){
				System.out.print("No event at this time for " + userName);
				return null;
			}
			return resultEventSet;
		}
	}
	
	public LinkedList<EventObj> retrieveEvent(String user, Calendar startDate, Calendar endDate){
		
		//initialize a list for return
		LinkedList<EventObj> resultEventSet = new LinkedList<EventObj>();
		
		boolean userExist = false;
		//iterate from beginning, search the name same as the parameter user
		for (CalendarObject e : calendar){
			if(user.equals(e.getName())){
				userExist =  true;
				//once find the name's calendar object, get eventlist
				for(EventObj retrieveEvent : e.getEvent()){
					//if there are matching, then add the event  to result set
					if((startDate.compareTo(retrieveEvent.getEndDate())<=0 && startDate.compareTo(retrieveEvent.getStartDate())>=0) //startdate is between the event
							||(endDate.compareTo(retrieveEvent.getEndDate())<=0 && endDate.compareTo(retrieveEvent.getStartDate())>=0) //enddate is between the event
							||(startDate.compareTo(retrieveEvent.getStartDate())<=0 && endDate.compareTo(retrieveEvent.getEndDate())>=0)//the event is in the start and end date
							){
						
						resultEventSet.add(retrieveEvent);
					}
				}	
			}
			
		}
		
		if(userExist == false){
			//check if parameter user does not exist
			System.out.print(user + " is not in userlist: ");
			return null;
		}else{
			if(resultEventSet.size() == 0){
				System.out.print("No event at this time for " + user);
				return null;
			}
			return resultEventSet;
		}
		
		
	}
	
	public void scheduleEvent(EventObj newEvent){
		
		//initialize a check for time conflicting
		boolean timeConflict = false;
		
		boolean userExist = false;
		
		for (CalendarObject e : calendar){
			//iterate from beginning, search the name same as the username
			if(userName.equals(e.getName())){
				userExist = true;
				allloop:
				//iterate from beginning, search if there is time conflicting
				for(EventObj checkEvent : e.getEvent()){
					//if there are conflicting, break the for loop the return error message
					if(((newEvent.getStartDate()).compareTo(checkEvent.getEndDate())<0 && (newEvent.getStartDate()).compareTo(checkEvent.getStartDate())>=0) //startdate is between the event
							||((newEvent.getEndDate()).compareTo(checkEvent.getEndDate())<=0 && (newEvent.getEndDate()).compareTo(checkEvent.getStartDate())>0) //enddate is between the event
							||((newEvent.getStartDate()).compareTo(checkEvent.getStartDate())<=0 && (newEvent.getEndDate()).compareTo(checkEvent.getEndDate())>=0)//the event is in the start and end date
							){
						timeConflict = true;
						break allloop;
					}
				}	
			
				if (timeConflict == true){
					//there are conflicting, return error message
					System.out.println("Time Conflict! " + userName +" already have an event at this time! Please reschedule!");
				}else{
					//no conflicting add the newEvent to the user
					e.getEvent().add(newEvent);
				}
			}
		}
		
		if(userExist == false){
			CalendarObject registerUser = new CalendarObject();
			LinkedList<EventObj> registerEvents = new LinkedList<EventObj>();
			registerEvents.add(newEvent);
			registerUser.setName(userName);
			registerUser.setEvent(registerEvents);
		}
		
	}
	public void scheduleEvent(LinkedList<String> name, EventObj newEvent){

		//initialize a check for time conflicting
		boolean timeConflict = false;
		
		//iterate from beginning, search the name same as the username
		for (CalendarObject e : calendar){
			//iterate from beginning, get every name passed by this list
			for(String nameInput : name){
				boolean userExist = false;
				if(nameInput.equals(e.getName())){
					userExist = true;
					allloop:
					//iterate from beginning, search if there is time conflicting
					for(EventObj checkEvent : e.getEvent()){
						if(((newEvent.getStartDate()).compareTo(checkEvent.getEndDate())<0 && (newEvent.getStartDate()).compareTo(checkEvent.getStartDate())>=0) //startdate is between the event
								||((newEvent.getEndDate()).compareTo(checkEvent.getEndDate())<=0 && (newEvent.getEndDate()).compareTo(checkEvent.getStartDate())>0) //enddate is between the event
								||((newEvent.getStartDate()).compareTo(checkEvent.getStartDate())<=0 && (newEvent.getEndDate()).compareTo(checkEvent.getEndDate())>=0)//the event is in the start and end date
								){
							timeConflict = true;
							break allloop;
						}
					}	
				
					if (timeConflict == true){
						//there are conflicting, return error message
						System.out.println("Time Conflict! " + nameInput +" already have an event at this time! Please reschedule!");
					}else{
						//no conflicting add the newEvent to the user
						e.getEvent().add(newEvent);
					}
					
				}
				if(userExist == false){
					CalendarObject registerUser = new CalendarObject();
					LinkedList<EventObj> registerEvents = new LinkedList<EventObj>();
					registerEvents.add(newEvent);
					registerUser.setName(nameInput);
					registerUser.setEvent(registerEvents);
				}
				
			}
			
				
			
		}
		
		
	}

}
