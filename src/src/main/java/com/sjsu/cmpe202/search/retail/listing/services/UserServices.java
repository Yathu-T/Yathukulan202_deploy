package com.sjsu.cmpe202.search.retail.listing.services;

import java.util.List;

import com.sjsu.cmpe202.search.retail.listing.model.User;

/*
 * Author: Atanu Ghosh
 */

public interface UserServices
{
    List<User> listAll();
    
    Iterable<User> getById(Long id);

    void delete(Long id);

    void saveUser(User user);
}
