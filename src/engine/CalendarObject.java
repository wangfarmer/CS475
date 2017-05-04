package engine;

import java.util.LinkedList;
import compute.CalendarObjIntr;
import compute.EventInterface;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.io.Serializable;

public class CalendarObject implements CalendarObjIntr<EventObj>, Serializable{
	
	private String name;
	private LinkedList<EventObj> event;
	private static final long serialVersionUID = 227L;
	
	public CalendarObject() {
		//super();
		
	}
	
	public CalendarObject(String name, LinkedList<EventObj> event) {
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
	
	public LinkedList<EventObj> getEvent() {
		return event;
	}

	public void setEvent(LinkedList<EventObj> event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Calendar: [Name: " + name + ", Event: " + event + "]";
	}
	
	
}