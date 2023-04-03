package projetFinal;

import static org.junit.jupiter.api.Assertions.*;


import javax.transaction.Transactional;

//import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import projetFinal.config.JpaConfig;
import projetFinal.entities.ItemMenu;
import projetFinal.services.ItemMenuService;

@SpringJUnitConfig(JpaConfig.class)
@Transactional
@Rollback
class ItemMenuTest {
	
	@Autowired
	private ItemMenuService itemMenuSer;
    
	//@Disabled
	@Test
	@Commit
	void RestaurantTests() {
		ItemMenu itemMenu = new ItemMenu("nomMenu");
		itemMenuSer.createOrUpdate(itemMenu);
		itemMenuSer.getById(1L);
		itemMenuSer.deleteByKey(1L);
	}

}
