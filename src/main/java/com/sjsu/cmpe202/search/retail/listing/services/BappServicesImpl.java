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
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sjsu.cmpe202.property.repositories.BappRepository;
import com.sjsu.cmpe202.search.retail.listing.model.Bapp;
import com.sjsu.cmpe202.search.retail.listing.model.User;


@Service
public class BappServicesImpl implements BappServices {

    private BappRepository bappRepository;
    
    private JavaMailSender javaMailSender;

    @Autowired
    EntityManager em;
    
    @Autowired
    public BappServicesImpl(BappRepository bappRepository) {
        this.bappRepository = bappRepository;
    }
    
    
    /*
     * Service method to list all users
     */
    @Override
    public List<Bapp> listAll() {
        List<Bapp> mylist = new ArrayList<>();
        bappRepository.findAll().forEach(mylist::add);
        return mylist;
    }
    

    @Override
    public void sendMail(User user) {

    		SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setTo(user.getEmail());
            
            String subject = "Homefinder response";
            String body = "Hi" + user.getFirstname() + "Your listing has received a response. check the portal for more information.";
            
            mailMessage.setSubject(subject);
            mailMessage.setText(body);
            mailMessage.setFrom("noreply@cmpe202project.com");

            javaMailSender.send(mailMessage);
        }
    	
    

    /*
     * Service method to list user by id
     */
    @Override
    public Iterable<Bapp> getById(Long id) {
    	
        List <Long> ids = new ArrayList<Long>();
        ((ArrayList<Long>) ids).add(id);
		return bappRepository.findAllById(ids);
    }

   
    /*
     * Service method to save new users. This method is to be used for new user registration.
     */
	@Override
	public void saveThis(Bapp bapp) {
		// TODO Auto-generated method stub
		try {
			Bapp saved=bappRepository.save(bapp);
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
    	bappRepository.deleteById(id);

    }
    
    @Override
    public Bapp saveOrUpdate(Bapp bapp) {
    	bappRepository.save(bapp);
        return bapp;
    }


	@Override
	public TypedQuery<Bapp> constructQuery(Map<String, String> customQuery) {
		CriteriaBuilder cb = null;
		try {
	    	 cb = em.getCriteriaBuilder();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	    	CriteriaQuery<Bapp> cq = cb.createQuery(Bapp.class);
	    	Root<Bapp> myroot = cq.from(Bapp.class);
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
	        TypedQuery<Bapp> query = em.createQuery(cq);
	        return query;
	}
    
}
