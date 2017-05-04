package compute;

import java.util.LinkedList;
import compute.EventInterface;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalendarObjIntr extends Remote {
	


	public String getName() throws RemoteException;

	public void setName(String name) throws RemoteException;
	
	public LinkedList<EventInterface> getEvent() throws RemoteException;

	public void setEvent(LinkedList<EventInterface> event) throws RemoteException;
	
	//public String toString() throws RemoteException;
	
}