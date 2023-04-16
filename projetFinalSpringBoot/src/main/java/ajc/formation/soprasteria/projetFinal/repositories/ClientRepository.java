package ajc.formation.soprasteria.projetFinal.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ajc.formation.soprasteria.projetFinal.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

	@Query("select c from Client c left join fetch c.reservations where c.id=:id")
	Optional<Client> findByIdFetchReservations(@Param("id") Long id);
	
	@Query("select c from Client c left join fetch c.commentaires where id=:id")
	Optional<Client> findByIdFetchCommentaires(@Param("id") Long id);
	
	@Query("select c from Client c left join fetch c.reservations left join fetch c.commentaires where id=:id")
	Optional<Client> findByIdFetchReservationsFetchCommentaires(@Param("id") Long id);
	
	Optional<Client> findByLogin(String login);

}
