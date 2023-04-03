package projetFinal.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	@Column(name = "number")
	private String numero;
	@Column(name = "street")
	private String rue;
	@Column(name = "postcode")
	private String codePostal;
	@Column(name = "city")
	private String ville;
	@Column(name = "complement")
	private String complementAdresse;

	public Adresse() {

	}
	
	

	public Adresse(String numero, String rue, String codePostal, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}



	public Adresse(String numero, String rue, String codePostal, String ville, String complementAdresse) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.complementAdresse = complementAdresse;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codePostal, complementAdresse, numero, rue, ville);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adresse other = (Adresse) obj;
		return Objects.equals(codePostal, other.codePostal)
				&& Objects.equals(complementAdresse, other.complementAdresse) && Objects.equals(numero, other.numero)
				&& Objects.equals(rue, other.rue) && Objects.equals(ville, other.ville);
	}

	public String getComplementAdresse() {
		return complementAdresse;
	}

	public void setComplementAdresse(String complementAdresse) {
		this.complementAdresse = complementAdresse;
	}

}
