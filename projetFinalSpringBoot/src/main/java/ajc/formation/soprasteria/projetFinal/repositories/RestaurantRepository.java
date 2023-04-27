package ajc.formation.soprasteria.projetFinal.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ajc.formation.soprasteria.projetFinal.entities.Categorie;
import ajc.formation.soprasteria.projetFinal.entities.Restaurant;
import ajc.formation.soprasteria.projetFinal.entities.Restaurateur;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
	
	@Query("select distinct r from Restaurant r left join fetch r.adresse a where a.ville like :ville")
	List<Restaurant> findByVille(@Param("ville") String ville);
	
	List<Restaurant> findByCategories(Categorie categories);
	List<Restaurant> findByRestaurateur(Restaurateur restaurateur);
	

	@Query("select distinct r from Restaurant r left join fetch r.adresse a where a.ville like :ville and r.categories like :categories")
	List<Restaurant> findByCategoriesAndVille(@Param("categories") Categorie categories, @Param("ville") String ville);
	
	@Query("select distinct r from Restaurant r left join fetch r.itemMenus where r.id=:id")
	Optional<Restaurant> findByIdAvecMenu(@Param("id") Long id);
	
	@Query("select distinct r from Restaurant r left join fetch r.commentaires where r.id=:id")
	Optional<Restaurant> findByIdAvecCommentaire(@Param("id") Long id);

}
