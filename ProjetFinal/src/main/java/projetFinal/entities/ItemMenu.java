package projetFinal.entities;

public class ItemMenu {
	
	String urlImage;
	String nom;
	String description;
	CategoriePlat categoriePlat;
	
	public ItemMenu() {
		super();
	}

	public ItemMenu(String urlImage, String nom, String description, CategoriePlat categoriePlat) {
		super();
		this.urlImage = urlImage;
		this.nom = nom;
		this.description = description;
		this.categoriePlat = categoriePlat;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CategoriePlat getCategoriePlat() {
		return categoriePlat;
	}

	public void setCategoriePlat(CategoriePlat categoriePlat) {
		this.categoriePlat = categoriePlat;
	}
	
	
	
	

}
