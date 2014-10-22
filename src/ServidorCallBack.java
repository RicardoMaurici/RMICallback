import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServidorCallBack extends UnicastRemoteObject implements CallBack {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ServidorCallBack() throws RemoteException {
        super();

    }

    @Override
    public String programar(Cliente c, Long l) throws RemoteException {
        CallbackProcessor processor = new CallbackProcessor(l, c);
        processor.start();
        return "Pedido registrado. Será atendido no horário solicitado.";
    }

    class CallbackProcessor extends Thread {

        private Long l;
        private Cliente c;

        public CallbackProcessor(Long l, Cliente c) {
            this.c = c;
            this.l = l;

        }

        public void run() {

            try {
                Thread.sleep(l);
                c.despertar();
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1091);
            ServidorCallBack objeto = new ServidorCallBack();
            registry.rebind("CallBack", objeto);
        } catch (Exception ex) {
            System.out.println("Exceção: " + ex.getMessage());
        }

    }
}
