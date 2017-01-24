package com.mesEncheresV2.filRouge.metier;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

//private/protected???:l'enfant pet voir le parent mais pas l'inverse hahaha


@Entity
public class Professionnal_User extends Basic_User{


	protected String business_name;
	protected String activity_domain;
	protected String compagny_name;
	protected String compagny_adress;
	protected int compagny_postal_code;
	protected String comapgny_city;


	//getters and setters


	@Column (nullable=false, length=35)
	public String getBusiness_name() {
		return business_name;}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;}
	
	@Column(nullable=false,length=20)
	public String getActivity_domain() {
		return activity_domain;}
	public void setActivity_domain(String activity_domain) {
		this.activity_domain = activity_domain;}
	
	@Column(nullable=false,length=20)
	public String getCompagny_name() {
		return compagny_name;}
	public void setCompagny_name(String compagny_name) {
		this.compagny_name = compagny_name;}
	
	@Column(nullable=false,length=50)
	public String getCompagny_adress() {
		return compagny_adress;}
	public void setCompagny_adress(String compagny_adress) {
		this.compagny_adress = compagny_adress;}
	
	@Column(nullable=false,length=10)
	public int getCompagny_postal_code() {
		return compagny_postal_code;}
	public void setCompagny_postal_code(int compagny_postal_code) {
		this.compagny_postal_code = compagny_postal_code;}
	
	@Column(nullable=false,length=20)
	public String getComapgny_city() {
		return comapgny_city;}
	public void setComapgny_city(String comapgny_city) {
		this.comapgny_city = comapgny_city;}


	// constructeurs



	public Professionnal_User(){this(0,"","","","","",0,"","","",null,0,"","","","",0,"");}



public Professionnal_User(int id, String username, String password, String surname, String firstname, String adress,
		int postal_code, String city, String pays, String email, Date birthdayDate, int phoneNumber,
		String business_name, String activity_domain, String compagny_name, String compagny_adress,
		int compagny_postal_code, String comapgny_city) {
	super(id, username, password, surname, firstname, adress, postal_code, city, pays, email, birthdayDate,
			phoneNumber);
	this.business_name = business_name;
	this.activity_domain = activity_domain;
	this.compagny_name = compagny_name;
	this.compagny_adress = compagny_adress;
	this.compagny_postal_code = compagny_postal_code;
	this.comapgny_city = comapgny_city;}

@Override
public String toString() {
	return "Professionnal_User [business_name=" + business_name + ", activity_domain=" + activity_domain
			+ ", compagny_name=" + compagny_name + ", compagny_adress=" + compagny_adress + ", compagny_postal_code="
			+ compagny_postal_code + ", comapgny_city=" + comapgny_city + "]";
}


}
