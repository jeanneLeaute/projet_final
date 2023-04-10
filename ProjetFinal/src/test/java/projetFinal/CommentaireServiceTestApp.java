package projetFinal;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import projetFinal.config.JpaConfig;
import projetFinal.entities.Client;
import projetFinal.entities.Restaurant;
import projetFinal.exceptions.ClientException;
import projetFinal.services.CommentaireService;

@SpringJUnitConfig(JpaConfig.class)
@Transactional
@Rollback
class CommentaireServiceTestApp {
	@Autowired
	CommentaireService commentaireService;
	@Autowired
	Client client;
	@Autowired
	Restaurant restaurant;

	void initCommentaire() {
		commentaireService.createOrUpdate(new Client("Paillat", "Léo", "léoemail", "léomotdepasse"));
		
	}
	
	@Test
	void getAllTest() {
		assertNotNull(commentaireService.getAll());
	}
	
	@Test
	void getByEMailTest() {
		assertNotNull(commentaireService.getByEMail("léoemail"));
		assertNotNull(commentaireService.getByEMail("mohamedenemail"));
		assertNotNull(commentaireService.getByEMail("richardemail"));
		assertNotNull(commentaireService.getByEMail("jeanneemail"));
	}
	
	@Test
	void getByEMailWithReservationTest() {
		assertNotNull(commentaireService.getByEMail("léoemail").getReservations());
		assertNotNull(commentaireService.getByEMail("mohamedenemail").getReservations());
		assertNotNull(commentaireService.getByEMail("richardemail").getReservations());
		assertNotNull(commentaireService.getByEMail("jeanneemail").getReservations());
	}
	
	@Test
	void getByEMailWithCommentairesTest() {
		assertNotNull(commentaireService.getByEMail("léoemail").getCommentaires());
		assertNotNull(commentaireService.getByEMail("mohamedenemail").getCommentaires());
		assertNotNull(commentaireService.getByEMail("richardemail").getCommentaires());
		assertNotNull(commentaireService.getByEMail("jeanneemail").getCommentaires());
	}
	
	@Test
	void getByEMailWithReservationsWithCommentairesTest() {
		assertNotNull(commentaireService.getByEMail("léoemail").getReservations());
		assertNotNull(commentaireService.getByEMail("mohamedenemail").getReservations());
		assertNotNull(commentaireService.getByEMail("richardemail").getReservations());
		assertNotNull(commentaireService.getByEMail("jeanneemail").getReservations());
		
		assertNotNull(commentaireService.getByEMail("léoemail").getCommentaires());
		assertNotNull(commentaireService.getByEMail("mohamedenemail").getCommentaires());
		assertNotNull(commentaireService.getByEMail("richardemail").getCommentaires());
		assertNotNull(commentaireService.getByEMail("jeanneemail").getCommentaires());
	}
	
	@Test
	void getByEMailExceptionEMailBlank() {
		assertThrows(ClientException.class, () -> commentaireService.getByEMail(""));
	}
	
	@Test
	void getByEMailExceptionEMailNull() {
		assertThrows(ClientException.class, () -> commentaireService.getByEMail(null));
	}
	
	@Test
	void createOrUpdateExceptionNull() {
		assertThrows(ClientException.class, () -> commentaireService.createOrUpdate(new Client(null, null, null, "léomotdepasse")));
	}
	
	@Test
	void createOrUpdateExceptionBlank() {
		assertThrows(ClientException.class, () -> commentaireService.createOrUpdate(new Client("", "", "", "léomotdepasse")));
	}
	
	@Test
	void createOrUpdateExceptionTropCourt() {
		assertThrows(ClientException.class, () -> commentaireService.createOrUpdate(new Client("Paillat", "Léo", "a", "a")));
	}

}
