package ajc.formation.soprasteria.projetFinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.projetFinal.entities.Categorie;
import ajc.formation.soprasteria.projetFinal.entities.Restaurant;
import ajc.formation.soprasteria.projetFinal.entities.Restaurateur;
import ajc.formation.soprasteria.projetFinal.exception.RestaurantException;
import ajc.formation.soprasteria.projetFinal.repositories.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepo;
	
	public void createOrUpdate(Restaurant restaurant) {
		
		restaurantRepo.save(restaurant);
	}
	
	public Restaurant getById(Long id) {
		if(id==null) {
			throw new RestaurantException("id obligatoire");
		}
		return restaurantRepo.findById(id).orElseThrow(() -> {
			throw new RestaurantException("id inconnu");
		});
	}
	
	public void deleteByKey(Long id) {
		Restaurant restaurant=getById(id);
		restaurantRepo.delete(restaurant);
	}
	
    public void delete(Restaurant restaurant) {
    	deleteByKey(restaurant.getId());
	}
    
    public List<Restaurant> getAll(){
    	return restaurantRepo.findAll();
    }
    
    public List<Restaurant> findByRestaurateur(Restaurateur restaurateur) {
    	return restaurantRepo.findByRestaurateur(restaurateur);
    }
    
    public List<Restaurant> findByVille(String ville) {
    	return restaurantRepo.findByVille(ville);
    }
    
    public List<Restaurant> findByCategorie(Categorie categorie) {
    	return restaurantRepo.findByCategories(categorie);
    }
    
    public List<Restaurant> findByCategorieAndVille(Categorie categorie, String ville) {
    	return restaurantRepo.findByCategoriesAndVille(categorie, ville);
    }
    
    public Optional<Restaurant> findByIdAvecMenu(Long id){
    	Restaurant restaurant = getById(id);
    	return restaurantRepo.findByIdAvecMenu(restaurant.getId());
    }
    
    public Optional<Restaurant> findByIdAvecCommentaires(Long id){
    	Restaurant restaurant = getById(id);
    	return restaurantRepo.findByIdAvecCommentaire(restaurant.getId());
    }

}
