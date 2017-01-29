package com.mesEncheresV2.filRouge.utils;

import java.util.Iterator;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.fasterxml.jackson.annotation.JsonView;
import com.mesEncheresV2.filRouge.metier.Admin_User;
import com.mesEncheresV2.filRouge.metier.Basic_User;
import com.mesEncheresV2.filRouge.metier.Professionnal_User;
import com.mesEncheresV2.filRouge.repositories.AdminUser_Repository;
import com.mesEncheresV2.filRouge.repositories.BasicUser_Repository;
import com.mesEncheresV2.filRouge.repositories.ProfessionalUser_Repository;

public class JsonPageable <T> implements Page<T> {

	public static class PaginatedResult {}



	private Page<T> originalPage;

	@JsonView(PaginatedResult.class)
	@Override
	public List<T> getContent() {return originalPage.getContent();}

	@JsonView(PaginatedResult.class)
	@Override
	public int getNumber() {return originalPage.getNumber();}

	@JsonView(PaginatedResult.class)
	@Override
	public int getNumberOfElements() {return originalPage.getNumberOfElements();}

	@JsonView(PaginatedResult.class)
	@Override
	public int getSize() {return originalPage.getSize();}

	@Override
	public Sort getSort() {return originalPage.getSort();}

	@Override
	public boolean hasContent() {return originalPage.hasContent();}

	@Override
	public boolean hasNext() {return originalPage.hasNext();}

	@Override
	public boolean hasPrevious() {return originalPage.hasPrevious();}

	@JsonView(PaginatedResult.class)
	@Override
	public boolean isFirst() {return originalPage.isFirst();}

	@JsonView(PaginatedResult.class)
	@Override
	public boolean isLast() { return originalPage.isLast();}

	@Override
	public Pageable nextPageable() {return originalPage.nextPageable();}

	@Override
	public Pageable previousPageable() {return originalPage.previousPageable();}

	@Override
	public Iterator<T> iterator() {return originalPage.iterator();}

	@JsonView(PaginatedResult.class)
	@Override
	public long getTotalElements() {return originalPage.getTotalElements();}

	@JsonView(PaginatedResult.class)
	@Override
	public int getTotalPages() { return originalPage.getTotalPages();}

	@Override
	public <S> Page<S> map(Converter<? super T, ? extends S> arg0) {return originalPage.map(arg0);}

	public static Page<Professionnal_User> fromPage(ProfessionalUser_Repository professionaluserrepository) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Page<Basic_User> fromPage(BasicUser_Repository findAll) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Page<Admin_User> fromPage(AdminUser_Repository findAll) {
		// TODO Auto-generated method stub
		return null;
	}


	}





