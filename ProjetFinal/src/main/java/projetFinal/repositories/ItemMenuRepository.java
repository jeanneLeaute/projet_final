package projetFinal.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetFinal.entities.ItemMenu;

public interface ItemMenuRepository extends JpaRepository<ItemMenu, Long>{

	@Query("select i from ItemMenu i left join fetch i.surPlaces s where i.id=:id")
	Optional<ItemMenu> findByIdFetchSurPlace(@Param("id") Long id);
	
	@Query("select i from ItemMenu i left join fetch i.commandesAdomicile c where i.id=:id")
	Optional<ItemMenu> findByIdFetchCommandesADomicile(@Param("id") Long id);

}
