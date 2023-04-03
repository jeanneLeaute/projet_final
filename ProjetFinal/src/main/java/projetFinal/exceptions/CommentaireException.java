package projetFinal.exceptions;

public class CommentaireException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CommentaireException () {
		
	}
	
	public CommentaireException(String message) {
		super(message);
	}

}
