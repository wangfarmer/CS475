package engine;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import compute.Compute;
import compute.Task;
import compute.Pi;
import java.math.BigDecimal;
import engine.PiImpl;

public class ComputeEngine implements Compute, Pi {

    public ComputeEngine() {
        super();
    }

    public BigDecimal executeTask(int digits) {
 
        return this.execute(digits);
    }
    
    public BigDecimal retrieveInfo(Pi t){
    	return t.retrieve();
    }

 
}