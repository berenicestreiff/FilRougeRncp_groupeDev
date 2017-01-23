package com.mesEncheresV2.filRouge.metier;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;



@Entity
public class Auction_Session {

	private int id;
	private int MaxAuctionAuto;


	// instanciation objets métier


	private Product products;
	private Set<Offer> offers;
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
	public Product getProducts() {
		return products;}
	public void setProducts(Product products) {
		this.products = products;}

	@OneToMany(mappedBy="auction_sessions")
	public Set<Offer> getOffers() {
		return offers;}
	public void setOffers(Set<Offer> offers) {
		this.offers = offers;}




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
