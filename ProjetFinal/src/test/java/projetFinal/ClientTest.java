package projetFinal;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

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

//	@Disabled
	@Test
	@Commit
	void initClient() {
		clientService.createOrUpdate(new Client("Paillat", "Léo", "léoemail", "léomotdepasse"));
		clientService.createOrUpdate(new Client("Bedy", "Mohameden", "mohamedenemail", "Mohamedenmotdepasse"));
		clientService.createOrUpdate(new Client("Kumeka", "Richard", "richardemail", "richardmotdepasse"));
		clientService.createOrUpdate(new Client("Leaute", "Jeanne", "jeanneemail", "jeannemotdepasse"));
	}
	
	@Test
	void getAllTest() {
		assertNotNull(clientService.getAll());
	}
	
	@Test
	void getByEMailTest() {
		assertNotNull(clientService.getByEMail("léoemail"));
		assertNotNull(clientService.getByEMail("mohamedenemail"));
		assertNotNull(clientService.getByEMail("richardemail"));
		assertNotNull(clientService.getByEMail("jeanneemail"));
	}
	
	@Test
	void getByEMailWithReservationTest() {
		assertNotNull(clientService.getByEMail("léoemail").getReservations());
		assertNotNull(clientService.getByEMail("mohamedenemail").getReservations());
		assertNotNull(clientService.getByEMail("richardemail").getReservations());
		assertNotNull(clientService.getByEMail("jeanneemail").getReservations());
	}
	
	@Test
	void getByEMailWithCommentairesTest() {
		assertNotNull(clientService.getByEMail("léoemail").getCommentaires());
		assertNotNull(clientService.getByEMail("mohamedenemail").getCommentaires());
		assertNotNull(clientService.getByEMail("richardemail").getCommentaires());
		assertNotNull(clientService.getByEMail("jeanneemail").getCommentaires());
	}
	
	@Test
	void getByEMailWithReservationsWithCommentairesTest() {
		assertNotNull(clientService.getByEMail("léoemail").getReservations());
		assertNotNull(clientService.getByEMail("mohamedenemail").getReservations());
		assertNotNull(clientService.getByEMail("richardemail").getReservations());
		assertNotNull(clientService.getByEMail("jeanneemail").getReservations());
		
		assertNotNull(clientService.getByEMail("léoemail").getCommentaires());
		assertNotNull(clientService.getByEMail("mohamedenemail").getCommentaires());
		assertNotNull(clientService.getByEMail("richardemail").getCommentaires());
		assertNotNull(clientService.getByEMail("jeanneemail").getCommentaires());
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
