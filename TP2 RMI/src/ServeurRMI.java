import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import tp.rmi.BanqueRMIService;

public class ServeurRMI {
	public static void main(String[] args) throws MalformedURLException {
		
		try {			
			LocateRegistry.createRegistry(1099);
			System.out.println("Le registre RMI s'exécute sur le port 1099");
			BanqueRMIService banqueRMIservice = new BanqueRMIService();
			System.out.print(banqueRMIservice);
			System.out.println("\nBinding BanqueRMIService...");
			Naming.rebind ("rmi://172.27.48.1/BanqueRMIService" , banqueRMIservice);
			System.out.println("BanqueRMIService est prêt.");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
} 	
