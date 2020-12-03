package com.sjsu.cmpe202.search.retail.listing.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjsu.cmpe202.property.repositories.RappRepository;
import com.sjsu.cmpe202.search.retail.listing.model.Rapp;


@Service
public class RappServicesImpl implements RappServices {

    private RappRepository rappRepository;

    @Autowired
    EntityManager em;
    
    @Autowired
    public RappServicesImpl(RappRepository rappRepository) {
        this.rappRepository = rappRepository;
    }
    /*
     * Service method to list all users
     */
    @Override
    public List<Rapp> listAll() {
        List<Rapp> mylist = new ArrayList<>();
        rappRepository.findAll().forEach(mylist::add);
        return mylist;
    }

    /*
     * Service method to list user by id
     */
    @Override
    public Iterable<Rapp> getById(Long id) {
    	
        List <Long> ids = new ArrayList<Long>();
        ((ArrayList<Long>) ids).add(id);
		return rappRepository.findAllById(ids);
    }

   
    /*
     * Service method to save new users. This method is to be used for new user registration.
     */
	@Override
	public void saveThis(Rapp rapp) {
		// TODO Auto-generated method stub
		try {
			Rapp saved=rappRepository.save(rapp);
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
    	rappRepository.deleteById(id);

    }
    
    @Override
    public Rapp saveOrUpdate(Rapp rapp) {
    	rappRepository.save(rapp);
        return rapp;
    }


	@Override
	public TypedQuery<Rapp> constructQuery(Map<String, String> customQuery) {
		CriteriaBuilder cb = null;
		try {
	    	 cb = em.getCriteriaBuilder();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	    	CriteriaQuery<Rapp> cq = cb.createQuery(Rapp.class);
	    	Root<Rapp> myroot = cq.from(Rapp.class);
	    	Predicate predicate = null;
	    	
	    	try {
	    	
	    	for (Map.Entry<String,String> entry : customQuery.entrySet())  
	    	{
	            
	            if(myroot.get(entry.getKey().toString()) != null)
	            {
	            	
	            	//Query for range values with comma(,) as delimiter
	            	if(entry.getValue().contains(","))
	            	{
	            		int minRange=Integer.parseInt(customQuery.get(entry.getKey().toString()).split(",")[0]);
	            		int maxRange=Integer.parseInt(customQuery.get(entry.getKey().toString()).split(",")[1]);
	            		predicate = cb.between(myroot.get(entry.getKey().toString()),minRange, maxRange );
	            	}
	            	//Query for equals values
	            	else
	            	{
	            	 predicate = cb.equal(myroot.get(entry.getKey().toString()), customQuery.get(entry.getKey().toString()));
	            	}
	            }
	    	}
	    	}catch (Exception e) {
				e.printStackTrace();
			}
	        cq.where(predicate);
	        TypedQuery<Rapp> query = em.createQuery(cq);
	        return query;
	}

    
}
