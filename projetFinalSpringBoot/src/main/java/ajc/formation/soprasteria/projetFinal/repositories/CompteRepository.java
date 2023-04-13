package ajc.formation.soprasteria.projetFinal.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.formation.soprasteria.projetFinal.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {
	
	Optional<Compte> findByLogin(String login);

}
