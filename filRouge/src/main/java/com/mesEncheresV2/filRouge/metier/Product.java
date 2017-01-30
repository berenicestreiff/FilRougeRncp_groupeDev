package com.mesEncheresV2.filRouge.metier;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity
public class Product {

	private int id;
	private String désignation;
	private String description;
	private int initialPrice;
	private int minimumAuction;	



	// Instanciation objets métier 

	private Basic_User seller;
	private Auction_Session session;

	private Set <Tag>tags;
	private Photo photos;
	private Offer offers;

	// Getter et setter

	@Id 
	@GeneratedValue
	public int getId() {
		return id;}
	public void setId(int id) {
		this.id = id;}
	
	@Column(nullable=false, length=50)
	public String getDésignation() {
		return désignation;}
	public void setDésignation(String désignation) {
		this.désignation = désignation;}
	
	@Column(nullable=false, length=200)
	public String getDescription() {
		return description;	}
	public void setDescription(String description) {
		this.description = description;}
	
	@Column(nullable=false, length=10)
	public int getInitialPrice() {
		return initialPrice;}
	public void setInitialPrice(int initialPrice) {
		this.initialPrice = initialPrice;}
	
	@Column(nullable=false, length=10)
	public int getMinimumAuction() {
		return minimumAuction;}
	public void setMinimumAuction(int minimumAuction) {
		this.minimumAuction = minimumAuction;}


	@OneToOne
	public Photo getPhotos() {
		return photos;}
	public void setPhotos(Photo photos) {
		this.photos = photos;}

	@ManyToOne
	public Basic_User getSeller() {
		return seller;}
	public void setSeller(Basic_User seller) {
		this.seller = seller;}

	@OneToOne
	public Auction_Session getSession() {
		return session;}
	public void setSession(Auction_Session session) {
		this.session = session;}

	@OneToOne
	public Offer getOffers() {
		return offers;}
	public void setOffers(Offer offers) {
		this.offers = offers;}


	@ManyToMany
	public Set<Tag> getTags() {
		if ( this.tags == null)
			this.tags = new HashSet<>();
		return this.tags;
	}
	public void setTags(Set<Tag> tags) { this.tags = tags; }


	// Constructeurs

	public Product(int id, String désignation, String description, int initialPrice, int minimumAuction,
			String fileName, String contentType, long fileSize, String fileHash) {
		super();
		this.id = id;
		this.désignation = désignation;
		this.description = description;
		this.initialPrice = initialPrice;
		this.minimumAuction = minimumAuction;

	}
	public Product() { this(0,"","",0,0,"","",0,"");}

	// utils

	@Override
	public String toString() {
		return "Product [id=" + id + ", désignation=" + désignation + ", description=" + description + ", initialPrice="
				+ initialPrice + ", minimumAuction=" + minimumAuction + ", photos=" + photos + "]";}

	public void setAuction_sessions(Auction_Session auction_Session) {
		// TODO Auto-generated method stub
		
	}
	public Object getAuction_sessions() {
		// TODO Auto-generated method stub
		return null;
	}


}



