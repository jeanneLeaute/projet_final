package projetFinal.entities;

public class Commentaire {

	private String texte;

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
}
