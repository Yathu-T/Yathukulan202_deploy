package com.sjsu.cmpe202.search.retail.listing.services;

import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import com.sjsu.cmpe202.search.retail.listing.model.Openhouse;
/*
 * Yathukulan
 */
public interface OpenhouseServices
{
    List<Openhouse> listAll();
    
    Iterable<Openhouse> getById(Long id);

    Openhouse saveOrUpdate(Openhouse openhouse);
    
    void delete(Long id);

    void saveThis(Openhouse openhouse);
    
    TypedQuery<Openhouse> constructQuery(Map<String, String> customQuery);
}
