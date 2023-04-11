package projetFinalRest.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import projetFinal.entities.ItemMenu;
import projetFinal.entities.views.JsonViews;
import projetFinal.services.ItemMenuService;

@RestController
@RequestMapping("/api/itemMenu")
public class ItemMenuRestController {
	
	private ItemMenuService itemMenuSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.ItemMenu.class)
	public List<ItemMenu> getAll() {
		return itemMenuSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.ItemMenu.class)
	public ItemMenu getById (@PathVariable Long id) {
		ItemMenu itemMenu = null;
		itemMenu = itemMenuSrv.getById(id);
		return itemMenu;
	}
	
	@GetMapping("/{id}/SurPlaces")
	@JsonView(JsonViews.ItemMenuWithSurPlaces.class)
	public ItemMenu getByIdWithSurPlaces (@PathVariable Long id) {
		ItemMenu itemMenu = null;
		itemMenu = itemMenuSrv.getByIdWithSurPlaces(id);
		return itemMenu;
	}
	
	@GetMapping("/{id}/CommandesADomicile")
	@JsonView(JsonViews.ItemMenuWithCommandesADomicile.class)
	public ItemMenu getByIdWithCommandesADomicile (@PathVariable Long id) {
		ItemMenu itemMenu = null;
		itemMenu = itemMenuSrv.getByIdWithCommandeADomicile(id);
		return itemMenu;
	}
	
	@PostMapping("")
	@JsonView(JsonViews.ItemMenu.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public ItemMenu create(@Valid @RequestBody ItemMenu itemMenu, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		itemMenuSrv.createOrUpdate(itemMenu);
		return itemMenu;
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.ItemMenu.class)
	public ItemMenu update(@RequestBody ItemMenu itemMenu, @PathVariable Long id) {
		ItemMenu itemMenuEnBase = itemMenuSrv.getById(id);
		if (itemMenu.getUrlImage() != null) {
			itemMenuEnBase.setUrlImage(itemMenu.getUrlImage());
		}
		if (itemMenu.getNom() != null) {
			itemMenuEnBase.setNom(itemMenu.getNom());
		}
		if (itemMenu.getDescription() != null) {
			itemMenuEnBase.setDescription(itemMenu.getDescription());
		}
		if (itemMenu.getCategoriePlat() != null) {
			itemMenuEnBase.setCategoriePlat(itemMenu.getCategoriePlat());
		}
		itemMenuSrv.createOrUpdate(itemMenuEnBase);
		return itemMenuEnBase;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		itemMenuSrv.deleteByKey(id);
	}

}
