package com.mesEncheresV2.filRouge.metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;
import com.mesEncheresV2.filRouge.metier.Asset.AssetOnly;
import com.mesEncheresV2.filRouge.utils.JsonPageable.PaginatedResult;

@Entity
public class AssetSource {

public static final int UNKOWN_SOURCE_ID = 1;
	
	public static class AssetSourceOnly extends PaginatedResult {};
	
	@JsonView({AssetSourceOnly.class, AssetOnly.class})
	private int id;
	@JsonView({AssetSourceOnly.class, AssetOnly.class})
	private String name;
	@JsonView({AssetSourceOnly.class, AssetOnly.class})
	private String url;
	@JsonView({AssetSourceOnly.class, AssetOnly.class})
	private String description;
	
	private Set<Asset> assets;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getUrl() {return url;}
	public void setUrl(String url) {this.url = url;}
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	
	@OneToMany(mappedBy="source")
	public Set<Asset> getAssets() {
		if (assets == null)
			assets = new HashSet<>();
		return assets;
	}
	public void setAssets(Set<Asset> assets) {this.assets = assets;}
	
	
	public AssetSource() { this(0, "", "", "");}
	public AssetSource(int id, String name, String url, String description) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.description = description;
	}
	
}

