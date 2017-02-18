package com.mesEncheresV2.filRouge.metier;


import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;
import com.mesEncheresV2.filRouge.utils.JsonPageable;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Basic_User  {
	public static class Basic_UserOnly extends JsonPageable.PaginatedResult {}
	public static class Basic_All extends Basic_UserOnly {};
	public static class UserWithProduct extends Basic_UserOnly {};
	
	@JsonView( { Basic_UserOnly.class } )
	private int id;
	@JsonView( { Basic_UserOnly.class } )
	private String username;
	@JsonView( { Basic_UserOnly.class } )
	private  String password;
	@JsonView( { Basic_UserOnly.class } )
	private  String surname;
	@JsonView( { Basic_UserOnly.class } )
	private  String firstname;
	@JsonView( { Basic_UserOnly.class } )
	private  String adress;
	@JsonView( { Basic_UserOnly.class } )
	private  int postal_code;
	@JsonView( { Basic_UserOnly.class } )
	private String city;
	@JsonView( { Basic_UserOnly.class } )
	private  String pays;
	@JsonView( { Basic_UserOnly.class } )
	private  String email;
	@JsonView( { Basic_UserOnly.class } )
	private  Date birthdayDate;
	@JsonView( { Basic_UserOnly.class } )
	private  int phoneNumber;


	// Instanciation objets métier 

	@JsonView( { UserWithProduct.class } )
	private Set <Product> products;



	//getter and setter


	@OneToMany(mappedBy="seller",fetch=FetchType.EAGER)
	public Set<Product> getProducts() {
		return products;}
	public void setProducts(Set<Product> products) {
		this.products = products;}

	@Id @GeneratedValue
	public int getId() {
		return id;}
	public void setId(int id) {
		this.id = id;}
	
	@Column(nullable=false,length=10)
	public String getUsername() {
		return username;}
	public void setUsername(String username) {
		this.username = username;}
	
	@Column(nullable=false,length=10)
	public String getPassword() {
		return password;}
	public void setPassword(String password) {
		this.password = password;}
	
	@Column(nullable=false,length=35)
	public String getSurname() {
		return surname;}
	public void setSurname(String surname) {
		this.surname = surname;}
	
	@Column(nullable=false,length=35)
	public String getFirstname() {
		return firstname;}
	public void setFirstname(String firstname) {
		this.firstname = firstname;	}
	
	@Column(nullable=false,length=50)
	public String getAdress() {
		return adress;}
	public void setAdress(String adress) {
		this.adress = adress;}
	
	@Column(nullable=false,length=10)
	public int getPostal_code() {
		return postal_code;	}
	public void setPostal_code(int postal_code) {
		this.postal_code = postal_code;	}
	
	@Column(nullable=false,length=20)
	public String getCity() {
		return city;}
	public void setCity(String city) {
		this.city = city;}
	
	@Column(nullable=false,length=15)
	public String getPays() {
		return pays;}
	public void setPays(String pays) {
		this.pays = pays;}
	
	@Column(nullable=false,length=25)
	public String getEmail() {
		return email;}
	public void setEmail(String email) {
		this.email = email;}
	
	@Temporal(TemporalType.DATE)
	public Date getBirthdayDate() {
		return birthdayDate;}
	public void setBirthdayDate(Date birthdayDate) {
		this.birthdayDate = birthdayDate;}
	
	@Column(nullable=false)
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
