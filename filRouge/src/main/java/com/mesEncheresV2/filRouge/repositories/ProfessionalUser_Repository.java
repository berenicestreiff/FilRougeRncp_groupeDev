package com.mesEncheresV2.filRouge.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.mesEncheresV2.filRouge.metier.Professionnal_User;

public interface ProfessionalUser_Repository extends CrudRepository<Professionnal_User, Integer> {

	ProfessionalUser_Repository findAll(Pageable pageRequest);


}
