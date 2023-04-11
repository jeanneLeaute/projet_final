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
import projetFinal.entities.Restaurateur;
import projetFinal.exceptions.ClientException;
import projetFinal.exceptions.RestaurateurException;
import projetFinal.services.RestaurateurService;

@SpringJUnitConfig(JpaConfig.class)
@Transactional
@Rollback
class RestaurateurTest {
	
	@Autowired
	RestaurateurService restaurateurService;

	@Disabled
	@Test
	@Commit
	@BeforeAll
	void initRestaurateur() {
		restaurateurService.createOrUpdate(new Restaurateur("Paillat", "Léo", "léorestaurateuremail", "léomotdepasse"));
		restaurateurService.createOrUpdate(new Restaurateur("Bedy", "Mohameden", "mohamedenrestaurateuremail", "Mohamedenmotdepasse"));
		restaurateurService.createOrUpdate(new Restaurateur("Kumeka", "Richard", "richarderestaurateurmail", "richardmotdepasse"));
		restaurateurService.createOrUpdate(new Restaurateur("Leaute", "Jeanne", "jeannerestaurateuremail", "jeannemotdepasse"));
	}
	
	@Test
	void getAllTest() {
		assertNotNull(restaurateurService.getAll());
	}
	
	@Test
	void getByEMailTest() {
		assertNotNull(restaurateurService.getByEMail("léorestaurateuremail"));
		assertNotNull(restaurateurService.getByEMail("mohamedenrestaurateuremail"));
		assertNotNull(restaurateurService.getByEMail("richarderestaurateurmail"));
		assertNotNull(restaurateurService.getByEMail("jeannerestaurateuremail"));
	}
	
	@Test
	void getByEMailWithRestaurantsTest() {
		assertNotNull(restaurateurService.getByEMailWithRestaurants("léorestaurateuremail").getRestaurants());
		assertNotNull(restaurateurService.getByEMailWithRestaurants("mohamedenrestaurateuremail").getRestaurants());
		assertNotNull(restaurateurService.getByEMailWithRestaurants("richarderestaurateurmail").getRestaurants());
		assertNotNull(restaurateurService.getByEMailWithRestaurants("jeannerestaurateuremail").getRestaurants());
	}
	
	@Test
	void getByEMailExceptionEMailBlank() {
		assertThrows(RestaurateurException.class, () -> restaurateurService.getByEMail(""));
	}
	
	@Test
	void getByEMailExceptionEMailNull() {
		assertThrows(RestaurateurException.class, () -> restaurateurService.getByEMail(null));
	}
	
	@Test
	void createOrUpdateExceptionNull() {
		assertThrows(RestaurateurException.class, () -> restaurateurService.createOrUpdate(new Restaurateur(null, null, null, "léomotdepasse")));
	}
	
	@Test
	void createOrUpdateExceptionBlank() {
		assertThrows(RestaurateurException.class, () -> restaurateurService.createOrUpdate(new Restaurateur("", "", "", "léomotdepasse")));
	}
	
	@Test
	void createOrUpdateExceptionTropCourt() {
		assertThrows(RestaurateurException.class, () -> restaurateurService.createOrUpdate(new Restaurateur("Paillat", "Léo", "a", "a")));
	}

}
