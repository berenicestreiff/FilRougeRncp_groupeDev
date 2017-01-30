package com.mesEncheresV2.filRouge.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mesEncheresV2.filRouge.metier.Admin_User;
import com.mesEncheresV2.filRouge.metier.Basic_User;
import com.mesEncheresV2.filRouge.metier.Professionnal_User;
import com.mesEncheresV2.filRouge.repositories.AdminUser_Repository;
import com.mesEncheresV2.filRouge.repositories.BasicUser_Repository;
import com.mesEncheresV2.filRouge.repositories.ProfessionalUser_Repository;
import com.mesEncheresV2.filRouge.utils.JsonPageable;


@Controller
@RequestMapping(value="/user")
public class UserController {


	//Getters et setters de repository

	@Autowired
	private AdminUser_Repository adminUserRepository;


	public AdminUser_Repository getAdminUserRepository() {
		return adminUserRepository;}
	public void setAdminUserRepository(AdminUser_Repository adminUserRepository) {
		this.adminUserRepository = adminUserRepository;}

	@Autowired
	private BasicUser_Repository basicUserRepository;


	public BasicUser_Repository getBasicUserRepository() {
		return basicUserRepository;}
	public void setBasicUserRepository(BasicUser_Repository basicUserRepository) {
		this.basicUserRepository = basicUserRepository;}

	@Autowired
	private ProfessionalUser_Repository professionalUserRepository;


	public ProfessionalUser_Repository getProfessionalUserRepository() {
		return professionalUserRepository;}
	public void setProfessionalUserRepository(ProfessionalUser_Repository professionalUserRepository) {
		this.professionalUserRepository = professionalUserRepository;}

	// Methodes findOne sur nos différents types de users

	@RequestMapping(value="/basic",method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public Basic_User addOneBasicUser(@RequestBody Basic_User user)
	{
		return this.getBasicUserRepository().save(user);}

	@RequestMapping(value="/pro",method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public Professionnal_User addOneProUser(@RequestBody Professionnal_User  user)
	{
		return this.getProfessionalUserRepository().save(user);}

	@RequestMapping(value="/admin",method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public Admin_User addOneAdminUser(@RequestBody Admin_User  user)
	{
		return this.getAdminUserRepository().save(user);}



	// nos methodes List sur nos différents users


	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	//@JsonView(TagOnly.class)
	public Page<Basic_User> listeBasic(@PageableDefault(page=0, size=10) Pageable pageRequest) {
		return JsonPageable.fromPage(this.getBasicUserRepository().findAll(pageRequest));}


	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	//@JsonView(TagOnly.class)
	public Page<Admin_User> listeAdmin(@PageableDefault(page=0, size=10) Pageable pageRequest) {
		return JsonPageable.fromPage(this.getAdminUserRepository().findAll(pageRequest));}

	//RemoveOne methodes sur les différents types de users

	@RequestMapping(value="/basic/{id:[0-9]+}", method=RequestMethod.DELETE, produces="application/json")
	@ResponseBody
	//@JsonView(TagOnly.class)
	public void removeOneBasic(@PathVariable("id") int id) {
		this.getBasicUserRepository().delete(id);}

	@RequestMapping(value="/pro/{id:[0-9]+}", method=RequestMethod.DELETE, produces="application/json")
	@ResponseBody
	//@JsonView(TagOnly.class)
	public void removeOnePro(@PathVariable("id") int id) {
		this.getProfessionalUserRepository().delete(id);}

	@RequestMapping(value="/admin/{id:[0-9]+}", method=RequestMethod.DELETE, produces="application/json")
	@ResponseBody
	//@JsonView(TagOnly.class)
	public void removeOneAdmin(@PathVariable("id") int id) {
		this.getAdminUserRepository().delete(id);}


	//Update sur les différents types users

	@RequestMapping(value="/basic", method=RequestMethod.PUT, produces="application/json")
	@ResponseBody
	public Basic_User updateOneBasic(@RequestBody Basic_User user)
	{
		Basic_User old = this.getBasicUserRepository().findOne(user.getId());
		if (old == null)
		{
			return null;
		}
		else
		{
			old.setUsername(user.getUsername());
			old.setPassword(user.getPassword());
			old.setSurname(user.getSurname());
			old.setFirstname(user.getFirstname());
			old.setAdress(user.getAdress());
			old.setPostal_code(user.getPostal_code());
			old.setCity(user.getCity());
			old.setPays(user.getPays());
			old.setEmail(user.getEmail());
			old.setBirthdayDate(user.getBirthdayDate());
			old.setPhoneNumber(user.getPhoneNumber());

			this.getBasicUserRepository().save(old);
			return old;
		}
	}

	@RequestMapping(value="/pro", method=RequestMethod.PUT, produces="application/json")
	@ResponseBody
	public Professionnal_User updateOnePro(@RequestBody Professionnal_User user)
	{
		Professionnal_User old = this.getProfessionalUserRepository().findOne(user.getId());
		if (old == null)
		{
			return null;
		}
		else
		{


			old.setBusiness_name(user.getBusiness_name());
			old.setActivity_domain(user.getActivity_domain());
			old.setCompagny_name(user.getCompagny_name());
			old.setCompagny_adress(user.getCompagny_adress());
			old.setCompagny_postal_code(user.getCompagny_postal_code());
			old.setComapgny_city(user.getComapgny_city());


			this.getProfessionalUserRepository().save(old);
			return old;}
	}
	@RequestMapping(value="/admin", method=RequestMethod.PUT, produces="application/json")
	@ResponseBody
	public Admin_User updateOneAdmin(@RequestBody Admin_User user)
	{
		Admin_User old = this.getAdminUserRepository().findOne(user.getId());
		if (old == null)
		{
			return null;
		}
		else
		{

		
			old.setSurname(user.getSurname());
			old.setPassword(user.getPassword());
			old.setSurname(user.getSurname());
			old.setFirstname(user.getFirstname());
			old.setAdmin_type(user.getAdmin_type());
	
			this.getAdminUserRepository().save(old);
			return old;
		}

	}

}


