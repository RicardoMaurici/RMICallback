package e_elanne_ricardoFerreira_05;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public final class ServidorCallBack {
    public ServidorCallBack() {
        try {
            CallBack m = new CallBackImpl();
            Registry registry = LocateRegistry.createRegistry(1109);
            registry.bind("localhost", m);
            Naming.rebind("rmi://localhost:1104/ServidorDespertar", m);
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Servidor aguardando solicitando");
        new ServidorCallBack();
    }

}
