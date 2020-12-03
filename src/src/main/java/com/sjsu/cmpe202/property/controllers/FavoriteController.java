package com.sjsu.cmpe202.property.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sjsu.cmpe202.search.retail.listing.model.Favorite;
import com.sjsu.cmpe202.search.retail.listing.services.FavoriteService;


/*
 * Author: Atanu Ghosh
 */


@Repository
@RestController
public class FavoriteController {
	private FavoriteService favoriteServices;
	@Autowired
	EntityManager em;


	@Autowired
	public void setFavoriteService(FavoriteService favoriteService) {
		this.favoriteServices = favoriteService;
	}


	/*
	 * Shows all properties marked as Favorite
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/favorite/list")
	public List<Favorite> listFavorites(Model model){

		ArrayList<Favorite> listOfFavorite = new ArrayList<Favorite>();

		model.addAttribute("favorite", favoriteServices.listAll());

		Map<String, Object> modelMap = model.asMap();
		listOfFavorite  = (ArrayList<Favorite>) modelMap.get("favorite");
		return listOfFavorite;
	}

	/*
	 * Shows favorite by favoriteID
	 */
	@RequestMapping("favorite/show/{id}")
	public Favorite getFavorite(@PathVariable String id, Model model){
		model.addAttribute("favorite", favoriteServices.getById(Long.valueOf(id)));
		ArrayList<Favorite> listOfFavorite = new ArrayList<Favorite>();        
		Map<String, Object> modelMap = model.asMap();
		listOfFavorite=(ArrayList<Favorite>) modelMap.get("favorite");
		return listOfFavorite.get(0);


	}

	/*
	 * Search favorite by any favorite parameter
	 */
	@RequestMapping(method = RequestMethod.GET, value = "favorite/search")
	public List<Favorite> getFavorite(@RequestParam Map<String, String> customQuery)
	{
		return favoriteServices.constructQuery(customQuery).getResultList();

	}

	/*
	 * Add new favorites to the table
	 */
	@RequestMapping(method = RequestMethod.POST, value = "favorite/add")
	public void addFavorite(@RequestBody Favorite fav)
	{
		System.out.println("UserID="+fav.getUserid());
		favoriteServices.saveFav(fav);
	}

	/*
	 * Delete favorite by ID
	 */
	@RequestMapping("/favorite/delete/{id}")
	public String delete(@PathVariable String id){
		favoriteServices.delete(Long.valueOf(id));
		return "delete successful";
	}
}