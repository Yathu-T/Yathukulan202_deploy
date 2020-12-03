package com.sjsu.cmpe202.search.retail.listing.services;

import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import com.sjsu.cmpe202.search.retail.listing.model.Bapp;
import com.sjsu.cmpe202.search.retail.listing.model.User;
/*
 * Yathukulan
 */
public interface BappServices
{
    List<Bapp> listAll();
    
    Iterable<Bapp> getById(Long id);

    Bapp saveOrUpdate(Bapp bapp);
    
    void delete(Long id);

    void saveThis(Bapp bapp);
    
    TypedQuery<Bapp> constructQuery(Map<String, String> customQuery);
    
    void sendMail(User user);
}
