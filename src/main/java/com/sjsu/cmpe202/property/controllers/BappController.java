package com.sjsu.cmpe202.property.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.sjsu.cmpe202.search.retail.listing.services.PropertyServices;
import com.sjsu.cmpe202.property.repositories.PropertyRepository;
import com.sjsu.cmpe202.search.retail.listing.model.Property;

import com.sjsu.cmpe202.search.retail.listing.services.UserServices;
import com.sjsu.cmpe202.property.repositories.UserRepository;
import com.sjsu.cmpe202.search.retail.listing.model.User;

import com.sjsu.cmpe202.property.repositories.BappRepository;
import com.sjsu.cmpe202.search.retail.listing.model.Bapp;
import com.sjsu.cmpe202.search.retail.listing.services.BappServices;
/*
 * Yathukulan
 */
@Repository
@RestController
public class BappController {
	private BappServices bappServices;
	
	@Autowired
	EntityManager em;

	@Autowired
	BappRepository bappRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PropertyRepository propertyRepository;

	@Autowired
	public void setBappService(BappServices bappServices) {
		this.bappServices = bappServices;
	}

	/*
	 * Shows all users
	 */
	@SuppressWarnings("unchecked")

	@RequestMapping("/sendemail")
	public ResponseEntity<Object> sendEmail(@PathVariable Bapp bapp) {
		Optional<Bapp> BuyerApplicationOptional = bappRepository.findById(bapp.getBappid());
		if (!BuyerApplicationOptional.isPresent())
			return ResponseEntity.notFound().build();
		
		long this_property_id = bapp.getPropertyid();
		Property this_property =  propertyRepository.findById(this_property_id).get();
		
		long this_realtor_id = Long.parseLong(this_property.getRealtorid());// string to long
		Optional<User> this_realtor_optional = userRepository.findById(this_realtor_id);
		User recipient = null ;
		
		if (!this_realtor_optional.isPresent()) {
			recipient = this_realtor_optional.get();
		}
		else {
			long this_owner_id = Long.parseLong(this_property.getOwnerid());
			recipient = userRepository.findById(this_owner_id).get();
		}
		
		bappServices.sendMail(recipient);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping("/Bapp/list")
	public List<Bapp> listTests(Model model){

		ArrayList<Bapp> arrlist = new ArrayList<Bapp>();

		model.addAttribute("bapp", bappServices.listAll());

		Map<String, Object> modelMap = model.asMap();
		arrlist  = (ArrayList<Bapp>) modelMap.get("bapp");
		return arrlist;
	}
	
	@RequestMapping("Bapp/show/{id}")
	public Bapp getBuyerApplication(@PathVariable String id, Model model) {
		model.addAttribute("bapp", bappServices.getById(Long.valueOf(id)));
		ArrayList<Bapp> arrlist = new ArrayList<Bapp>();
		Map<String, Object> modelMap = model.asMap();
		arrlist = (ArrayList<Bapp>) modelMap.get("bapp");
		return arrlist.get(0);

	}
	
	/*
	 * Delete by ID
	 */
	@RequestMapping("/Bapp/delete/{id}")
	public String delete(@PathVariable String id) {
		bappServices.delete(Long.valueOf(id));
		return "delete successful";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "Bapp/add")
	public void addUser(@RequestBody Bapp bapp)
	{
		bappServices.saveThis(bapp);
	}
	
	/*
	 * Search by various parameters
	 */
	@RequestMapping(method = RequestMethod.GET, value = "Bapp/search")
	public List<Bapp> getBapp(@RequestParam Map<String, String> customQuery) {
		return bappServices.constructQuery(customQuery).getResultList();
	}

	
	/*
	 * Update propertyid
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/Bapp/update/propertyid")
	public ResponseEntity<Object> updateBappPropertyid(@RequestBody Bapp bapp) {
		Optional<Bapp> BuyerApplicationOptional = bappRepository.findById(bapp.getBappid());
		if (!BuyerApplicationOptional.isPresent())
			return ResponseEntity.notFound().build();
		
		bapp.setPropertyid(bapp.getPropertyid());
		bappRepository.save(bapp);
		return ResponseEntity.noContent().build();
	}
	
	/*
	 * Update buyerapplicantid
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/Bapp/update/buyerapplicantid")
	public ResponseEntity<Object> updateBappBuyerapplicantid(@RequestBody Bapp bapp) {
		Optional<Bapp> BuyerApplicationOptional = bappRepository.findById(bapp.getBappid());
		if (!BuyerApplicationOptional.isPresent())
			return ResponseEntity.notFound().build();
		
		bapp.setBuyerapplicantid(bapp.getBuyerapplicantid());
		bappRepository.save(bapp);
		return ResponseEntity.noContent().build();
	}
	
	/*
	 * Update bappstatus
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/Bapp/update/bappstatus")
	public ResponseEntity<Object> updateBappBappstatus(@RequestBody Bapp bapp) {
		Optional<Bapp> BuyerApplicationOptional = bappRepository.findById(bapp.getBappid());
		if (!BuyerApplicationOptional.isPresent())
			return ResponseEntity.notFound().build();
		
		bapp.setBappstatus(bapp.getBappstatus());
		bappRepository.save(bapp);
		return ResponseEntity.noContent().build();
	}
	
	/*
	 * Update supportingdocumentslink
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/Bapp/update/supportingdocumentslink")
	public ResponseEntity<Object> updateBappSupportingdocumentslink(@RequestBody Bapp bapp) {
		Optional<Bapp> BuyerApplicationOptional = bappRepository.findById(bapp.getBappid());
		if (!BuyerApplicationOptional.isPresent())
			return ResponseEntity.notFound().build();
		
		bapp.setSupportingdocumentslink(bapp.getSupportingdocumentslink());
		bappRepository.save(bapp);
		return ResponseEntity.noContent().build();
	}

	/*
	 * Update offerprice
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/Bapp/update/offerprice")
	public ResponseEntity<Object> updateBappOfferprice(@RequestBody Bapp bapp) {
		Optional<Bapp> BuyerApplicationOptional = bappRepository.findById(bapp.getBappid());
		if (!BuyerApplicationOptional.isPresent())
			return ResponseEntity.notFound().build();
		
		bapp.setOfferprice(bapp.getOfferprice());
		bappRepository.save(bapp);
		return ResponseEntity.noContent().build();
	}
}
