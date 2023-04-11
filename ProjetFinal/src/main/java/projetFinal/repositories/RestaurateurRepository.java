package projetFinal.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetFinal.entities.Restaurant;
import projetFinal.entities.Restaurateur;

public interface RestaurateurRepository extends JpaRepository<Restaurateur, String> {

	@Query("select r from Restaurateur r left join fetch r.restaurants where r.eMail=:eMail")
	Optional<Restaurateur> findByEMailFetchRestaurants(@Param("eMail")String eMail);

//	@Query("select r from Restaurateur r left join r.restaurants where r.restaurants contains :restaurant")
//	Optional<Restaurateur> findByRestaurant(@Param("restaurant")Restaurant restaurant);
	
	

}
