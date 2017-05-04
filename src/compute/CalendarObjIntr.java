package compute;

import java.util.LinkedList;
import compute.EventInterface;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalendarObjIntr<T> extends Remote {
	


	public String getName() throws RemoteException;

	public void setName(String name) throws RemoteException;
	
	public LinkedList<T> getEvent() throws RemoteException;

	public void setEvent(LinkedList<T> event) throws RemoteException;
	
	//public String toString() throws RemoteException;
	
}