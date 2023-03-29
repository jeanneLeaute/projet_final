package projetFinal.entities;

public enum CategoriePlat {
	Entree("entrée"), Plat("plat"), Dessert("dessert"), Boisson("boisson");
	
	private String texte ;
	
	

	private CategoriePlat(String texte) {
		this.texte = texte;
	}



	public String getTexte() {
		return texte;
	}


}
