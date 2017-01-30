package com.mesEncheresV2.filRouge.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.mesEncheresV2.filRouge.metier.Product;

public interface Product_Repository extends CrudRepository<Product, Integer>{

	ProfessionalUser_Repository findAll(Pageable pageRequest);

}
