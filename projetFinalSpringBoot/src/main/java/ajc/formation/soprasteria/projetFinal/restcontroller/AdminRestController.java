package ajc.formation.soprasteria.projetFinal.restcontroller;


import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.projetFinal.entities.Admin;
import ajc.formation.soprasteria.projetFinal.entities.views.JsonViews;
import ajc.formation.soprasteria.projetFinal.services.AdminService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminRestController {
	
	@Autowired
	private AdminService adminSrv;
	

	@GetMapping("/{id}")
	@JsonView(JsonViews.Admin.class)
	public Admin getById(@PathVariable Long id) {
		Admin admin = null;
		admin = adminSrv.getById(id);
		return admin;
	}
	
	@PostMapping({"", "/inscription"})
	@JsonView(JsonViews.Admin.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Admin create(@Valid @RequestBody Admin admin, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		adminSrv.create(admin);
		return admin;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		adminSrv.deleteById(id);
	}
	

}
