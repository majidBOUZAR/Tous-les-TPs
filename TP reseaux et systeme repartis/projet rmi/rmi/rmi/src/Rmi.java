
import java.rmi.Remote;
import java.rmi.RemoteException;

 
public interface Rmi extends Remote {
public String getData(String text) throws RemoteException;
    
    
}
