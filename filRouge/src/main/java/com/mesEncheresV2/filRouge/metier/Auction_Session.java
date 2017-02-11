package com.mesEncheresV2.filRouge.metier;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.mesEncheresV2.filRouge.utils.JsonPageable;



@Entity
public class Auction_Session {
	public static class Auction_SessionOnly extends JsonPageable.PaginatedResult {}

	@JsonView( { Auction_SessionOnly.class } )
	private int id;
	@JsonView( { Auction_SessionOnly.class } )
	private int MaxAuctionAuto;


	// instanciation objets métier


	private Product products;
	private Set<Basic_User> encherisseurs;


	//Getter and setter

	@Id
	@GeneratedValue
	public int getId() {
		return id;}
	public void setId(int id) {
		this.id = id;}
	public int getMaxAuctionAuto() {
		return MaxAuctionAuto;}
	public void setMaxAuctionAuto(int maxAuctionAuto) {
		MaxAuctionAuto = maxAuctionAuto;}
	
	@OneToOne
	public Product getProducts() {
		return products;}
	public void setProducts(Product products) {
		this.products = products;}



	// COnstructeurs

	public Auction_Session(){this(0,0);}


	@ManyToMany
	public Set<Basic_User> getEncherisseurs() {
		return encherisseurs;
	}
	public void setEncherisseurs(Set<Basic_User> encherisseurs) {
		this.encherisseurs = encherisseurs;
	}
	public Auction_Session(int id, int maxAuctionAuto) {
		super();
		this.id = id;
		MaxAuctionAuto = maxAuctionAuto;
	}


	// Utils

	@Override
	public String toString() {
		return "Auction_Session [id=" + id + ", MaxAuctionAuto=" + MaxAuctionAuto + "]";
	}

}
