package e_elanne_ricardoFerreira_05;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Cliente extends Remote {

    public void despertar(Long lValue) throws RemoteException;
}

