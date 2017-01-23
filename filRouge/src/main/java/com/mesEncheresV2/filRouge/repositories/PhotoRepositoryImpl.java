package com.mesEncheresV2.filRouge.repositories;

import java.io.File;
import java.util.Optional;
import com.mesEncheresV2.filRouge.metier.Basic_User;
import com.mesEncheresV2.filRouge.metier.Photo;
import com.mesEncheresV2.filRouge.metier.Product;

public class PhotoRepositoryImpl implements PhotoRepositoryCustom {

	@Override
	public Optional<File> getImageFile(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Basic_User setEncherisseurs(int photoId, int encherisseursId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product setProduct(int photoId, int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveImageFile1(Photo photo, File file) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveImageFile1(int id, File file) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveImageFile(int id, File file) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveImageFile(Photo photo, File file) {
		// TODO Auto-generated method stub
		return false;
	}



}