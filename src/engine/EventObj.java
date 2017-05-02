package calendar;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.Scanner;

public class EventObj {
	
	
	/*private int yearStart;
	private int monthStart;
	private int dateStart;
	private int hourStart;
	private int minStart;
	private int yearEnd;
	private int monthEnd;
	private int dateEnd;
	private int hourEnd;
	private int minEnd;*/
	//private LinkedList<String> name;
	private Calendar startDate;
	private Calendar endDate;
	private String description;
	private String accessControl;
	/*, int yearStart, int monthStart, int dateStart, int hourStart, int minStart, int yearEnd,
	int monthEnd, int dateEnd, int hourEnd, int minEnd*/
	
	public EventObj(){
		super();
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
	
	public String toString() {
		return "[startDate=" + startDate + ", endDate=" + endDate + ", description=" + description
				+ ", accessControl=" + accessControl + "]";
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
		System.out.print("Start Hour:\t");
		hourStartInput = sc.nextInt();
		sc.nextLine();
		System.out.print("Start Minute:\t");
		minStartInput = sc.nextInt();
		sc.nextLine();
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
		startDateInput.set(2017,5,4,hourStartInput,minStartInput);
		Calendar endDateInput = Calendar.getInstance();
		endDateInput.set(2017,5,4,hourEndInput,minEndInput);
		
		EventObj newUser = new EventObj(startDateInput,endDateInput,descriptionInput,accessControlInput);
		
		System.out.println("Start Time:\t" +newUser.getStartDate().getWeekYear());
		System.out.println("End Time:\t" +newUser.getEndDate().getWeekYear());
		System.out.println("Description:\t" +newUser.getDescription());
		System.out.println("Access Type:\t" +newUser.getAccessControl());
		
		/*ApiParameter apiParameter1 = new ApiParameter();
		apiParameter1.setName("service");
		apiParameter1.setRequired(true);
		apiParameter1.setDescription("xxxx");
	
		ApiParameter apiParameter2 = new ApiParameter();
		apiParameter2.setName("STARTDA");
		apiParameter2.setRequired(false);
		apiParameter2.setDescription("xxxx");
		
		List<ApiParameter> list = new ArrayList<>();
		list.add(apiParameter1);
		list.add(apiParameter2);
		
		System.out.println(new Gson().toJson(list));*/
		
	}
	
}
