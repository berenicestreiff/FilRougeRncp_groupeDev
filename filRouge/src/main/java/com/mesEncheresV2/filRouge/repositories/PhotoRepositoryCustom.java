package com.mesEncheresV2.filRouge.repositories;

import java.io.File;
import java.util.Optional;

import com.mesEncheresV2.filRouge.metier.Photo;
import com.mesEncheresV2.filRouge.metier.Product;

public interface PhotoRepositoryCustom {

	Optional<File> getImageFile( int id );
	

	public Product setProduct( int photosId, int productsId );
	boolean saveImageFile1(Photo photos, File file);
	

}

