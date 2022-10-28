
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Serveur extends UnicastRemoteObject implements  Rmi {
    
public Serveur()throws RemoteException{
    super();
}
    @Override
    public String getData(String text) throws RemoteException {
      text = "Mi " + text ; 
      return text ;
    }

    public static void main(String[] args) {
     try{
         Registry reg= LocateRegistry.createRegistry(1019);
  reg.rebind(" Mr Serveur ", new Serveur());
  System.out.println(" Serveur commence  !!! ");
     }  catch(RemoteException e ){
    System.out.println(e);
}
    }
    
    
    
}
