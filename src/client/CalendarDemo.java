package client;

import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Scanner;
import compute.CalendarMgrIntr;
import compute.CalendarObjIntr;
import compute.EventInterface;

public class CalendarDemo {
	public static void main(String[] args) {

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			String name = args[1];//"Compute";
			Registry registry = LocateRegistry.getRegistry(args[0]);

			// Compute comp = (Compute) registry.lookup(name);

			//LinkedList<CalendarObject> baseCalendarList = new LinkedList<CalendarObject>();

			//CalendarManager newManager = new CalendarManager(baseCalendarList);
			CalendarMgrIntr newManager = null;

			newManager = (CalendarMgrIntr) registry.lookup(name);


			Scanner sc = new Scanner(System.in);
			String checkNewClient;
			boolean checkInsertStatus = true;
			while(checkInsertStatus){
				System.out.print("Create a new client? (Yes/No)\t");
				checkNewClient = sc.nextLine();
				switch(checkNewClient.toLowerCase()){
				case "yes":
					System.out.print("What's client's name?\t");
					String createNewClientName = sc.nextLine();

					boolean checkNewUserExit = false;
					for (CalendarObjIntr e : newManager.getCalendar()){
						if(e.getName().equalsIgnoreCase(createNewClientName)){
							checkNewUserExit = true;
						}
					}
					if(checkNewUserExit == false){
                                            //LinkedList<EventObj> createNewEvent = new LinkedList<EventObj>();
                                            //	CalendarObject createNewCalendar = new CalendarObject(createNewClientName, createNewEvent);

                                            // newManager.getCalendar().add(createNewCalendar);
                                                newManager.getCalendar().add(newManager.createCalendarObject(createNewClientName));
					}else{
						System.out.println("Creating Client Alice failed, Client "+ createNewClientName + " already exists");
					}
					break;
				case "no":
					checkInsertStatus = false;
					break;
				default:
					System.out.println("Invalid Input. Please only type \"Yes\" or \"No\"");
					break;
				}
			}

			String actionType;
			String userNameInput;
			while(true){
				System.out.print("Log in, Your name:\t");
				userNameInput = sc.nextLine();
				boolean checkLoginStatus = true;
				while(checkLoginStatus){
					boolean checkActionStatus = true;
					while(checkActionStatus){
						System.out.print("What do you want to do? (Display/Schedule/Delete/Exit)\t");
						actionType = sc.nextLine();
						switch(actionType.toLowerCase()){
						case "display":
							System.out.print("Who do you want to display (You can type a name or hit \"Enter\" to display your own information):\t");
							String nameRetrieveInput = sc.nextLine();
							if(nameRetrieveInput.equals("")){
								nameRetrieveInput = userNameInput;
							}

							System.out.print("Starting-Hour you want to display :\t");
							int hourRetrieveStartInput = sc.nextInt();
							sc.nextLine();
							System.out.print("Starting-Minute you want to display :\t");
							int minRetrieveStartInput = sc.nextInt();
							sc.nextLine();
							System.out.print("Ending-Hour you want to display :\t");
							int hourRetrieveEndInput = sc.nextInt();
							sc.nextLine();
							System.out.print("Ending-Minute you want to display :\t");
							int minRetrieveEndInput = sc.nextInt();
							sc.nextLine();

							Calendar retrieveStartDateInput = Calendar.getInstance();
							retrieveStartDateInput.set(2017,5,4,hourRetrieveStartInput,minRetrieveStartInput);
							Calendar retrieveEndDateInput = Calendar.getInstance();
							retrieveEndDateInput.set(2017,5,4,hourRetrieveEndInput,minRetrieveEndInput);


							try{
								if(nameRetrieveInput.equalsIgnoreCase(userNameInput)){
									LinkedList<EventInterface> testRetrieve2 = newManager.retrieveOwnEvent(nameRetrieveInput, retrieveStartDateInput, retrieveEndDateInput);
									System.out.println(nameRetrieveInput + "'s events list:");
									System.out.println(testRetrieve2.toString());
								}else{
									LinkedList<EventInterface> testRetrieve2 = newManager.retrieveOthersEvent(nameRetrieveInput, retrieveStartDateInput, retrieveEndDateInput);
									System.out.println(nameRetrieveInput + "'s group and public events list:");
									System.out.println(testRetrieve2.toString());
								}

							}catch(Exception e){

							}
							checkActionStatus = false;
							break;
						case "schedule":
							boolean checkForInput = false;
							int hourScheduleStartInput =0;
							int minScheduleStartInput =0;
							int hourScheduleEndInput =0;
							int minScheduleEndInput =0;
							String descriptionScheduleInput ="";
							String accessControlScheduleInput ="";
							LinkedList<String> nameScheduleInputList = new LinkedList<String>();
							while(!checkForInput){

								System.out.print("who do you want to schedule? (seperate names by \",\" ,hit \"Enter\" for finishing typing. Type nothing if scheduling for yourself)\t");
								String nameScheduleInput = sc.nextLine();
								if(nameScheduleInput.equals("")){
									nameScheduleInputList.add(userNameInput);
								}else{
									nameScheduleInputList = new LinkedList<String>(Arrays.asList(nameScheduleInput.split(",")));
								}
								do{
									System.out.print("Access Type (Private/ Public/ Group/ Open):\t");
									accessControlScheduleInput = sc.nextLine();
									if(!(accessControlScheduleInput.equalsIgnoreCase("Private")||accessControlScheduleInput.equalsIgnoreCase("Public")||accessControlScheduleInput.equalsIgnoreCase("Group")||accessControlScheduleInput.equalsIgnoreCase("Open"))){
										System.out.println("You can only type \"Private\" or \"Public\" or \"Group\" or \"Open\"");
									}
								}while(!(accessControlScheduleInput.equalsIgnoreCase("Private")||accessControlScheduleInput.equalsIgnoreCase("Public")||accessControlScheduleInput.equalsIgnoreCase("Group")||accessControlScheduleInput.equalsIgnoreCase("Open")));

								if(accessControlScheduleInput.equalsIgnoreCase("Private") && !nameScheduleInput.equalsIgnoreCase(userNameInput)){
									System.out.println("You can only schedule group events for other people! Please reschedule event!");
									checkForInput = false;
								}else if(accessControlScheduleInput.equalsIgnoreCase("public") && !nameScheduleInput.equalsIgnoreCase(userNameInput)){
									System.out.println("You can only schedule group events for other people! Please reschedule event!");
									checkForInput = false;
								}else{
									checkForInput = true;
								}
							}
							System.out.print("Starting-Hour you want to schedule :\t");
							hourScheduleStartInput = sc.nextInt();
							sc.nextLine();
							System.out.print("Starting-Minute you want to schedule :\t");
							minScheduleStartInput = sc.nextInt();
							sc.nextLine();
							System.out.print("Ending-Hour you want to schedule :\t");
							hourScheduleEndInput = sc.nextInt();
							sc.nextLine();
							System.out.print("Ending-Minute you want to schedule :\t");
							minScheduleEndInput = sc.nextInt();
							sc.nextLine();
							System.out.print("Description of Event:\t");
							descriptionScheduleInput = sc.nextLine();


							Calendar scheduleStartDateInput = Calendar.getInstance();
							scheduleStartDateInput.set(2017,5,4,hourScheduleStartInput,minScheduleStartInput);
							Calendar scheduleEndDateInput = Calendar.getInstance();
							scheduleEndDateInput.set(2017,5,4,hourScheduleEndInput,minScheduleEndInput);
                                                        //////////////////////////////////////////////////////////////////////
                                                        //need to change to server side/////////
							EventInterface newEvent = newManager.createEvent(scheduleStartDateInput,scheduleEndDateInput,descriptionScheduleInput,accessControlScheduleInput);
							try{
								newManager.scheduleEvent(nameScheduleInputList,newEvent);

							}catch(Exception e){

							}
							checkActionStatus = false;
							break;
						case "delete":
							System.out.print("Who do you want to delete (You can type a name or hit \"Enter\" to retrieve your own information):\t");
							String nameDeleteInput = sc.nextLine();
							if(nameDeleteInput.equals("")){
								nameDeleteInput = userNameInput;
							}

							System.out.print("Starting-Hour you want to delete :\t");
							int hourDeleteStartInput = sc.nextInt();
							sc.nextLine();
							System.out.print("Starting-Minute you want to delete :\t");
							int minDeleteStartInput = sc.nextInt();
							sc.nextLine();
							System.out.print("Ending-Hour you want to delete :\t");
							int hourDeleteEndInput = sc.nextInt();
							sc.nextLine();
							System.out.print("Ending-Minute you want to delete :\t");
							int minDeleteEndInput = sc.nextInt();
							sc.nextLine();

							Calendar DeleteStartDateInput = Calendar.getInstance();
							DeleteStartDateInput.set(2017,5,4,hourDeleteStartInput,minDeleteStartInput);
							Calendar DeleteEndDateInput = Calendar.getInstance();
							DeleteEndDateInput.set(2017,5,4,hourDeleteEndInput,minDeleteEndInput);

							try{
								if(nameDeleteInput.equalsIgnoreCase(userNameInput)){
									LinkedList<EventInterface> testDelete2 = newManager.deleteOwnEvent(nameDeleteInput, DeleteStartDateInput, DeleteEndDateInput);
									System.out.println(nameDeleteInput + "'s eventlist:");
									System.out.println(testDelete2.toString());
								}else{
									LinkedList<EventInterface> testDelete2 = newManager.deleteOthersEvent(nameDeleteInput, DeleteStartDateInput, DeleteEndDateInput);
									System.out.println(nameDeleteInput + "'s group and public event-list:");
									System.out.println(testDelete2.toString());
								}

							}catch(Exception e){

							}
							checkActionStatus = false;
							break;
						case "exit":
							checkActionStatus = false;
							checkLoginStatus = false;
							break;
						default:
							System.out.println("You can only type \"retrieve\" or \"schedule\" or \"exit\" or \"delete\"");
							checkActionStatus = true;
							break;
						}

						//System.out.println(newManager.toString());

					}
				}
			}


			//	System.out.println(name);
			// //Pi task = null;//new PiImpl(Integer.parseInt(args[3]));



			// BigDecimal pi = task.execute(4);

			// BigDecimal test = task.retrieve();

			// System.out.println("setting: " + pi);
			// System.out.println("retrieving: " + test);



		} catch (Exception e) {
			System.err.println("ComputePi exception:");
			e.printStackTrace();
		}


	}



}
