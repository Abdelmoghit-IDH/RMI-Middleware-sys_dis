package tp.metier;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Compte implements Serializable {
	public int code;
	public double solde;
	public Date dateCreation;
	
	public Compte(int code,double solde,Date dateCreation){
		this.code = code;
		this.dateCreation = dateCreation;
		this.solde = solde;
	}
	
	// Getters and setters
	public int getCode() {
		return this.code;
	}
	
	public void setCode(int newCode){
		this.code = newCode;
	}
	
	public double getSolde() {
		return this.solde;
	}
	
	public void setSolde(double newSolde) {
		this.solde = newSolde;
	}
	
	public Date getDateCreation(){
		return this.dateCreation;
	}
	
	public void setDateCreation(Date newDateCreation){
		this.dateCreation = newDateCreation;
	}
}
