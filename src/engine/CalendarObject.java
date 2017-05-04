package engine;

import java.util.LinkedList;
import compute.CalendarObjIntr;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.io.Serializable;

public class CalendarObject implements CalendarObjIntr, Serializable{
	
	private String name;
	private LinkedList<EventObj> event;
	private static final long serialVersionUID = 227L;
	
	public CalendarObject() {
		super();
		
	}
	
	public CalendarObject(String name, LinkedList<EventInterface> event) {
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
	
	public LinkedList<EventInterface> getEvent() {
		return event;
	}

	public void setEvent(LinkedList<EventInterface> event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Calendar: [Name: " + name + ", Event: " + event + "]";
	}
	
	
}