package com.mesEncheresV2.filRouge.metier;


import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


//mapping aution_session
@Entity
public class Basic_User  {
	@Column(nullable=false,length=5)
	private int id;
	@Column(nullable=false,length=30)
	private String username;
	@Column(nullable=false,length=30)
	private String password;
	@Column(nullable=false,length=25)
	private String surname;
	@Column(nullable=false,length=25)
	private String firstname;
	@Column(nullable=false,length=50)
	private String adress;
	@Column(nullable=false,length=10)
	private int postal_code;
	@Column(nullable=false,length=20)
	private String city;
	@Column(nullable=false,length=15)
	private String pays;
	@Column(nullable=false,length=25)
	private String email;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date birthdayDate;
	@Column(nullable=false)
	private int phoneNumber;
	

	// Instanciation objets métier 
	
	private Set <Product> products;
	private Photo photos;
	private Set<Auction_Session> Auction_Sessions;

	
	//getter and setter
	
	
	@OneToMany
	public Set<Product> getProducts() {
		return products;}
	public void setProducts(Set<Product> products) {
		this.products = products;}
	@OneToOne
	public Photo getPhotos() {
		return photos;}
	public void setPhotos(Photo photos) {
		this.photos = photos;}
	
	@ManyToMany(mappedBy="encherisseurs")
	public Set<Auction_Session> getAuction_Sessions() {
		return Auction_Sessions;}
	public void setAuction_Sessions(Set<Auction_Session> auction_Session) {
		Auction_Sessions = auction_Session;}
	
@Id @GeneratedValue
	public int getId() {
		return id;}
	public void setId(int id) {
		this.id = id;}
	public String getUsername() {
		return username;}
	public void setUsername(String username) {
		this.username = username;}
	public String getPassword() {
		return password;}
	public void setPassword(String password) {
		this.password = password;}
	public String getSurname() {
		return surname;}
	public void setSurname(String surname) {
		this.surname = surname;}
	public String getFirstname() {
		return firstname;}
	public void setFirstname(String firstname) {
		this.firstname = firstname;	}
	public int getPostal_code() {
		return postal_code;	}
	public void setPostal_code(int postal_code) {
		this.postal_code = postal_code;	}
	public String getCity() {
		return city;}
	public void setCity(String city) {
		this.city = city;}
	public String getPays() {
		return pays;}
	public void setPays(String pays) {
		this.pays = pays;}
	public String getEmail() {
		return email;}
	public void setEmail(String email) {
		this.email = email;}
	public Date getBirthdayDate() {
		return birthdayDate;}
	public void setBirthdayDate(Date birthdayDate) {
		this.birthdayDate = birthdayDate;}
	public int getPhoneNumber() {
		return phoneNumber;}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;	}


	
	//Constructeurs

	

	
	public Basic_User(int id, String username, String password, String surname, String firstname, String adress,
			int postal_code, String city, String pays, String email, Date birthdayDate, int phoneNumber) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.surname = surname;
		this.firstname = firstname;
		this.adress = adress;
		this.postal_code = postal_code;
		this.city = city;
		this.pays = pays;
		this.email = email;
		this.birthdayDate = birthdayDate;
		this.phoneNumber = phoneNumber;
	} 
	public Basic_User(){ this(0,"","","","","",0,"","","",null,0);}
	
	// Utils
	
	@Override
	public String toString() {
		return "Basic_User [id=" + id + ", username=" + username + ", password=" + password + ", surname=" + surname
				+ ", firstname=" + firstname + ", adress=" + adress + ", postal_code=" + postal_code + ", city=" + city
				+ ", pays=" + pays + ", email=" + email + ", birthdayDate=" + birthdayDate + ", phoneNumber="
				+ phoneNumber + "]";
	}


	
}
