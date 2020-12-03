package com.sjsu.cmpe202.search.retail.listing.services;

import java.util.List;
import java.util.Map;
import javax.persistence.TypedQuery;
import com.sjsu.cmpe202.search.retail.listing.model.Favorite;

/*
 * Author: Atanu Ghosh
 */

public interface FavoriteService {
	
    List<Favorite> listAll();
    
    Iterable<Favorite> getById(Long id);
    
    void saveFav(Favorite fav);
    
    void delete(Long id);  
    
    TypedQuery<Favorite> constructQuery(Map<String, String> customQuery);
    
}
