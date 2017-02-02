package com.mesEncheresV2.filRouge.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mesEncheresV2.filRouge.metier.Tag;
import com.mesEncheresV2.filRouge.repositories.Tag_Repository;
import com.mesEncheresV2.filRouge.utils.JsonPageable;


// est-on obligs de mettre Page dans la requete lsite de tags?
// corriger update
@Controller
@RequestMapping(value="/tag")

public class TagController {

	//Getters et setters de repository

		@Autowired
		private Tag_Repository tag_Repository;

		
		public Tag_Repository getTag_Repository() {
			return tag_Repository;}
		public void setTag_Repository(Tag_Repository tag_Repository) {
			this.tag_Repository = tag_Repository;}



		// Methodes findOne sur les tags

		@RequestMapping(value="/tags",method = RequestMethod.POST, produces="application/json")
		@ResponseBody
		public Tag addOneTag(@RequestBody Tag tags)
		{
			return this.getTag_Repository().save(tags);}

		// nos methodes List nos tags


		@RequestMapping(value="/tags/",method=RequestMethod.GET, produces="application/json")
		@ResponseBody
		//@JsonView(TagOnly.class)
		public Page<Tag> listeTags(@PageableDefault(page=0, size=10) Pageable pageRequest) {
			return JsonPageable.fromPage(this.getTag_Repository().findAll(pageRequest));}

		//RemoveOne methodes sur les différents types de tags

	

		@RequestMapping(value="tags/{id:[0-9]+}", method=RequestMethod.DELETE, produces="application/json")
		@ResponseBody
		//@JsonView(TagOnly.class)
		public void removeOnePro(@PathVariable("id") int id) {
			this.getTag_Repository().delete(id);}


		//Update sur les tags

		@RequestMapping(value="/tags", method=RequestMethod.PUT, produces="application/json")
		@ResponseBody
		public Tag updateOneTag(@RequestBody Tag tags)
		{
			Tag old = this.getTags().findOne(tags.getId());
			if (old == null)
			{
				return null;
			}
			else
			{
				old.setTag_name(tags.getTag_name());
			
				this.getTag_Repository().save(old);
				return old;
			}
		}
		private CrudRepository<Tag, Integer> getTags() {
			// TODO Auto-generated method stub
			return null;
		}
		public TagController() {
			super();
			// TODO Auto-generated constructor stub
		}
	
	

}