package ajc.formation.soprasteria.projetFinal.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ajc.formation.soprasteria.projetFinal.entities.ItemMenu;
import ajc.formation.soprasteria.projetFinal.entities.Reservation;
import ajc.formation.soprasteria.projetFinal.entities.Restaurant;

public interface ItemMenuRepository extends JpaRepository<ItemMenu, Long>{

	@Query("select i from ItemMenu i left join fetch i.surPlaces s where i.id=:id")
	Optional<ItemMenu> findByIdFetchSurPlace(@Param("id") Long id);
	
	@Query("select i from ItemMenu i left join fetch i.commandesAdomicile c where i.id=:id")
	Optional<ItemMenu> findByIdFetchCommandesADomicile(@Param("id") Long id);

	List<ItemMenu> findByRestaurant(Restaurant restaurant);

	List<ItemMenu> findItemMenusBySurPlaceId(Long surPlaceId);
}
