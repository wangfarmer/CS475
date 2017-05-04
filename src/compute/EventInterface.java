package compute;

import java.util.Calendar;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EventInterface extends Remote {

	public Calendar getStartDate() throws RemoteException;

	public void setStartDate(Calendar startDate) throws RemoteException;

	public Calendar getEndDate() throws RemoteException;
	

	public void setEndDate(Calendar endDate) throws RemoteException;
	
	public String getDescription() throws RemoteException;

	public void setDescription(String description) throws RemoteException;
	
	public String getAccessControl() throws RemoteException;

	public void setAccessControl(String accessControl) throws RemoteException;
	
	
	//public String toString() throws RemoteException;
}
