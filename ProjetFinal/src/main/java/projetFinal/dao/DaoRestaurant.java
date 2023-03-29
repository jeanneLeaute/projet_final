package projetFinal.dao;

import java.util.List;

import projetFinal.entities.Categorie;
import projetFinal.entities.Restaurant;

public interface DaoRestaurant extends DaoGenerique<Restaurant, String>{
	
	public List<Restaurant> findByVille(String ville);
	public List<Restaurant> findByCategorie(Categorie categorie);
	public List<Restaurant> findByCategorieVille(Categorie categorie, String ville);

}
