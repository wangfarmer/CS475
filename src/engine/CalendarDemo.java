package calendar;


import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Scanner;

public class CalendarDemo {
	public static void main(String[] args) {
		
		/*Calendar startDateInput = Calendar.getInstance();
		startDateInput.set(2017,5,4,0,0);
		Calendar endDateInput = Calendar.getInstance();
		endDateInput.set(2017,5,4,0,1);
		
		EventObj baseEvent = new EventObj(startDateInput,endDateInput,"Hello, World!","Public");
		LinkedList<EventObj> newEventList = new LinkedList<EventObj>();
		newEventList.add(baseEvent);
		
		CalendarObject newUser = new CalendarObject("Zifu", newEventList);*/
		LinkedList<CalendarObject> baseCalendarList = new LinkedList<CalendarObject>();
		//newCalendarList.add(newUser);
		CalendarManager newManager = new CalendarManager(baseCalendarList);
		
		//CalendarManager newManager = new CalendarManager();
		Scanner sc = new Scanner(System.in);
		//String nameRetrieveInput;
		//String nameScheduleInput;
		//LinkedList<String> nameScheduleInputList;
		String actionType;
		String userNameInput;
		/*int hourStartInput;
		int minStartInput;
		int hourEndInput;
		int minEndInput;*/
		/*String descriptionInput;
		String accessControlInput;*/
		System.out.print("Log in, Your name:\t");
		userNameInput = sc.nextLine();
		while(true){
			do{
				System.out.print("What do you want to do? (Retrieve/Schedule/Exit)\t");
				actionType = sc.nextLine();
				if(!(actionType.equalsIgnoreCase("retrieve")||actionType.equalsIgnoreCase("schedule")||actionType.equalsIgnoreCase("exit"))){
					System.out.println("You can only type \"retrieve\" or \"schedule\" or \"exit\"");
				}
			}while(!(actionType.equalsIgnoreCase("retrieve")||actionType.equalsIgnoreCase("schedule")||actionType.equalsIgnoreCase("exit")));
			
			
			if(actionType.equalsIgnoreCase("retrieve")){
				System.out.print("Who do you want to retrieve (You can type a name or hit \"Enter\" to retrieve your own information):\t");
				String nameRetrieveInput = sc.nextLine();
				if(nameRetrieveInput.equals("")){
					nameRetrieveInput = userNameInput;
				}
				
				System.out.print("Starting-Hour you want to retrieve :\t");
				int hourRetrieveStartInput = sc.nextInt();
				sc.nextLine();
				System.out.print("Starting-Minute you want to retrieve :\t");
				int minRetrieveStartInput = sc.nextInt();
				sc.nextLine();
				System.out.print("Ending-Hour you want to retrieve :\t");
				int hourRetrieveEndInput = sc.nextInt();
				sc.nextLine();
				System.out.print("Ending-Minute you want to retrieve :\t");
				int minRetrieveEndInput = sc.nextInt();
				sc.nextLine();
				
				Calendar retrieveStartDateInput = Calendar.getInstance();
				retrieveStartDateInput.set(2017,5,4,hourRetrieveStartInput,minRetrieveStartInput);
				Calendar retrieveEndDateInput = Calendar.getInstance();
				retrieveEndDateInput.set(2017,5,4,hourRetrieveEndInput,minRetrieveEndInput);
				
				
				
				
				try{
					if(nameRetrieveInput.equalsIgnoreCase(userNameInput)){
						LinkedList<EventObj> testRetrieve2 = newManager.retrieveOwnEvent(nameRetrieveInput, retrieveStartDateInput, retrieveEndDateInput);
						System.out.println(testRetrieve2.toString());
					}else{
						LinkedList<EventObj> testRetrieve2 = newManager.retrieveOthersEvent(nameRetrieveInput, retrieveStartDateInput, retrieveEndDateInput);
						System.out.println(testRetrieve2.toString());
					}
					
				}catch(Exception e){
					
				}
				
			}else if(actionType.equalsIgnoreCase("schedule")){
				LinkedList<String> nameScheduleInputList = new LinkedList<String>();
				System.out.print("who do you want to schedule? (seperate names by \",\" ,hit \"Enter\" for finishing typing. Type nothing if scheduling for yourself)\t");
				String nameScheduleInput = sc.nextLine();
				if(nameScheduleInput.equals("")){
					nameScheduleInputList.add(userNameInput);
				}else{
					nameScheduleInputList = new LinkedList<String>(Arrays.asList(nameScheduleInput.split(",")));
				}
				
				System.out.print("Starting-Hour you want to schedule :\t");
				int hourScheduleStartInput = sc.nextInt();
				sc.nextLine();
				System.out.print("Starting-Minute you want to schedule :\t");
				int minScheduleStartInput = sc.nextInt();
				sc.nextLine();
				System.out.print("Ending-Hour you want to schedule :\t");
				int hourScheduleEndInput = sc.nextInt();
				sc.nextLine();
				System.out.print("Ending-Minute you want to schedule :\t");
				int minScheduleEndInput = sc.nextInt();
				sc.nextLine();
				System.out.print("Description of Event:\t");
				String descriptionScheduleInput = sc.nextLine();
				String accessControlScheduleInput;
				do{
					System.out.print("Access Type (Private/ Public/ Group/ Open):\t");
					accessControlScheduleInput = sc.nextLine();
					if(!(accessControlScheduleInput.equalsIgnoreCase("Private")||accessControlScheduleInput.equalsIgnoreCase("Public")||accessControlScheduleInput.equalsIgnoreCase("Group")||accessControlScheduleInput.equalsIgnoreCase("Open"))){
						System.out.println("You can only type \"Private\" or \"Public\" or \"Group\" or \"Open\"");
					}
				}while(!(accessControlScheduleInput.equalsIgnoreCase("Private")||accessControlScheduleInput.equalsIgnoreCase("Public")||accessControlScheduleInput.equalsIgnoreCase("Group")||accessControlScheduleInput.equalsIgnoreCase("Open")));
				
				
				Calendar retrieveStartDateInput = Calendar.getInstance();
				retrieveStartDateInput.set(2017,5,4,hourScheduleStartInput,minScheduleStartInput);
				Calendar retrieveEndDateInput = Calendar.getInstance();
				retrieveEndDateInput.set(2017,5,4,hourScheduleEndInput,minScheduleEndInput);
				
				EventObj newEvent = new EventObj(retrieveStartDateInput,retrieveEndDateInput,descriptionScheduleInput,accessControlScheduleInput);
				try{
					newManager.scheduleEvent(nameScheduleInputList,newEvent);
				}catch(Exception e){
					
				}
				
			}else{
				System.exit(0);
			}
			System.out.println(newManager.toString());
			
		}
	}
		
}


