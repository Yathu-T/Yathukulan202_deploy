package com.sjsu.cmpe202.search.retail.listing.services;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sjsu.cmpe202.property.repositories.UserRepository;
import com.sjsu.cmpe202.search.retail.listing.model.User;

/*
 * Author: Atanu Ghosh
 */

@Service
public class UserServicesImpl implements UserServices {

    private UserRepository userRepository;

    @Autowired
    EntityManager em;
    
    @Autowired
    public UserServicesImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    /*
     * Service method to list all users
     */
    @Override
    public List<User> listAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    /*
     * Service method to list user by id
     */
    @Override
    public Iterable<User> getById(Long id) {
    	
        List <Long> ids = new ArrayList<Long>();
        ((ArrayList<Long>) ids).add(id);
		return userRepository.findAllById(ids);
    }

   
    /*
     * Service method to save new users. This method is to be used for new user registration.
     */
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		try {
		User savedUser=userRepository.save(user);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/*
	 * Service method to delete users, when Administrator wants to delete any user.
	 */
    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);

    }

}
