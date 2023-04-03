package projetFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFinal.entities.ItemMenu;
import projetFinal.exceptions.ItemMenuException;
import projetFinal.repositories.ItemMenuRepository;

@Service
public class ItemMenuService {
	
	@Autowired
	private ItemMenuRepository itemMenuRepo;
	
	public void createOrUpdate(ItemMenu itemMenu) {
		itemMenuRepo.save(itemMenu);
	}
	
	public ItemMenu getById(Long id) {
		if(id==null) {
			throw new ItemMenuException("id obligatoire");
		}
		return itemMenuRepo.findById(id).orElseThrow(() -> {
			throw new ItemMenuException("id inconnu");
		});
	}
	
	public void deleteByKey(Long id) {
		ItemMenu itemMenu=getById(id);
		itemMenuRepo.delete(itemMenu);
	}
	
    public void delete(ItemMenu itemMenu) {
    	deleteByKey(itemMenu.getId_item());
	}
    
    public List<ItemMenu> getAll(){
    	return itemMenuRepo.findAll();
    }
	

}
