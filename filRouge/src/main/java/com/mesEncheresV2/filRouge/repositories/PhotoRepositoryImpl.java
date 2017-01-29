package com.mesEncheresV2.filRouge.repositories;



import java.io.File;
import java.io.InputStream;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.mesEncheresV2.filRouge.metier.Photo;
import com.mesEncheresV2.filRouge.metier.Product;
import com.mesEncheresV2.filRouge.utils.FileStorageManager;



// UTILIT2 ThumbFile?
public class PhotoRepositoryImpl  implements PhotoRepositoryCustom {

	private static Logger log = LogManager.getLogger( PhotoRepositoryImpl.class );

	@Autowired
	private FileStorageManager fileStorageManager;
	@PersistenceContext
	private EntityManager em;

// getters and setters

	public FileStorageManager getFileStorageManager() { return fileStorageManager; }
	public void setFileStorageManager(FileStorageManager fileStorageManager) { this.fileStorageManager = fileStorageManager; }

	//methde custom d'implementation
	
	@Override
	@Transactional
	public boolean savePhotoFile( Photo photo, File file ) {
		Photo existing = em.find( Photo.class, photo.getId() ); // find(Class<T> entityClass, Object primaryKey)
		if ( existing == null ) {
			this.em.persist( photo );

			log.info( "fileStorageManager = " +  fileStorageManager );
			log.info( "photo.getId() = " +  photo.getId() );
			log.info( "file = " +  file );

			// stockage effectif du fichier
			return this.fileStorageManager.saveFile( Photo.class.getName(), photo.getId(), file );
			//			return photo;
		} else {
			existing = this.em.merge( photo );

			log.info( "fileStorageManager = " +  fileStorageManager );
			log.info( "photo.getId() = " +  existing.getId() );
			log.info( "file = " +  file );

			return this.fileStorageManager.saveFile( Photo.class.getName(), existing.getId(), file );

	}
	}


	@Override
	public boolean savePhotoFile( int id, File file ) { 
		return getFileStorageManager().saveFile( Photo.class.getName(), id, file );
	}



	public PhotoRepositoryImpl() {
		super();}


	@Override
	public Optional<File> getPhotoFile( int id ) {
		return getFileStorageManager().getFile( Photo.class.getName(), id );}
	

	@Override
	public boolean savePhotoFile(int id, InputStream s) {
	
		return false;}
	
	@Override
	public boolean removePhotoFile(int id) {

		return false;}
	
	@Override
	public boolean removePhotoThumbFile(int id) {

		return false;}
	
	@Override
	public boolean savePhotoFile1(Photo photos, File file) {

		return false;}
	

	@Override
	public Optional<File> getPhotoThumbFile(int id) {

		return null;}
	@Transactional
	@Override
	public Product setProduct(int photosId, int productsId) {
		Object photoId = null;
		Photo photo = em.find( Photo.class, photoId );
		Object productId = null;
		Product products = em.find( Product.class, productId );

		if( photo == null || products == null )
			return null;

		photo.setProducts( products );



		return  products;

	}
}