package com.sjsu.cmpe202.search.retail.listing.services;

import java.util.List;
import java.util.Map;
import javax.persistence.TypedQuery;
import com.sjsu.cmpe202.search.retail.listing.model.Property;

/*
 * Author: Atanu Ghosh
 */

public interface PropertyServices {

    List<Property> listAll();

    Iterable<Property> getById(Long id);

    Property saveOrUpdate(Property property);

    void delete(Long id);
    
    TypedQuery<Property> constructQuery(Map<String, String> customQuery);
    
}