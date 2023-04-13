package ajc.formation.soprasteria.projetFinal.entities;

import java.util.Objects;

import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.projetFinal.entities.views.JsonViews;

@MappedSuperclass
public abstract class Utilisateur {
	
	@Id
	@JsonView(JsonViews.Simple.class)
	private String eMail;
	@JsonView(JsonViews.Simple.class)
	private String nom;
	@JsonView(JsonViews.Simple.class)
	private String prenom;
	@JsonView(JsonViews.Simple.class)
	private String motDePasse;
	@OneToOne
	@JoinColumn(name = "utilisateur_compte_id", foreignKey = @ForeignKey(name = "utilisateur_compte_id_fk"))
	@JsonView(JsonViews.UtilisateurWithCompte.class)
	private Compte compte;
	
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

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
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