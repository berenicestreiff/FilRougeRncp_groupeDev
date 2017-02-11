package com.mesEncheresV2.filRouge.metier;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.mesEncheresV2.filRouge.metier.Auction_Session.Auction_SessionOnly;
import com.mesEncheresV2.filRouge.utils.JsonPageable;


@Entity
public class Admin_User extends Basic_User {
	public static class Admin_UserOnly extends JsonPageable.PaginatedResult {}

	@JsonView( { Admin_UserOnly.class } )
	private  String admin_type;


	//Getter and setter
	
	
	
	@Column(nullable=false,length=25)
	public String getAdmin_type() {
		return admin_type;}
	public void setAdmin_type(String admin_type) {
		this.admin_type = admin_type;}



	//Constructeurs

	public Admin_User(){this(0,"","","","","",0,"","","",new Date(),0,"");}
	public Admin_User(int id, String username, String password, String surname, String firstname, String adress,
			int postal_code, String city, String pays, String email, Date birthdayDate, int phoneNumber,
			String admin_type) {
		super(id, username, password, surname, firstname, adress, postal_code, city, pays, email, birthdayDate,
				phoneNumber);
		this.admin_type = admin_type;
	}


}
