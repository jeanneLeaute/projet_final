package projetFinal.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetFinal.entities.Client;

public interface ClientRepository extends JpaRepository<Client, String>{

	@Query("select c from Client c left join fetch c.reservations where c.eMail=:eMail")
	Optional<Client> findByEMailFetchReservations(@Param("eMail") String eMail);
	
	@Query("select c from Client c left join fetch c.commentaires where c.eMail=:eMail")
	Optional<Client> findByEMailFetchCommentaires(@Param("eMail") String eMail);
	
	@Query("select c from Client c left join fetch c.reservations left join fetch c.commentaires where c.eMail=:eMail")
	Optional<Client> findByEMailFetchReservationsFetchCommentaires(@Param("eMail") String eMail);

}
