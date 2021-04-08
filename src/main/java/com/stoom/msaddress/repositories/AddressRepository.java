package com.stoom.msaddress.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stoom.msaddress.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
