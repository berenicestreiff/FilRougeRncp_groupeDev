package com.mesEncheresV2.filRouge.metier;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.mesEncheresV2.filRouge.utils.JsonPageable;

@Entity
public class Offer {
	public static class OfferOnly extends JsonPageable.PaginatedResult{}
	public static class OfferWithProduct  extends OfferOnly{}

	@JsonView( { OfferOnly.class } )
	private int id;

	@JsonView( { OfferOnly.class } )
	int nouveauMontant;

	@JsonView( { OfferOnly.class } )
	private Date dateEnchere;



	//Instanciation des objets métier

	@JsonView( { OfferWithProduct.class } )
	private Product products;



	//Getter and setter

	@ManyToOne(fetch=FetchType.EAGER)
	public Product getProducts() {
		return products;
	}
	public void setProducts(Product products) {
		this.products = products;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;}

	public void setId(int id) {
		this.id = id;}

	@Column(nullable=false,length=10)
	public int getNouveauMontant() {
		return nouveauMontant;	}
	public void setNouveauMontant(int nouveauMontant) {
		this.nouveauMontant = nouveauMontant;}

	@Column(nullable=false,length=10)
	public Date getDateEnchere() {
		return dateEnchere;}
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;}



	//Constructeurs


	public Offer(){this(0,0,new Date());}


	public Offer(int id, int nouveauMontant, Date dateEnchere) {
		super();
		this.id = id;
		this.nouveauMontant = nouveauMontant;
		this.dateEnchere = dateEnchere;

	}


	// Utils

	@Override
	public String toString() {
		return "Offer [id=" + id + ", nouveauMontant=" + nouveauMontant + ", dateEnchere=" + dateEnchere + "]";
	}

}
