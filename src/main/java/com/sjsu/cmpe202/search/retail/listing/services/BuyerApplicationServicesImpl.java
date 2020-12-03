package com.sjsu.cmpe202.search.retail.listing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.sjsu.cmpe202.property.repositories.BuyerApplicationRepository;
import com.sjsu.cmpe202.search.retail.listing.model.BuyerApplication;



@Service
public class BuyerApplicationServicesImpl implements BuyerApplicationServices{

    private BuyerApplicationRepository buyerApplicationRepository;

    @Autowired
    EntityManager em;
    
    @Autowired
    public BuyerApplicationServicesImpl(BuyerApplicationRepository buyerApplicationRepository) {
        this.buyerApplicationRepository = buyerApplicationRepository;
    }


    @Override
    public List<BuyerApplication> listAll() {
        List<BuyerApplication> buyerApplications = new ArrayList<>();
        buyerApplicationRepository.findAll().forEach(buyerApplications::add);
        return buyerApplications;
    }

    @Override
    public Iterable<BuyerApplication> getById(Long id) {
    	
        List <Long> ids = new ArrayList<Long>();
        ((ArrayList<Long>) ids).add(id);
		return buyerApplicationRepository.findAllById(ids);
    }

    @Override
    public BuyerApplication saveOrUpdate(BuyerApplication buyerApplication) {
        buyerApplicationRepository.save(buyerApplication);
        return buyerApplication;
    }

    @Override
    public void delete(Long id) {
        buyerApplicationRepository.deleteById(id);

    }

	@Override
	public void savethis(BuyerApplication buyerApplication) {
		try {
			BuyerApplication savedBuyerApplication=buyerApplicationRepository.save(buyerApplication);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public TypedQuery<BuyerApplication> constructQuery(Map<String, String> customQuery) {
		CriteriaBuilder cb = null;
		try {
	    	 cb = em.getCriteriaBuilder();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	    	CriteriaQuery<BuyerApplication> cq = cb.createQuery(BuyerApplication.class);
	    	Root<BuyerApplication> buyerApplication = cq.from(BuyerApplication.class);
	    	Predicate predicate = null;
	    	
	    	try {
	    	
	    	for (Map.Entry<String,String> entry : customQuery.entrySet())  
	    	{
	            
	            if(buyerApplication.get(entry.getKey().toString()) != null)
	            {
	            	
	            	//Query for range values with comma(,) as delimiter
	            	if(entry.getValue().contains(","))
	            	{
	            		int minRange=Integer.parseInt(customQuery.get(entry.getKey().toString()).split(",")[0]);
	            		int maxRange=Integer.parseInt(customQuery.get(entry.getKey().toString()).split(",")[1]);
	            		predicate = cb.between(buyerApplication.get(entry.getKey().toString()),minRange, maxRange );
	            	}
	            	//Query for equals values
	            	else
	            	{
	            	 predicate = cb.equal(buyerApplication.get(entry.getKey().toString()), customQuery.get(entry.getKey().toString()));
	            	}
	            }
	    	}
	    	}catch (Exception e) {
				e.printStackTrace();
			}
	        cq.where(predicate);
	        TypedQuery<BuyerApplication> query = em.createQuery(cq);
	        return query;
	}


}