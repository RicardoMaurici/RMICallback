package e_elanne_ricardoFerreira_05;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CallBack extends Remote {

    public void despertar(ClienteCallBack cliente) throws RemoteException;
    public void solicitarDespertar(Long lValue) throws RemoteException;
}
