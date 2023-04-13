package ajc.formation.soprasteria.projetFinal.entities.views;

public class JsonViews {
	
	public class Compte extends Simple {

	}
	
	public class CompteWithUtilisateur extends Compte {

	}

	public static class Simple {

	}
	
	public static class Client extends Simple {

	}
	
	public static class ClientWithReservation extends Client {

	}
	
	public static class ClientWithCommentaire extends Client {

	}
	
	public static class Restaurateur extends Simple {

	}
	
	public static class RestaurateurWithRestaurant extends Restaurateur {

	}
	
	
	public static class SurPlace extends Simple {

	}
	
	public static class SurPlaceWithItemsMenu extends SurPlace {

	}
	
	public static class CommandeADomicile extends Simple {

	}
	
	public static class ADomicileWithItemsMenu extends CommandeADomicile {

	}
	
	public static class Restaurant extends Simple {

	}
	
	public static class RestaurantWithCommentaire extends Restaurant {

	}
	
	public static class RestaurantWithItemsMenu extends Restaurant {

	}
	
	public static class RestaurantWithRestaurateur extends Restaurant {

	}
	
	public static class Reservation extends Simple {

	}
	
	public static class Commentaire extends Simple {

	}	
	public static class CommentaireWithRestaurant extends Commentaire {
		
	}
	public static class CommentaireWithClient extends Commentaire {
		
	}
	
	public static class ItemMenu extends Simple {

	}
	
	public static class ItemMenuWithRestaurant extends ItemMenu {

	}
	
	public static class ItemMenuWithSurPlaces extends ItemMenu {

	}
	
	public static class ItemMenuWithCommandesADomicile extends ItemMenu {

	}
	
	public static class Utilisateur extends Simple {

	}
	
	public static class UtilisateurWithCompte extends Utilisateur {

	}

}
