package com.mesEncheresV2.filRouge.repositories;

import java.io.File;
import java.util.Optional;

import com.mesEncheresV2.filRouge.metier.Basic_User;
import com.mesEncheresV2.filRouge.metier.Photo;
import com.mesEncheresV2.filRouge.metier.Product;

public interface PhotoRepositoryCustom {

	Optional<File> getImageFile( int id );
	
	public Basic_User setEncherisseurs( int photoId, int encherisseursId );
	public Product setProduct( int photoId, int productId );
	boolean saveImageFile1(Photo photo, File file);
	boolean saveImageFile1(int id, File file);

	boolean saveImageFile(int id, File file);

	boolean saveImageFile(Photo photo, File file);
	
}

