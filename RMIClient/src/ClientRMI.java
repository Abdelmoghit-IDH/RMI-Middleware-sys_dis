import java.rmi.Naming;
import java.util.List;

import tp.metier.Compte;
import tp.rmi.BanqueRMIService;

public class ClientRMI {

	public static void main(String[] args) {
		try {
            // looks up the registry by service name and returns a stub
            BanqueRMIService banqueRMIService = (BanqueRMIService) Naming.lookup("rmi://172.27.48.1/BanqueRMIService");
            //afficher tous les comptes disponible
            System.out.println("affichage de tous les comptes disponible");
            List<Compte> listCompte = banqueRMIService.listComptes();
            
            for(Compte element : listCompte) {
            	System.out.println("Le code du compte est " + element.code);
            	System.out.println("Le solde du compte est " + element.solde);
            	System.out.println("La dateCreation du compte est " + element.dateCreation);
            }
            
            // Accés au compte numéro 2 comme exemple
            System.out.println("Accés au compte numéro 2 comme exemple");
            Compte compteInfo = banqueRMIService.consulterCompte(2);
            
            System.out.println("Le code du compte est " + compteInfo.code);
        	System.out.println("Le solde du compte est " + compteInfo.solde);
        	System.out.println("La dateCreation du compte est " + compteInfo.dateCreation);
            
            // conversion
        	System.out.println("La fonction conversion de l'interface BanqueRMIService");
            double solde = banqueRMIService.conversion(120);
            System.out.println("Le solde du compte 1 est : " + solde);
            
        } catch (Exception e) {
            System.err.println("BanqueRMIService > RemoteDate exception: " + e.getMessage());
            e.printStackTrace();
        }
	}
}


