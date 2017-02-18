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
import com.mesEncheresV2.filRouge.metier.Auction_Session;
import com.mesEncheresV2.filRouge.repositories.AuctionSession_Repository;
import com.mesEncheresV2.filRouge.utils.JsonPageable;

@Controller
@RequestMapping(value="/auction_session")
public class Auction_SessionController {

	//Getters et setters de repository

			@Autowired
			private AuctionSession_Repository auctionSession_Repository;

			
			public AuctionSession_Repository getAuctionSession_Repository() {
				return auctionSession_Repository;}

			public void setAuctionSession_Repository(AuctionSession_Repository auctionSession_Repository) {
				this.auctionSession_Repository = auctionSession_Repository;}

			// Methodes findOne sur les AuctionSession

			

			@RequestMapping(value="/auction_session/",method = RequestMethod.POST, produces="application/json")
			@ResponseBody
			public Auction_Session  addOneSession(@RequestBody Auction_Session auction_Session)
			{
				return this.getAuctionSession_Repository().save(auction_Session);
				}

			// LISTE DE AUCTION_SESSION


			@RequestMapping(value="/auction_session/",method=RequestMethod.GET, produces="application/json")
			@ResponseBody
			//@JsonView(TagOnly.class)
			public Page<Auction_Session> listeSesion(@PageableDefault(page=0, size=10) Pageable pageRequest) {
				return JsonPageable.fromPage(this.getAuctionSession_Repository().findAll(pageRequest));}

			//RemoveOne methodes sur les auction_sessions

		

			@RequestMapping(value="auction_session/{id:[0-9]+}", method=RequestMethod.DELETE, produces="application/json")
			@ResponseBody
			//@JsonView(TagOnly.class)
			public void removeOneSession(@PathVariable("id") int id) {
				this.getAuctionSession_Repository().delete(id);}


			//Update sur les auction_sessions

			@RequestMapping(value="/auction_session/", method=RequestMethod.PUT, produces="application/json")
			@ResponseBody
			public Auction_Session updateOneSession(@RequestBody  Auction_Session Auction_Sessionsession)
			{
				Auction_Session session = null;
				Auction_Session old = this.getSession().findOne(session.getId());
				if (old == null)
				{
					return null;
				}
				else
				{
					old.setMaxAuctionAuto(session.getMaxAuctionAuto());
			
					this.getAuctionSession_Repository().save(old);
					return old;
				}
			}
			private CrudRepository<Auction_Session, Integer> getSession() {
				// TODO Auto-generated method stub
				return null;
			}

	

			public Auction_SessionController() {
				super();
				// TODO Auto-generated constructor stub
			}
		
		
		


	
	
}
