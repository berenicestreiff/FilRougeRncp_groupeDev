package com.mesEncheresV2.filRouge.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.mesEncheresV2.filRouge.metier.Basic_User;


public interface BasicUser_Repository extends CrudRepository<Basic_User, Integer> {

	BasicUser_Repository findAll(Pageable pageRequest);



}
