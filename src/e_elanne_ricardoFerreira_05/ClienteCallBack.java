package e_elanne_ricardoFerreira_05;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClienteCallBack implements Serializable {

	private static final long serialVersionUID = 1L;

	public ClienteCallBack(String[] args) {
		String serverName;
		
        if (args.length == 0)
        	serverName = "127.0.0.1";
        else
        	serverName = args[0];
        String rmiName = "rmi://" + serverName + "/ServidorDespertar";

        System.out.println ("Conecta com: " + rmiName);

        try { 
        	CallBack obj= (CallBack) Naming.lookup(rmiName);
        	System.out.println("AAAA");
        	obj.despertar(this);        
        }catch (MalformedURLException murle) { 
                System.out.println(); 
                System.out.println(
                  "MalformedURLException"); 
                System.out.println(murle); 
            } 
            catch (RemoteException re) { 
                System.out.println(); 
                System.out.println(
                            "RemoteException"); 
                System.out.println(re); 
            } 
            catch (NotBoundException nbe) { 
                System.out.println(); 
                System.out.println(
                           "NotBoundException"); 
                System.out.println(nbe); 
            } 
            catch (
                java.lang.ArithmeticException
                                          ae) { 
                System.out.println(); 
                System.out.println(
                 "java.lang.ArithmeticException"); 
                System.out.println(ae); 
            } 
    }

    public static void main(String[] args) {
      	new ClienteCallBack(args);

    }

	public void acordar() {
		System.out.println("Acordei cliente " + this.toString());
		
	}

}

