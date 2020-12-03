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

import com.sjsu.cmpe202.property.repositories.OpenhouseRepository;
import com.sjsu.cmpe202.search.retail.listing.model.Openhouse;


@Service
public class OpenhouseServicesImpl implements OpenhouseServices {

    private OpenhouseRepository openhouseRepository;

    @Autowired
    EntityManager em;
    
    @Autowired
    public OpenhouseServicesImpl(OpenhouseRepository openhouseRepository) {
        this.openhouseRepository = openhouseRepository;
    }
    /*
     * Service method to list all users
     */
    @Override
    public List<Openhouse> listAll() {
        List<Openhouse> mylist = new ArrayList<>();
        openhouseRepository.findAll().forEach(mylist::add);
        return mylist;
    }

    /*
     * Service method to list user by id
     */
    @Override
    public Iterable<Openhouse> getById(Long id) {
    	
        List <Long> ids = new ArrayList<Long>();
        ((ArrayList<Long>) ids).add(id);
		return openhouseRepository.findAllById(ids);
    }

   
    /*
     * Service method to save new users. This method is to be used for new user registration.
     */
	@Override
	public void saveThis(Openhouse openhouse) {
		// TODO Auto-generated method stub
		try {
			Openhouse saved=openhouseRepository.save(openhouse);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/*
	 * Service method to delete users, when Administrator wants to delete any user.
	 */
    public void delete(Long id) {
    	openhouseRepository.deleteById(id);

    }
    
    @Override
    public Openhouse saveOrUpdate(Openhouse openhouse) {
    	openhouseRepository.save(openhouse);
        return openhouse;
    }


	@Override
	public TypedQuery<Openhouse> constructQuery(Map<String, String> customQuery) {
		CriteriaBuilder cb = null;
		try {
	    	 cb = em.getCriteriaBuilder();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	    	CriteriaQuery<Openhouse> cq = cb.createQuery(Openhouse.class);
	    	Root<Openhouse> myroot = cq.from(Openhouse.class);
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
	        TypedQuery<Openhouse> query = em.createQuery(cq);
	        return query;
	}

    
}
