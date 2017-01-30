package com.mesEncheresV2.filRouge.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mesEncheresV2.filRouge.metier.Offer;
import com.mesEncheresV2.filRouge.repositories.Offer_Repository;

@Controller
@RequestMapping(value="/offer")
public class OfferController {



	private Offer_Repository offer_Repository;

	public Offer_Repository getOffer_Repository() {
		return offer_Repository;}
	public void setOffer_Repository(Offer_Repository offer_Repository) {
		this.offer_Repository = offer_Repository;}


	// addOneProduct

	@RequestMapping(method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public Offer addOneOffer(@RequestBody Offer offers)
	{		
		return this.getOffer_Repository().save(offers);
	}

}
