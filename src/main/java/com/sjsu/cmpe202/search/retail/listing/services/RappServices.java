package com.sjsu.cmpe202.search.retail.listing.services;

import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import com.sjsu.cmpe202.search.retail.listing.model.Rapp;
/*
 * Yathukulan
 */
public interface RappServices
{
    List<Rapp> listAll();
    
    Iterable<Rapp> getById(Long id);

    Rapp saveOrUpdate(Rapp rapp);
    
    void delete(Long id);

    void saveThis(Rapp rapp);
    
    TypedQuery<Rapp> constructQuery(Map<String, String> customQuery);
}