/*System.out.print("Client name:\t");
nameInput = sc.nextLine();
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


Calendar startDateInput = Calendar.getInstance();
startDateInput.set(2017,5,4,hourStartInput,minStartInput);
Calendar endDateInput = Calendar.getInstance();
endDateInput.set(2017,5,4,hourEndInput,minEndInput);

EventObj newEvent = new EventObj(startDateInput,endDateInput,descriptionInput,accessControlInput);
LinkedList<EventObj> newEventList = new LinkedList<EventObj>();
newEventList.add(newEvent);

CalendarObject newUser = new CalendarObject(nameInput, newEventList);
LinkedList<CalendarObject> newCalendarList = new LinkedList<CalendarObject>();
newCalendarList.add(newUser);


System.out.println(newManager.toString());

Calendar TESTstartDateInput = Calendar.getInstance();
TESTstartDateInput.set(2017,5,4,3,0);
Calendar TESTendDateInput = Calendar.getInstance();
TESTendDateInput.set(2017,5,4,7,0);
EventObj TESTnewEvent = new EventObj(TESTstartDateInput,TESTendDateInput,"HEELO WORLD!!!","PUBLIC");

LinkedList<String> nameList = new LinkedList<String>();
nameList.add("Alice");
nameList.add("Bob");
nameList.add("Tom");

try{
	newManager.scheduleEvent(nameList,TESTnewEvent);
}catch(Exception e){
	
}


System.out.println(newManager.toString());


System.out.println("Start Time:\t" +newUser.getEvent()..getStartDate().getWeekYear());
System.out.println("End Time:\t" +newUser.getEndDate().getWeekYear());
System.out.println("Description:\t" +newUser.getDescription());
System.out.println("Access Type:\t" +newUser.getAccessControl());

ApiParameter apiParameter1 = new ApiParameter();
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
