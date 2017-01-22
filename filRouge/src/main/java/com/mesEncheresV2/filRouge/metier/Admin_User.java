package com.mesEncheresV2.filRouge.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Admin_User {


	@Column(nullable=false,length=5)
	private int id;
	@Column(nullable=false,length=30)
	private String username;
	@Column(nullable=false,length=30)
	private  String password;
	@Column(nullable=false,length=25)
	private  String surname;
	@Column(nullable=false,length=25)
	private  String firstname;
	@Column(nullable=false,length=25)
	private  String admin_type;




	//Getter and setter

	@Id
	@GeneratedValue
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
		this.firstname = firstname;}
	public String getAdmin_type() {
		return admin_type;}
	public void setAdmin_type(String admin_type) {
		this.admin_type = admin_type;}



	//Constructeurs

	public Admin_User(){this(0,"","","","","");}

	public Admin_User(int id, String username, String password, String surname, String firstname, String admin_type) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.surname = surname;
		this.firstname = firstname;
		this.admin_type = admin_type;}


	//Utils


	@Override
	public String toString() {
		return "Admin_User [id=" + id + ", username=" + username + ", password=" + password + ", surname=" + surname
				+ ", firstname=" + firstname + ", admin_type=" + admin_type + "]";}

}
