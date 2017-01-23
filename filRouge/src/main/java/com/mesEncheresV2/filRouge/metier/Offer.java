package com.mesEncheresV2.filRouge.metier;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Offer {

	@Column(nullable=false,length=5)
	private int id;
	@Column(nullable=false,length=10)
	int nouveauMontant;
	@Column(nullable=false,length=10)
	private Date dateEnchere;



	//Instanciation des objets métier

	private Auction_Session auction_sessions;


	//Getter and setter

	@Id
	@GeneratedValue
	public int getId() {
		return id;}
	public void setId(int id) {
		this.id = id;}
	public int getNouveauMontant() {
		return nouveauMontant;	}
	public void setNouveauMontant(int nouveauMontant) {
		this.nouveauMontant = nouveauMontant;}
	public Date getDateEnchere() {
		return dateEnchere;}
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;}

	@ManyToOne
	public Auction_Session getAuction_sessions() {
		return auction_sessions;}
	public void setAuction_sessions(Auction_Session auction_sessions) {
		this.auction_sessions = auction_sessions;}


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
