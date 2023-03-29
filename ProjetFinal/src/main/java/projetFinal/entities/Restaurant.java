package projetFinal.entities;

import java.util.Objects;
import java.util.Set;

public class Restaurant {
	private long email;
	private String nom;
	private Adresse adresse;
	private long description;
	private String horaireOuverture;
	private String urlImage;
	private Set<ItemMenu> menu;
	private boolean aEmporter;
	private boolean peutReserver;
	private Set<Commentaire> commentaires;
	private Set<Categorie> categories;
	
	
	
	
	public Restaurant() {
		super();
	}
	
	
	
	public Restaurant(long email, String nom, projetFinal.entities.Adresse adresse, long description,
			String horaireOuverture, String urlImage, boolean aEmporter, boolean peutReserver,
			Set<Commentaire> commentaires, Set<Categorie> categories) {
		super();
		this.email = email;
		this.nom = nom;
		this.adresse = adresse;
		this.description = description;
		this.horaireOuverture = horaireOuverture;
		this.urlImage = urlImage;
		this.aEmporter = aEmporter;
		this.peutReserver = peutReserver;
		this.commentaires = commentaires;
		this.categories = categories;
	}



	public long getEmail() {
		return email;
	}
	public void setEmail(long email) {
		this.email = email;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		adresse = adresse;
	}
	public long getDescription() {
		return description;
	}
	public void setDescription(long description) {
		this.description = description;
	}
	public String getHoraireOuverture() {
		return horaireOuverture;
	}
	public void setHoraireOuverture(String horaireOuverture) {
		this.horaireOuverture = horaireOuverture;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public boolean isaEmporter() {
		return aEmporter;
	}
	public void setaEmporter(boolean aEmporter) {
		this.aEmporter = aEmporter;
	}
	public boolean isPeutReserver() {
		return peutReserver;
	}
	public void setPeutReserver(boolean peutReserver) {
		this.peutReserver = peutReserver;
	}
	public Set<Commentaire> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(Set<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	public Set<Categorie> getCategories() {
		return categories;
	}
	public void setCategories(Set<Categorie> categories) {
		this.categories = categories;
	}



	@Override
	public int hashCode() {
		return Objects.hash(email);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		return email == other.email;
	}
	
	
	
	
	
	
	

}
