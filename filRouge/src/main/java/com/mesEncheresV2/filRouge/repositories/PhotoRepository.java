package com.mesEncheresV2.filRouge.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mesEncheresV2.filRouge.metier.Photo;

public interface PhotoRepository  extends PagingAndSortingRepository<Photo, Integer>, PhotoRepositoryCustom
{

}