package tp.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tp.metier.Compte;

@SuppressWarnings("serial")
public class BanqueRMIService extends UnicastRemoteObject implements IBanqueRemote {
	
	List<Compte> listCompte= new ArrayList<Compte>();
	
	// date
	String pattern = "yyyy-MM-dd";
	
	public BanqueRMIService() throws RemoteException {
		super();
		
		Date date = null;
		try {
			    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			    date = (Date) simpleDateFormat.parse("2021-12-20");
		} catch (java.text.ParseException e) {
			        e.printStackTrace();
		}
			    
		// instance Compte
		Compte compte1 = new Compte(1,1002,date);
		Compte compte2 = new Compte(2,2001,date);
		Compte compte3 = new Compte(3,3132,date);
			   
		listCompte.add(compte1);
		listCompte.add(compte2);
		listCompte.add(compte3);
	}
	
		
	
	@Override
	public double conversion(double montant) throws RemoteException {
		double newSolde = 0;
		
		for (Compte element : listCompte) {
		    if(element.code == 1) {
		    	newSolde = element.solde - montant;
		    }
		}
		return newSolde;
	}

	@Override
	public Compte consulterCompte(int code) throws RemoteException {
		Compte compte = null;
		
		for (Compte element : listCompte) {
		    if(element.code == code) {
		    	compte = element;
		    }
		}
		return compte;
	}

	@Override
	public List<Compte> listComptes() throws RemoteException {
		return listCompte;
	}
}
