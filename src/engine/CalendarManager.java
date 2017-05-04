package engine;

import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.io.Serializable;
import compute.CalendarMgrIntr;
//import engine.CalendarObject;
//import engine.EventObj;

public class CalendarManager implements CalendarMgrIntr, Serializable, CalendarObject, EventObj{
        private static final long serialVersionUID = 227L;
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
	
	public CalenderObj createCalendarObject(String createNewClientName){
		return new CalendarObj(createNewClientName, new LinkedList<EventObj>());
	}
	
	public EventObj createEvent(Calendar scheduleStartDateInput, Calendar scheduleEndDateInput, 
			String descriptionScheduleInput, String accessControlScheduleInput){
		
		return new EventObj(scheduleStartDateInput, scheduleEndDateInput, descriptionScheduleInput, accessControlScheduleInput);
		
	}

	public LinkedList<EventObj> retrieveOthersEvent(String user, Calendar startDate, Calendar endDate){

		//initialize a list for return
		LinkedList<EventObj> resultEventSet = new LinkedList<EventObj>();

		boolean userExist = false;
		//iterate from beginning, search the name same as the parameter user
		if(calendar.isEmpty()){
			System.out.println("No calandar events have been scheduled");
		}else{
			for (CalendarObject e : calendar){
				if(user.equalsIgnoreCase(e.getName())){
					userExist =  true;
					//once find the name's calendar object, get eventlist
					for(EventObj retrieveEvent : e.getEvent()){
						//if there are matching, then add the event  to result set
						if((startDate.compareTo(retrieveEvent.getEndDate())<=0 && startDate.compareTo(retrieveEvent.getStartDate())>=0) //startdate is between the event
								||(endDate.compareTo(retrieveEvent.getEndDate())<=0 && endDate.compareTo(retrieveEvent.getStartDate())>=0) //enddate is between the event
								||(startDate.compareTo(retrieveEvent.getStartDate())<=0 && endDate.compareTo(retrieveEvent.getEndDate())>=0)//the event is in the start and end date
								){
							if(retrieveEvent.getAccessControl().equalsIgnoreCase("Private")){
								resultEventSet.add(retrieveEvent);
							}

						}
					}
				}

			}
		}


		if(userExist == false){
			//check if parameter user does not exist
			System.out.println(user + " is not in userlist: ");
			return null;
		}else{
			if(resultEventSet.size() == 0){
				System.out.println("No event at this time for " + user);
				return null;
			}
			return resultEventSet;
		}


	}

public LinkedList<EventObj> retrieveOwnEvent(String user, Calendar startDate, Calendar endDate){

		//initialize a list for return
		LinkedList<EventObj> resultEventSet = new LinkedList<EventObj>();

		boolean userExist = false;
		//iterate from beginning, search the name same as the parameter user
		if(calendar.isEmpty()){
			System.out.println("No calandar events have been scheduled");
		}else{
			for (CalendarObject e : calendar){
				if(user.equalsIgnoreCase(e.getName())){
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
		}


		if(userExist == false){
			//check if parameter user does not exist
			System.out.println(user + " is not in userlist: ");
			return null;
		}else{
			if(resultEventSet.size() == 0){
				System.out.println("No event at this time for " + user);
				return null;
			}
			return resultEventSet;
		}


	}


	public void scheduleEvent(LinkedList<String> name, EventObj newEvent){

		//initialize a check for time conflicting
		boolean timeConflict = false;
		boolean userExist = false;
		//iterate from beginning, get every name passed by this list
		for(String nameInput : name){
		//iterate from beginning, search the name same as the username
		for (CalendarObject e : calendar){


				if(nameInput.equalsIgnoreCase(e.getName())){
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

				}
		if(userExist == false){
			CalendarObject registerUser = new CalendarObject();
			LinkedList<EventObj> registerEvents = new LinkedList<EventObj>();
			registerEvents.add(newEvent);
			registerUser.setName(nameInput);
			registerUser.setEvent(registerEvents);
			this.calendar.add(registerUser);

			}

		}
	}

	public void calandarItr(){
		Iterator<CalendarObject> itr = calendar.iterator();
		while(itr.hasNext()){
			System.out.println(calendar.toString());
			itr.next();
		}
	}

	@Override
	public String toString() {
		if(calendar==null){
			return "No calandar events have been scheduled";
		}
		return "CalendarManager: [" + calendar + "]";
	}


      public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = args[0];//"Compute";

            //Compute engine = new ComputeEngine();
            //Pi engine = new PiImpl();
            CalendarMgrIntr engine = new CalendarManager(calendar);


            //Compute stub =
            //Pi stub =
            CalendarMgrIntr stub =
                (CalendarMgrIntr) UnicastRemoteObject.exportObject(engine, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("ComputeEngine bound");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }

}
