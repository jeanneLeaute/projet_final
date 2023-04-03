package projetFinal.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, length = 255)
	private Long id;
	@Column(name = "nom")
	private String nom;
	@Column(name = "nom")
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "numero", column = @Column(name = "restaurant_numero_rue", length = 50)),
			@AttributeOverride(name = "rue", column = @Column(name = "restaurant_rue")),
			@AttributeOverride(name = "codePostal", column = @Column(name = "restaurant_cp", length = 50)),
			@AttributeOverride(name = "ville", column = @Column(name = "restaurant_ville")),
			@AttributeOverride(name = "complementAdresse", column = @Column(name = "restaurant_complementAdresse"))})
	        
	private Adresse adresse;
	@Column(name = "description_restau")
	private String description;
	@Column(name = "horaire_ouverture")
	private String horaireOuverture;
	@Column(name = "urlImage")
	private String urlImage;
	@Column(name = "menu")
	@OneToMany(mappedBy = "restaurant")
	private Set<ItemMenu> menu;
	@Column(name = "aEmporter")
	private boolean aEmporter;
	@Column(name = "peutResrver")
	private boolean peutReserver;
	@Column(name = "commentaires")
	@OneToMany(mappedBy = "restaurant")
	private Set<Commentaire> commentaires;
	@Column(name = "categories")
	@Enumerated(EnumType.STRING)
	private Categorie categories;
	@OneToMany(mappedBy = "restaurant")
	private Set<ItemMenu> itemMenus;
	@ManyToOne
	@JoinColumn(name = "restaurateur_restaurant_id", foreignKey = @ForeignKey(name="restaurateur_restaurant_id_fk"))
	private Restaurateur restaurateur;
	
	
	
	
	public Restaurant() {
		super();
	}
	
	
	public Restaurant(String nom) {
		super();
		this.nom = nom;
	}
	
	
	public Restaurant(String nom, Adresse adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
	}


	public Restaurant(Long id, String nom, Adresse adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
	}
	


	public Restaurant(Long id, String nom, Adresse adresse, String description, String horaireOuverture,
			String urlImage, Set<ItemMenu> menu, boolean aEmporter, boolean peutReserver, Categorie categories,
			Set<ItemMenu> itemMenus, Restaurateur restaurateur) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.description = description;
		this.horaireOuverture = horaireOuverture;
		this.urlImage = urlImage;
		this.menu = menu;
		this.aEmporter = aEmporter;
		this.peutReserver = peutReserver;
		this.categories = categories;
		this.itemMenus = itemMenus;
		this.restaurateur = restaurateur;
	}





	public Restaurant(Long id, String nom, Adresse adresse, String description,
			String horaireOuverture, String urlImage, boolean aEmporter, boolean peutReserver,
			Set<Commentaire> commentaires, Categorie categories) {
		super();
		this.id = id;
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



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
		this.adresse = adresse;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
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
	public Categorie getCategories() {
		return categories;
	}
	public void setCategories(Categorie categories) {
		this.categories = categories;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return id == other.id;
	}
	
	
	
	
	
	
	
	
	

}
