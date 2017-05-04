package compute;

import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.rmi.Remote;
import java.rmi.RemoteException;
import compute.CalendarObjIntr;
import compute.EventInterface;

public interface CalendarMgrIntr extends Remote {

	public LinkedList<CalendarObjIntr> getCalendar() throws RemoteException;

	public void setCalendar(LinkedList<CalendarObjIntr> calendar) throws RemoteException;

	public LinkedList<EventInterface> retrieveOthersEvent(String user, Calendar startDate, Calendar endDate) throws RemoteException;


	public LinkedList<EventInterface> retrieveOwnEvent(String user, Calendar startDate, Calendar endDate) throws RemoteException;

	public void scheduleEvent(LinkedList<String> name, EventInterface newEvent) throws RemoteException;

	public void calandarItr() throws RemoteException;

	
//	public String toString() throws RemoteException;

}
