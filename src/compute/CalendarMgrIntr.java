package compute;

import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.rmi.Remote;
import java.rmi.RemoteException;
import compute.CalendarObjIntr;
import compute.EventInterface;

public interface CalendarMgrIntr<T, E> extends Remote {

	public LinkedList<T> getCalendar() throws RemoteException;

	public void setCalendar(LinkedList<T> calendar) throws RemoteException;
	public boolean checkUserExist(String username) throws RemoteException;

	public LinkedList<E> retrieveOthersEvent(String user, Calendar startDate, Calendar endDate) throws RemoteException;

	public T createCalendarObject(String createNewClientName) throws RemoteException;
	
	public E createEvent(Calendar scheduleStartDateInput, Calendar scheduleEndDateInput, 
			String descriptionScheduleInput, String accessControlScheduleInput) throws RemoteException;
	
	public LinkedList<E> retrieveOwnEvent(String user, Calendar startDate, Calendar endDate) throws RemoteException;

	public void scheduleEvent(LinkedList<String> name, E newEvent) throws RemoteException;

	public void calandarItr() throws RemoteException;

	public LinkedList<E> deleteOthersEvent(String user, Calendar startDate, Calendar endDate) throws RemoteException;
	
	public LinkedList<E> deleteOwnEvent(String user, Calendar startDate, Calendar endDate) throws RemoteException;
	
//	public String toString() throws RemoteException;

}
