package com.stoom.msaddress.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.stoom.msaddress.entities.Address;
import com.stoom.msaddress.services.AddressService;
import com.stoom.msaddress.services.exception.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/address")
public class AddressResource {

	@Autowired
	private AddressService service;

	@GetMapping
	public ResponseEntity<List<Address>> findAll() throws ObjectNotFoundException {
		List<Address> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Address> find(@PathVariable Long id) throws ObjectNotFoundException {
		Address retorno = service.find(id);
		return ResponseEntity.ok().body(retorno);
	}

	@PostMapping(produces="application/json", consumes="application/json")
	public ResponseEntity<Void> insert(@RequestBody Address request) throws ObjectNotFoundException {
		Address obj = new Address();
		obj = service.insert(request);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Address> delete(@PathVariable Long id) throws ObjectNotFoundException {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Address obj, @PathVariable Long id) throws ObjectNotFoundException {

		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/page")
	public ResponseEntity<Page<Address>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "streetName") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) throws ObjectNotFoundException {
		Page<Address> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
	

}
