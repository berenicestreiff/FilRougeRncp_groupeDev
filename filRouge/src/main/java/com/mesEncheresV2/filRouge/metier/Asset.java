package com.mesEncheresV2.filRouge.metier;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;
import com.mesEncheresV2.filRouge.utils.JsonPageable;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Asset {


	public static class AssetOnly extends JsonPageable.PaginatedResult {}

	
	@JsonView(AssetOnly.class)
	private int id;
	@JsonView(AssetOnly.class)
	private String name;
	@JsonView(AssetOnly.class)
	private String description;
	@JsonView(AssetOnly.class)
	private AssetSource source;
	@JsonView(AssetOnly.class)
	private Date dateAdded;
	@JsonView(AssetOnly.class)
	private LicenseType license;


	@ManyToOne
	public LicenseType getLicense() {return license;}
	public void setLicense(LicenseType license) {this.license = license;}
	
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	@Column(length=100)
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	@ManyToOne
	public AssetSource getSource() {return source;}
	public void setSource(AssetSource source) {this.source = source;}
	
	@Temporal(TemporalType.DATE)
	public Date getDateAdded() {return dateAdded;}
	public void setDateAdded(Date dateAdded) {this.dateAdded = dateAdded;}
	
	

	
	public Asset() { this(0, "", "", null);}
	public Asset(int id, String name, String description, Date dateAdded) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.dateAdded = dateAdded;
	}
	
	

}
