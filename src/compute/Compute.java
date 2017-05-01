package compute;

import java.rmi.Remote;
import java.rmi.RemoteException;
import compute.Task;

public interface Compute extends Remote {
      <T> T executeTask(Task<T> t) throws RemoteException;
      <T> T retrieveInfo(Task<T> t) throws RemoteException;
}