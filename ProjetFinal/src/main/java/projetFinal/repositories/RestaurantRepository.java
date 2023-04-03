package projetFinal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFinal.entities.Categorie;
import projetFinal.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
	
	List<Restaurant> findByVille(String ville);
	
	List<Restaurant> findByCategorie(Categorie categorie);
	
	List<Restaurant> findByCategorieAndVille(Categorie categorie, String ville);

}
