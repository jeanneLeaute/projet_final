package projetFinal.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "commentaire")
@IdClass(ClientRestaurantKey.class)
public class Commentaire {
	
	
	@Column(name = "texte")
	private String texte;
	
	
	@Id
	@ManyToOne
	@JoinColumn(name="client",foreignKey = @ForeignKey(name="client_fk"))
	private Client client;
	
	@Id
	@ManyToOne
	@JoinColumn(name="restaurant",foreignKey = @ForeignKey(name="client_fk"))
	private Restaurant restaurant;

	public Commentaire() {

	}

	public Commentaire(String texte) {
		super();
		this.texte = texte;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	@Override
	public int hashCode() {
		return Objects.hash(client, restaurant);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commentaire other = (Commentaire) obj;
		return Objects.equals(client, other.client) && Objects.equals(restaurant, other.restaurant);
	}
	
}
