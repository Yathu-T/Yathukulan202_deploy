package com.sjsu.cmpe202.property.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sjsu.cmpe202.search.retail.listing.model.Property;
import com.sjsu.cmpe202.search.retail.listing.services.PropertyServices;

/*
 * Author: Atanu Ghosh
 */

@Repository
@RestController
public class PropertyController {
	private PropertyServices propertyServices;
	@Autowired
	EntityManager em;


	@Autowired
	public void setPropertyService(PropertyServices propertyService) {
		this.propertyServices = propertyService;
	}


	/*
	 * Shows all properties
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/property/list")
	public List<Property> listPropertys(Model model){

		ArrayList<Property> listOfProperty = new ArrayList<Property>();

		model.addAttribute("property", propertyServices.listAll());

		Map<String, Object> modelMap = model.asMap();
		listOfProperty  = (ArrayList<Property>) modelMap.get("property");
		return listOfProperty;
	}

	/*
	 * Shows property by propertyID
	 */
	@RequestMapping("property/show/{id}")
	public Property getProperty(@PathVariable String id, Model model){
		model.addAttribute("property", propertyServices.getById(Long.valueOf(id)));
		ArrayList<Property> listOfProperty = new ArrayList<Property>();        
		Map<String, Object> modelMap = model.asMap();
		listOfProperty=(ArrayList<Property>) modelMap.get("property");
		return listOfProperty.get(0);


	}

	/*
	 * Search property by any property parameter
	 */
	@RequestMapping(method = RequestMethod.GET, value = "property/search")
	public List<Property> getProperty(@RequestParam Map<String, String> customQuery)
	{
		return propertyServices.constructQuery(customQuery).getResultList();

	}


	/*
	 * Delete property by ID
	 */
	@RequestMapping("/property/delete/{id}")
	public String delete(@PathVariable String id){
		propertyServices.delete(Long.valueOf(id));
		return "delete successful";
	}
}
