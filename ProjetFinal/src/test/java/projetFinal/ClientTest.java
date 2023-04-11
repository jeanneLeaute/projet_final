package projetFinal;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import projetFinal.config.JpaConfig;
import projetFinal.entities.Client;
import projetFinal.exceptions.ClientException;
import projetFinal.services.ClientService;

@SpringJUnitConfig(JpaConfig.class)
@Transactional
@Rollback
class ClientTest {
	
	@Autowired
	ClientService clientService;

	@Disabled
	@Test
	@Commit
	@BeforeAll
	void initClient() {
		clientService.createOrUpdate(new Client("Paillat", "Léo", "léoclientemail", "léomotdepasse"));
		clientService.createOrUpdate(new Client("Bedy", "Mohameden", "mohamedenclientemail", "Mohamedenmotdepasse"));
		clientService.createOrUpdate(new Client("Kumeka", "Richard", "richardeclientmail", "richardmotdepasse"));
		clientService.createOrUpdate(new Client("Leaute", "Jeanne", "jeanneclientemail", "jeannemotdepasse"));
	}
	
	@Test
	void getAllTest() {
		assertNotNull(clientService.getAll());
	}
	
	@Test
	void getByEMailTest() {
		assertNotNull(clientService.getByEMail("léoclientemail"));
		assertNotNull(clientService.getByEMail("mohamedenclientemail"));
		assertNotNull(clientService.getByEMail("richardeclientmail"));
		assertNotNull(clientService.getByEMail("jeanneclientemail"));
	}
	
	@Test
	void getByEMailWithReservationTest() {
		assertNotNull(clientService.getByEMailWithReservation("léoclientemail").getReservations());
		assertNotNull(clientService.getByEMailWithReservation("mohamedenclientemail").getReservations());
		assertNotNull(clientService.getByEMailWithReservation("richardeclientmail").getReservations());
		assertNotNull(clientService.getByEMailWithReservation("jeanneclientemail").getReservations());
	}
	
	@Test
	void getByEMailWithCommentairesTest() {
		assertNotNull(clientService.getByEMailWithCommentaires("léoclientemail").getCommentaires());
		assertNotNull(clientService.getByEMailWithCommentaires("mohamedenclientemail").getCommentaires());
		assertNotNull(clientService.getByEMailWithCommentaires("richardeclientmail").getCommentaires());
		assertNotNull(clientService.getByEMailWithCommentaires("jeanneclientemail").getCommentaires());
	}
	
	@Test
	void getByEMailWithReservationsWithCommentairesTest() {
		assertNotNull(clientService.getByEMailWithReservationsWithCommentaires("léoclientemail").getReservations());
		assertNotNull(clientService.getByEMailWithReservationsWithCommentaires("mohamedenclientemail").getReservations());
		assertNotNull(clientService.getByEMailWithReservationsWithCommentaires("richardeclientmail").getReservations());
		assertNotNull(clientService.getByEMailWithReservationsWithCommentaires("jeanneclientemail").getReservations());
		
		assertNotNull(clientService.getByEMailWithReservationsWithCommentaires("léoclientemail").getCommentaires());
		assertNotNull(clientService.getByEMailWithReservationsWithCommentaires("mohamedenclientemail").getCommentaires());
		assertNotNull(clientService.getByEMailWithReservationsWithCommentaires("richardeclientmail").getCommentaires());
		assertNotNull(clientService.getByEMailWithReservationsWithCommentaires("jeanneclientemail").getCommentaires());
	}
	
	@Test
	void getByEMailExceptionEMailBlank() {
		assertThrows(ClientException.class, () -> clientService.getByEMail(""));
	}
	
	@Test
	void getByEMailExceptionEMailNull() {
		assertThrows(ClientException.class, () -> clientService.getByEMail(null));
	}
	
	@Test
	void createOrUpdateExceptionNull() {
		assertThrows(ClientException.class, () -> clientService.createOrUpdate(new Client(null, null, null, "léomotdepasse")));
	}
	
	@Test
	void createOrUpdateExceptionBlank() {
		assertThrows(ClientException.class, () -> clientService.createOrUpdate(new Client("", "", "", "léomotdepasse")));
	}
	
	@Test
	void createOrUpdateExceptionTropCourt() {
		assertThrows(ClientException.class, () -> clientService.createOrUpdate(new Client("Paillat", "Léo", "a", "a")));
	}

}
