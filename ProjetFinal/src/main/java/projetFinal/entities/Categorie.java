package projetFinal.entities;

public enum Categorie { 
	Br("Burger"), Pz("Pizza");

	private String texte;

	private Categorie(String texte) {
		this.texte = texte;
	}

	public String getTexte() {
		return texte;
	}

}
