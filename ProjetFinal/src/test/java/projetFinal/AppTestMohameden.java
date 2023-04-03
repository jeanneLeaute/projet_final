package projetFinal;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import projetFinal.dao.Contexte;
import projetFinal.dao.DaoItemMenu;
import projetFinal.dao.DaoRestaurant;
import projetFinal.entities.Adresse;
import projetFinal.entities.Categorie;
import projetFinal.entities.Restaurant;
import projetFinal.repositories.RestaurantRepository;
import projetFinal.services.RestaurantService;

public class AppTestMohameden {
	public static void main(String[] args) {
		
//		DaoItemMenu daoItemMenu = Contexte.getDaoItemMenu();
//		DaoRestaurant daoRestaurant = Contexte.getDaoRestaurant();
		Adresse adresse = new Adresse("11", "rue Maurice", "92500", "Rueil-Malmaison", null);
//		Categorie categorie = Categorie.Br;
		Restaurant restaurant = new Restaurant("restau", adresse);
	    restaurant.setCategories(Categorie.Br);
//		restaurant=daoRestaurant.save(restaurant);
//		System.out.println(daoRestaurant.findByVille("Rueil-Malmaison"));
//		System.out.println(daoRestaurant.findByCategorie(categorie));
//		System.out.println(daoRestaurant.findByCategorieVille(Categorie.Br, "Rueil-Malmaison"));
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(projetFinal.config.JpaConfig.class);
		RestaurantService restauSer = ctx.getBean(RestaurantService.class);
		
		restauSer.createOrUpdate(restaurant);
		
		
		
		
	}

}
