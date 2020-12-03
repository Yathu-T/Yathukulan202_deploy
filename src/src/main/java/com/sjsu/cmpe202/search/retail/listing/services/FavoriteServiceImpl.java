package com.sjsu.cmpe202.search.retail.listing.services;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjsu.cmpe202.property.repositories.FavoriteRepository;
import com.sjsu.cmpe202.search.retail.listing.model.Favorite;
import com.sjsu.cmpe202.search.retail.listing.model.User;

/*
 * Author: Atanu Ghosh
 */

@Service
public class FavoriteServiceImpl implements FavoriteService{

	private FavoriteRepository favoriteRepository;

	@Autowired
	EntityManager em;

	@Autowired
	public FavoriteServiceImpl(FavoriteRepository favoriteRepository) {
		this.favoriteRepository = favoriteRepository;
	}

	@Override
	public List<Favorite> listAll() {
		List<Favorite> favorite = new ArrayList<>();
		favoriteRepository.findAll().forEach(favorite::add);
		return favorite;
	}

	/*
	 * Service method to search by id.
	 */
	 @Override
	 public Iterable<Favorite> getById(Long id) {
		 List <Long> ids = new ArrayList<Long>();
		 ((ArrayList<Long>) ids).add(id);
		 return favoriteRepository.findAllById(ids);
	 }

	 /*
	  * Service method to save new favorite homes to the database
	  */
	 @Override
	 public void saveFav(Favorite fav) {
		 try {
			 Favorite saveFav=favoriteRepository.save(fav);
		 }
		 catch (Exception e) {
			 e.printStackTrace();
		 }

	 }

	 /*
	  * Service method to delete existing favorite home bu id
	  */
	 @Override
	 public void delete(Long id) {
		 favoriteRepository.deleteById(id);		
	 }

	 /*
	  * Service method to search for favorite homes by userid or propertyid
	  * This method can be used to display all homes that a user have marked as favorite.
	  */
	 @Override
	 public TypedQuery<Favorite> constructQuery(Map<String, String> customQuery) {
		 CriteriaBuilder cb = null;
		 try {
			 cb = em.getCriteriaBuilder();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 CriteriaQuery<Favorite> cq = cb.createQuery(Favorite.class);
		 Root<Favorite> favorite = cq.from(Favorite.class);
		 Predicate predicate = null;

		 try {

			 for (Map.Entry<String,String> entry : customQuery.entrySet())  
			 {   
				 if(favorite.get(entry.getKey().toString()) != null)
				 {
					 predicate = cb.equal(favorite.get(entry.getKey().toString()), customQuery.get(entry.getKey().toString()));

				 }
			 }
		 }catch (Exception e) {
			 e.printStackTrace();
		 }
		 cq.where(predicate);
		 TypedQuery<Favorite> query = em.createQuery(cq);
		 return query;
	 }

}
