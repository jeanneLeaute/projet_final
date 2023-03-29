package projetFinal.entities;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
@AttributeOverride(name = "eMail", column = @Column(name="client_email"))
@AttributeOverride(name = "nom", column = @Column(name="client_nom"))
@AttributeOverride(name = "prenom", column = @Column(name="client_prenom"))
@AttributeOverride(name = "motDePasse", column = @Column(name="client_mot_de_passe"))
public class Client extends Utilisateur {
	
	@OneToMany(mappedBy = "client")
	private Set<Reservation> reservations;
	@OneToMany(mappedBy = "client")
	private Set<Commentaire> commentaires;
	
	
	public Client() {
		
	}


	public Client(String nom, String prenom, String eMail, String motDePasse, Set<Reservation> reservations, Set<Commentaire> commentaires) {
		super(nom, prenom, eMail, motDePasse);
		this.reservations = reservations;
		this.commentaires = commentaires;
	}


	public Set<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}


	public Set<Commentaire> getCommentaires() {
		return commentaires;
	}


	public void setCommentaires(Set<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

}
