package com.mesEncheresV2.filRouge.repositories;

import java.io.File;
import java.io.InputStream;
import java.util.Optional;

import com.mesEncheresV2.filRouge.metier.Photo;
import com.mesEncheresV2.filRouge.metier.Product;


public interface PhotoRepositoryCustom {
	
	// Dans notre projet, seuls les fiches produit ont une image.On n'a pris le parti de ne pas rattacher les images aux différents types de users
	
	// voici ce qui concerne le produit
	
	public Product setProduct( int photosId, int productsId );
	

	Optional<File> getPhotoFile( int id );
	Optional<File> getPhotoThumbFile(int id);

	// ... ce qui a attrait aux Photos
	
	boolean savePhotoFile1(Photo photos, File file);
	boolean savePhotoFile(int id, File f);
	boolean savePhotoFile(int id, InputStream s);
	boolean removePhotoFile(int id);
	boolean removePhotoThumbFile(int id);




	boolean savePhotoFile(Photo photo, File file);
	
	
}

