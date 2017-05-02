package calendar;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.Scanner;

public class EventObject {
	
	
	/*
	private int hourStart;
	private int minStart;
	
	private int hourEnd;
	private int minEnd;
	*/
	private LinkedList<String> name;
	private Calendar startDate;
	private Calendar endDate;
	private String description;
	private String accessControl;
	/*int hourStart, int minStart, int yearEnd,
	int hourEnd, int minEnd*/
	
	public EventObject(){
		super();
	}
	public EventObject(LinkedList<String> name, Calendar startDate, Calendar endDate, String description, String accessControl) {
		
		this.name = name;
		/*
		this.hourStart = hourStart;
		this.minStart = minStart;
		this.hourEnd = hourEnd;
		this.minEnd = minEnd;
		*/
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

	

	/*

	public int getHourStart() {
		return hourStart;
	}

	public void setHourStart(int hourStart) {
		this.hourStart = hourStart;
	}

	public int getMinStart() {
		return minStart;
	}

	public void setMinStart(int minStart) {
		this.minStart = minStart;
	}

	public int getHourEnd() {
		return hourEnd;
	}

	public void setHourEnd(int hourEnd) {
		this.hourEnd = hourEnd;
	}

	public int getMinEnd() {
		return minEnd;
	}

	public void setMinEnd(int minEnd) {
		this.minEnd = minEnd;
	}*/

	public LinkedList<String> getName() {
		return name;
	}

	public void setName(LinkedList<String> name) {
		this.name = name;
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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<String> nameInput = new LinkedList<String>();
		
		int hourStartInput;
		int minStartInput;
		
		int hourEndInput;
		int minEndInput;
		String descriptionInput;
		String accessControlInput;
		System.out.print("Your name:\t");
		nameInput.add (sc.nextLine());		
		
		/* Start Times*/
		System.out.print("Start Hour:\t");
		hourStartInput = sc.nextInt();
		sc.nextLine();
		System.out.print("Start Minute:\t");
		minStartInput = sc.nextInt();
		sc.nextLine();
		
		/*End Times */
		System.out.print("End Hour:\t");
		hourEndInput = sc.nextInt();
		sc.nextLine();
		System.out.print("End Minute:\t");
		minEndInput = sc.nextInt();
		sc.nextLine();
		System.out.print("Description of Event:\t");
		descriptionInput = sc.nextLine();
		System.out.print("Access Type (Private/ Public/ Group/ Open):\t");
		accessControlInput = sc.nextLine();
		
		Calendar startDateInput = Calendar.getInstance();
		startDateInput.set(yearStartInput,monthStartInput,dateStartInput,hourStartInput,minStartInput);
		Calendar endDateInput = Calendar.getInstance();
		endDateInput.set(yearEndInput,monthEndInput,dateEndInput,hourEndInput,minEndInput);
		
		EventObject newUser = new EventObject(nameInput,startDateInput,endDateInput,descriptionInput,accessControlInput);
		System.out.println("Name:\t" +newUser.getName());
		System.out.println("Start Time:\t" +newUser.getStartDate().getWeekYear());
		System.out.println("End Time:\t" +newUser.getEndDate().getWeekYear());
		System.out.println("Description:\t" +newUser.getDescription());
		System.out.println("Access Type:\t" +newUser.getAccessControl());
		
	}
	
}
