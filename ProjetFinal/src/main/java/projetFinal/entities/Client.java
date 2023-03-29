package projetFinal.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client extends Utilisateur {
	
	private Set<Reservation> reservations;
	private Set<Commande> commandes;
	private Set<Commentaire> commentaires;
	
	
	public Client() {
		
	}


	public Client(String nom, String prenom, String eMail, String motDePasse, Set<Reservation> reservations,
			Set<Commande> commandes, Set<Commentaire> commentaires) {
		super(nom, prenom, eMail, motDePasse);
		this.reservations = reservations;
		this.commandes = commandes;
		this.commentaires = commentaires;
	}


	public Set<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}


	public Set<Commande> getCommandes() {
		return commandes;
	}


	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}


	public Set<Commentaire> getCommentaires() {
		return commentaires;
	}


	public void setCommentaires(Set<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

}
