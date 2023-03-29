package projetFinal.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Utilisateur {
	
	@Id
	private String eMail;
	private String nom;
	private String prenom;
	private String motDePasse;
	
	public Utilisateur() {
		
	}

	public Utilisateur(String nom, String prenom, String eMail, String motDePasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.eMail = eMail;
		this.motDePasse = motDePasse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEMail() {
		return eMail;
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Override
	public int hashCode() {
		return Objects.hash(eMail);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		return Objects.equals(eMail, other.eMail);
	}

}
