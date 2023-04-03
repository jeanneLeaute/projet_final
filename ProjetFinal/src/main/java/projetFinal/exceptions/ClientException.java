package projetFinal.exceptions;

public class ClientException extends RuntimeException{
	
public ClientException() {
		
	}
	
public ClientException(String texte) {
		super(texte);
	}

}
