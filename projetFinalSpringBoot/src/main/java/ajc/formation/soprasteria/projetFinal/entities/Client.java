package ajc.formation.soprasteria.projetFinal.entities;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.projetFinal.entities.views.JsonViews;

@Entity
@Table(name = "client")
@AttributeOverride(name = "id", column = @Column(name="client_id"))
@AttributeOverride(name = "nom", column = @Column(name="client_nom"))
@AttributeOverride(name = "prenom", column = @Column(name="client_prenom"))
@AttributeOverride(name = "login", column = @Column(name="client_login"))
@AttributeOverride(name = "password", column = @Column(name="client_password"))
@AttributeOverride(name = "role", column = @Column(name="client_role"))
public class Client extends Utilisateur {
	
	@OneToMany(mappedBy = "client")
	@JsonView(JsonViews.ClientWithReservation.class)
	private Set<Reservation> reservations;
	@OneToMany(mappedBy = "client")
	@JsonView(JsonViews.ClientWithCommentaire.class)
	private Set<Commentaire> commentaires;
	
	public Client() {
		
	}

	public Client(Long id, String nom, String prenom, String login, String password, Role role,
			Set<Reservation> reservations, Set<Commentaire> commentaires) {
		super(id, nom, prenom, login, password, role);
		this.reservations = reservations;
		this.commentaires = commentaires;
	}

	public Client(String nom, String prenom, String login, String password, Role role, Set<Reservation> reservations,
			Set<Commentaire> commentaires) {
		super(nom, prenom, login, password, role);
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
