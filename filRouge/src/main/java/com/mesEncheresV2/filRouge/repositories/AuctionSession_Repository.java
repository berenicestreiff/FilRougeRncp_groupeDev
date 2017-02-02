package com.mesEncheresV2.filRouge.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.mesEncheresV2.filRouge.metier.Auction_Session;


public interface AuctionSession_Repository extends CrudRepository<Auction_Session, Integer>  {

	AuctionSession_Repository save(AuctionSession_Repository addOneSession);

	AuctionSession_Repository findAll(Pageable pageRequest);





}
