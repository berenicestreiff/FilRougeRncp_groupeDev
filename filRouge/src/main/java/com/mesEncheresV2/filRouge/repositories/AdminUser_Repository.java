package com.mesEncheresV2.filRouge.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.mesEncheresV2.filRouge.metier.Admin_User;


public interface AdminUser_Repository extends CrudRepository<Admin_User, Integer> {

	AdminUser_Repository findAll(Pageable pageRequest);







}
