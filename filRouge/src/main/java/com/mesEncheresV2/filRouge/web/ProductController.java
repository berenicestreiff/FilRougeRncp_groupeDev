package com.mesEncheresV2.filRouge.web;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

import com.fasterxml.jackson.annotation.JsonView;
import com.mesEncheresV2.filRouge.metier.Auction_Session;
import com.mesEncheresV2.filRouge.metier.Basic_User;
import com.mesEncheresV2.filRouge.metier.Offer;
import com.mesEncheresV2.filRouge.metier.Product;
import com.mesEncheresV2.filRouge.metier.Product.ProductOnly;
import com.mesEncheresV2.filRouge.metier.Tag;
import com.mesEncheresV2.filRouge.metier.Tag.TagOnly;
import com.mesEncheresV2.filRouge.repositories.BasicUser_Repository;
import com.mesEncheresV2.filRouge.repositories.Offer_Repository;
import com.mesEncheresV2.filRouge.repositories.Product_Repository;
import com.mesEncheresV2.filRouge.repositories.Tag_Repository;
import com.mesEncheresV2.filRouge.utils.JsonPageable;



@Controller
@RequestMapping(value="/product")
public class ProductController
{




	// Mes Getters and Setters de repository

	@Autowired
	private Product_Repository productRepository;


	public Product_Repository getProductRepository() {
		return productRepository;}
	public void setProductRepository(Product_Repository productRepository) {
		this.productRepository = productRepository;}

	@Autowired
	private BasicUser_Repository basicUser_Repository;

	public BasicUser_Repository getBasicUser_Repository() {
		return basicUser_Repository;}
	public void setBasicUser_Repository(BasicUser_Repository basicUser_Repository) {
		this.basicUser_Repository = basicUser_Repository;}

	@Autowired
	private Offer_Repository offerRepository;


	public Offer_Repository getOfferRepository() {
		return offerRepository;}
	public void setOfferRepository(Offer_Repository offerRepository) {
		this.offerRepository = offerRepository;}


	@Autowired

	private Tag_Repository Tag_Repository;

	public Tag_Repository getTag_Repository() {
		return Tag_Repository;}
	public void setTag_Repository(Tag_Repository tag_Repository) {
		Tag_Repository = tag_Repository;}
	
	// 	associer une offr à un product dans un POST
	
	@RequestMapping(value="/associeroffer/{produitId:[0-9]+}/{offerId:[0-9]+}", method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public void addOneProductByOffer(
			@PathVariable("produitId") int produitId,
			@PathVariable("offerId") int offerId)
	{
		Product p = this.getProductRepository().findOne(produitId);
		Offer o = this.getOffer_Repository().findOne(offerId);
		p.addOffer(o);
		this.getProductRepository().save(p);
	}

	// associer un tag à un produit

	@RequestMapping(value="/associertag/{produitId:[0-9]+}/{tagId:[0-9]+}", method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public void addOneProductByTags(
			@PathVariable("produitId") int produitId,
			@PathVariable("tagId") int tagId)
	{
		Product p = this.getProductRepository().findOne(produitId);
		Tag t = this.getTag_Repository().findOne(tagId);
		p.addTag(t);
		this.getProductRepository().save(p);
	}

	@RequestMapping(value="/deassociertag/{productId:[0-9,]+}/{tagId:[0-9]+}", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public void removeProductByTag(
			@PathVariable("productId") int productId,
			@PathVariable("tagId") int tagId) {
		Product p = this.getProductRepository().findOne(productId);
		Tag t = this.getTag_Repository().findOne(tagId);
		p.removeTag(t);
		this.getProductRepository().save(p);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public Product addOne(@RequestBody Product products)
	{
		if (products.getSeller() == null)
			return null;
		Basic_User user = this.getBasicUser_Repository().findOne(products.getSeller().getId());
		if (user == null)
			return null;
		products.setSeller(user);
		return this.getProductRepository().save(products);
	}


	//Lister des Porduits

	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	//@JsonView(TagOnly.class)
	public Page<Product> liste(@PageableDefault(page=0, size=10) Pageable pageRequest) {
		return JsonPageable.fromPage(this.getProductRepository().findAll(pageRequest));
	}

	// Remove

	@RequestMapping(value="/{id:[0-9]+}", method=RequestMethod.DELETE, produces="application/json")
	@ResponseBody
	//@JsonView(TagOnly.class)
	public void removeOne(@PathVariable("id") int id) {
		this.getProductRepository().delete(id);
	}

	//Update product

	@RequestMapping(method=RequestMethod.PUT, produces="application/json")
	@ResponseBody
	public Product updateOne(@RequestBody Product products)
	{
		Product old = this.getProductRepository().findOne(products.getId());
		if (old == null)
		{
			return null;
		}
		else


		{
			old.setDesignation(products.getDesignation());
			old.setDescription(products.getDescription());
			old.setInitialPrice(products.getInitialPrice());
			old.setMinimumAuction(products.getMinimumAuction());
			this.getProductRepository().save(old);
			return old;
		}
	}




	@RequestMapping(value = "/demarrer/{id:[0-9]+}", method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public Product demarrer(@PathVariable("id") int id)
	{
		Product products = this.getProductRepository().findOne(id);
		if (products.getSession() != null)
			return null;
		products.setSession(new Auction_Session(0, 0));
		this.getProductRepository().save(products);
		return products;
	}


}



