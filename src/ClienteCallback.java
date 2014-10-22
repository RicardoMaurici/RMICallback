import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteCallback implements Cliente, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteCallback() {
        try {
            Registry registry = LocateRegistry.getRegistry(
                    "localhost",
                    (new Integer(1091)).intValue());
            CallBack obj = (CallBack) registry.lookup("CallBack");
            System.out.println("Mensagem do Servidor: " + obj.programar(this, 1000l));
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {

        new ClienteCallback();

    }

    @Override
    public void despertar() throws RemoteException {
        System.out.println("Despertador est‡ tocando!");

    }
}
