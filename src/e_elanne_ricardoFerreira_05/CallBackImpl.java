package e_elanne_ricardoFerreira_05;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CallBackImpl extends java.rmi.server.UnicastRemoteObject implements CallBack{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CallBackImpl() throws java.rmi.RemoteException { 
	        super();
	}
	
	@Override
	public void despertar(ClienteCallBack cliente) throws RemoteException {
		CallbackProcessor processor = new CallbackProcessor(cliente);
		processor.start();

	}

	@Override
	public void solicitarDespertar(Long lValue) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	class CallbackProcessor extends Thread {

        private ClienteCallBack _Client;

        public CallbackProcessor(ClienteCallBack client) {
            _Client = client;
        }

        public void run() {
            System.out.println("Vou esperar 3 segundos para avisar!");
            try {
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CallBackImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            _Client.acordar();
        }
	}
}
