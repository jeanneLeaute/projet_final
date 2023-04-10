package projetFinal;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import projetFinal.config.JpaConfig;
import projetFinal.entities.Client;
import projetFinal.entities.Commentaire;
import projetFinal.entities.Restaurant;
import projetFinal.services.CommentaireService;

@SpringJUnitConfig(JpaConfig.class)
@Transactional
@Rollback
class CommentaireTest {

	@Autowired
	CommentaireService commentaireService;
	@Autowired
	Client client;
	@Autowired
	Restaurant restaurant;

	@Disabled
	@Test
	@Commit
	void CommentaireTests() {
		Restaurant restaurant = new Restaurant("RestoTest");
		Client client = new Client("Richard","kumeka","richard@hotmail.com","richardk");
		Commentaire commentaire = new Commentaire("c'était bon",client,restaurant);
		commentaireService.createOrUpdate(commentaire);
		commentaireService.getByClient(client);
		commentaireService.getById(null);
		commentaireService.deleteById(null);
		
		

	}
}