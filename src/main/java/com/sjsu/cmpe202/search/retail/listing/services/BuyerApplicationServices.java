package com.sjsu.cmpe202.search.retail.listing.services;

import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import com.sjsu.cmpe202.search.retail.listing.model.BuyerApplication;
/*
 * Yathukulan
 */
public interface BuyerApplicationServices {

    List<BuyerApplication> listAll();

    Iterable<BuyerApplication> getById(Long id);

    BuyerApplication saveOrUpdate(BuyerApplication buyerApplication);

    void delete(Long id);
    
    void savethis(BuyerApplication buyerApplication);
    
    TypedQuery<BuyerApplication> constructQuery(Map<String, String> customQuery);
    
}