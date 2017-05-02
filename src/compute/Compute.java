package compute;

import java.rmi.Remote;
import java.rmi.RemoteException;
import compute.Task;
import java.math.BigDecimal;

public interface Compute extends Remote {
      BigDecimal executeTask(int digits) throws RemoteException;
      BigDecimal retrieveInfo(Pi t) throws RemoteException;
}