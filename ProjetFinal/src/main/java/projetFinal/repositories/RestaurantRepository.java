package projetFinal.repositories;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetFinal.entities.Categorie;
import projetFinal.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
	
	@Query("from Restaurant r left join fetch r.adresse a where a.ville like :ville")
	List<Restaurant> findByVille(@Param("ville") String ville);
	
	List<Restaurant> findByCategories(Categorie categories);

	@Query("from Restaurant r left join fetch r.adresse a where a.ville like :ville and r.categories like :categories")
	List<Restaurant> findByCategoriesAndVille(@Param("categories") Categorie categories, @Param("ville") String ville);
	
	@Query("select r from Restaurant r left join fetch r.menu where r.id=:id")
	Optional<Restaurant> findByIdAvecMenu(@Param("id") Long id);

}
