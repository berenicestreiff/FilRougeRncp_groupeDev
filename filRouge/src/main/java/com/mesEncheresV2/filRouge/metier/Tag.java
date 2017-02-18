package com.mesEncheresV2.filRouge.metier;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonView;
import com.mesEncheresV2.filRouge.utils.JsonPageable;

@Entity
public class Tag  {
	public static class TagOnly extends JsonPageable.PaginatedResult {}

	@JsonView( { TagOnly.class } )
	private int id;
	@JsonView( { TagOnly.class } )
	private String tag_name;

	// Instanciation objets métier 


	private Set<Product> products;


	@Id 
	@GeneratedValue
	public int getId() {
	return id;}
	public void setId(int id) {
	this.id = id;}
	
	@Column(nullable=false, length=25)
	public String getTag_name() {
	return tag_name;}
	public void setTag_name(String tag_name) {
	this.tag_name = tag_name;}


	@ManyToMany(mappedBy="tags")
	public Set<Product> getProducts() {
	if( this.products == null )
	this.products = new HashSet<>();
	return this.products;}

	public void setProducts(Set<Product> products) { this.products = products; }

	// Constructerus


	public Tag(int id, String tag_name) {
		super();
		this.id = id;
		this.tag_name = tag_name;}


	public Tag(){this(0,"");}

	// Utils

	@Override
	public String toString() {
		return "Tags [id=" + id + ", tag_name=" + tag_name + "]";}
}

