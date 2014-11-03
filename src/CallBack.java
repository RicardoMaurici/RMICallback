
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface CallBack extends Remote {

    public String programar(Cliente cliente, Long l) throws RemoteException;
}
