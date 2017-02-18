package com.mesEncheresV2.filRouge.metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OrderColumn;
@Entity
public class Gallery extends Asset {


private List<Photo> photos;

@ManyToMany(fetch=FetchType.EAGER)
@OrderColumn(name="position")
public List<Photo> getPhotos() {
	if (photos == null)
		photos = new ArrayList<>();
	return photos;

}
public void setPhotos(List<Photo> photos) {
	this.photos = photos;
}

public Gallery(List<Photo> photos) {
	super();
	this.photos = photos;
}
@Override
public String toString() {
	return "Gallery [photos=" + photos + "]";
}
public Gallery(int id, String name, String description, Date dateAdded) {
	super(id, name, description, dateAdded);

}

public Gallery() {
	this(0, "", "", null);
}


	
}
