package projetFinal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFinal.entities.ItemMenu;
import projetFinal.repositories.ItemMenuRepository;

@Service
public class ItemMenuService {
	
	@Autowired
	private ItemMenuRepository itemMenuRep;
	
	public void createOrUpdate(ItemMenu itemMenu) {
		itemMenuRep.save(itemMenu);
	}

}
