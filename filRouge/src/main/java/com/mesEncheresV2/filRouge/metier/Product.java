package com.mesEncheresV2.filRouge.metier;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// reste un pb de mapping entre les classes auction et picture
@Entity
public class Product implements Serializable {
 
	private static final long serialVersionUID = 1L;
	

@Column(nullable=false)
	private int id;
@Column(nullable=false, length=100)
	private String désignation;
@Column(nullable=false, length=200)
	private String description;
@Column(nullable=false, length=10)
	private int initialPrice;
@Column(nullable=false, length=10)
    private int minimumAuction;	
@Column(nullable=false, length=30)

	@Id @GeneratedValue
	public int getId() {
		return id;}
	public void setId(int id) {
		this.id = id;}
	public String getDésignation() {
		return désignation;}
	public void setDésignation(String désignation) {
		this.désignation = désignation;}
	public String getDescription() {
		return description;	}
	public void setDescription(String description) {
		this.description = description;}
	public int getInitialPrice() {
		return initialPrice;}
	public void setInitialPrice(int initialPrice) {
		this.initialPrice = initialPrice;}
	public int getMinimumAuction() {
		return minimumAuction;}
	public void setMinimumAuction(int minimumAuction) {
		this.minimumAuction = minimumAuction;}


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
	
	Basic_User vendeur;
	Auction_Session session;
	
	private Set <Tag>tags;
	private Set <Photo>photos;
	private Set <Basic_User> users;
	private Offer offers;

//je laisse les pictures au cas où on décide e complecxifir par la suite



	@ManyToOne
	public Set<Basic_User> getUsers() {
		return users;}
	public Offer getOffers() {
		return offers;
	}
	
	@OneToOne
	public void setOffers(Offer offers) {
		this.offers = offers;}
	public void setUsers(Set<Basic_User> users) {
		this.users = users;}

@OneToOne
	public Set<Photo> getPhotos() {
		return photos;}
	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;}
	@ManyToMany
	public Set<Tag> getTags() {
		return tags;}
	public void setTags(Set<Tag> tags) {
		this.tags = tags;}
	
	
}



