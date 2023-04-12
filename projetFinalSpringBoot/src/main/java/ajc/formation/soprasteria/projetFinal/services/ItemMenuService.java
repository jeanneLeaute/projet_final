package ajc.formation.soprasteria.projetFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.projetFinal.entities.ItemMenu;
import ajc.formation.soprasteria.projetFinal.exception.ItemMenuException;
import ajc.formation.soprasteria.projetFinal.repositories.ItemMenuRepository;

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
	
	public ItemMenu getByIdWithSurPlaces(Long id) {
		if(id==null) {
			throw new ItemMenuException("id obligatoire");
		}
		return itemMenuRepo.findByIdFetchSurPlace(id).orElseThrow(() -> {
			throw new ItemMenuException("id inconnu");
		});
	}
	
	public ItemMenu getByIdWithCommandeADomicile(Long id) {
		if(id==null) {
			throw new ItemMenuException("id obligatoire");
		}
		return itemMenuRepo.findByIdFetchCommandesADomicile(id).orElseThrow(() -> {
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
