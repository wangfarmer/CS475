package engine;

import java.util.Calendar;
import compute.EventInterface;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.io.Serializable;

public class EventObj implements EventInterface, Serializable{

	private Calendar startDate;
	private Calendar endDate;
	private String description;
	private String accessControl;
	private static final long serialVersionUID = 227L;

	public EventObj(){
		//super();
	}
	public EventObj(Calendar startDate, Calendar endDate, String description, String accessControl) {


		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.accessControl = accessControl;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAccessControl() {
		return accessControl;
	}

	public void setAccessControl(String accessControl) {
		this.accessControl = accessControl;
	}

	@Override
	public String toString() {
		return "[Start Time: " + startDate.getTime().toString() + ", End Time: " + endDate.getTime().toString() + ", description: " + description
				+ ", Access Control: " + accessControl + "]";
	}

}
