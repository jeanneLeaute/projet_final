package projetFinal;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

//import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import projetFinal.config.JpaConfig;
import projetFinal.entities.Adresse;
import projetFinal.entities.Categorie;
import projetFinal.entities.Restaurant;
import projetFinal.services.RestaurantService;

@SpringJUnitConfig(JpaConfig.class)
@Transactional
@Rollback
class RestaurantTest {
	
	@Autowired
	private RestaurantService restauSer;
    
	//@Disabled
	@Test
	@Commit
	void RestaurantTests() {
		Restaurant restaurant = new Restaurant("RestoTest");
		restaurant.setCategories(Categorie.Br);
		Adresse adresse = new Adresse("11","rue Maurice","92500","Rueil-Malmaison");
		restaurant.setAdresse(adresse);
		restauSer.createOrUpdate(restaurant);
		restauSer.getById(1L);
		restauSer.findByVille("Rueil-Malmaison");
		restauSer.findByCategorieAndVille(Categorie.Br,"Rueil-Malmaison");
		restauSer.deleteByKey(1L);
	}

}
