package com.stoom.msaddress.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.stoom.msaddress.entities.Address;
import com.stoom.msaddress.repositories.AddressRepository;
import com.stoom.msaddress.services.exception.ObjectNotFoundException;


@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;
	
	public Address find(Long id) throws ObjectNotFoundException {
		Optional<Address> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}

	public List<Address> findAll() throws ObjectNotFoundException {
		List<Address> obj = repository.findAll();
		return obj;
	}

	public Address insert(Address obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Address update(Address obj) throws ObjectNotFoundException {
		Address newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	public void delete(Long id) throws ObjectNotFoundException {
		find(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Impossível excluir este endereço!");
		}

	}
	
	private void updateData(Address newObj, Address obj) {

		newObj.setStreetName(obj.getStreetName());
	}
	
	public Page<Address> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);

	}
	
}
