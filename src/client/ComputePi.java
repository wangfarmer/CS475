package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.math.BigDecimal;
import compute.Compute;

public class ComputePi {
    public static void main(String args[]) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = args[1];//"Compute";
             Registry registry = LocateRegistry.getRegistry(args[0]);

             Compute comp = (Compute) registry.lookup(name);


            /* get command from user*/
            String command = args[2];
            switch(command) {
                case "retrieve-event" :
                    //retrive-event <user> <starttime> <endtime> <date>
                    //call to registry will retrieve obj, then use time to lookup event from list
                    //return all event info
                    System.out.println("retrieve-event");
                    break;
            	case "schedule-event" :
                    //schedule-event <userlist> <starttime> <endtime> <description> <access-control>
                    //pass in userlist to registry to retrieve their calendar objs
                    //check time
                    //if no userlist, make event only in local calendar
                    //if schedule-event group
                    //check each user calendar for open space for time frame
                         //if a user does not have open time
                         //print err "could not add <user> to group. schedule conflict"

                    break;
            default:
                System.out.println("no command found");

            }

            System.out.println(name);
            Pi task = new Pi(Integer.parseInt(args[3]));
            BigDecimal pi = comp.executeTask(task);
            
            BigDecimal test = comp.retrieveInfo(task);
           
            System.out.println("setting: " + pi);
            System.out.println("retrieving: " + test);
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }
}
