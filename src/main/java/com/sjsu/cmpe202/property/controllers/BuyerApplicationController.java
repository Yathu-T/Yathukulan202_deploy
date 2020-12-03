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

import com.sjsu.cmpe202.property.repositories.BuyerApplicationRepository;
import com.sjsu.cmpe202.search.retail.listing.model.BuyerApplication;
import com.sjsu.cmpe202.search.retail.listing.services.BuyerApplicationServices;

/*
 * Yathukulan Thayabaran
 */

@Repository
@RestController
public class BuyerApplicationController {
	private BuyerApplicationServices buyerApplicationServices;
	@Autowired
	EntityManager em;

	@Autowired
	BuyerApplicationRepository BuyerApplicationRepository;

	@Autowired
	public void setBuyerApplicationService(BuyerApplicationServices buyerApplicationService) {
		this.buyerApplicationServices = buyerApplicationService;
	}

	/*
	 * Shows all
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/buyerapplication/list")
	public List<BuyerApplication> listBuyerApplications(Model model) {

		ArrayList<BuyerApplication> listOfBuyerApplications = new ArrayList<BuyerApplication>();

		model.addAttribute("buyerapplication", buyerApplicationServices.listAll());

		Map<String, Object> modelMap = model.asMap();
		listOfBuyerApplications = (ArrayList<BuyerApplication>) modelMap.get("buyerapplication");
		return listOfBuyerApplications;
	}

	/*
	 * show by id
	 */
	@RequestMapping("buyerapplication/show/{id}")
	public BuyerApplication getBuyerApplication(@PathVariable String id, Model model) {
		model.addAttribute("buyerapplication", buyerApplicationServices.getById(Long.valueOf(id)));
		ArrayList<BuyerApplication> listOfBuyerApplications = new ArrayList<BuyerApplication>();
		Map<String, Object> modelMap = model.asMap();
		listOfBuyerApplications = (ArrayList<BuyerApplication>) modelMap.get("buyerapplication");
		return listOfBuyerApplications.get(0);

	}

	/*
	 * Search by various parameters
	 */
	@RequestMapping(method = RequestMethod.GET, value = "buyerapplication/search")
	public List<BuyerApplication> getBuyerApplication(@RequestParam Map<String, String> customQuery) {
		return buyerApplicationServices.constructQuery(customQuery).getResultList();
	}

	/*
	 * Adds a new record to the table
	 */
	@RequestMapping(method = RequestMethod.POST, value = "buyerapplication/add")
	public void addBuyerApplication(@RequestBody BuyerApplication buyerapplication) {
		buyerApplicationServices.savethis(buyerapplication);
	}

	/*
	 * Update propertyid
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/buyerapplication/updatepropertyid")
	public ResponseEntity<Object> updateBuyerApplicationPropertyid(@RequestBody BuyerApplication buyerapplication) {
		Optional<BuyerApplication> BuyerApplicationOptional = BuyerApplicationRepository
				.findById(buyerapplication.getBuyerapplicationid());
		if (!BuyerApplicationOptional.isPresent())
			return ResponseEntity.notFound().build();
		buyerapplication.setPropertyid(buyerapplication.getPropertyid());
		BuyerApplicationRepository.save(buyerapplication);
		return ResponseEntity.noContent().build();

	}
	
	/*
	 * Update buyerapplicantid
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/buyerapplication/updatebuyerapplicantid")
	public ResponseEntity<Object> updateBuyerApplicationBuyerApplicantid(@RequestBody BuyerApplication buyerapplication) {
		Optional<BuyerApplication> BuyerApplicationOptional = BuyerApplicationRepository
				.findById(buyerapplication.getBuyerapplicationid());
		if (!BuyerApplicationOptional.isPresent())
			return ResponseEntity.notFound().build();
		buyerapplication.setBuyerapplicantid(buyerapplication.getBuyerapplicantid());
		BuyerApplicationRepository.save(buyerapplication);
		return ResponseEntity.noContent().build();

	}
	
	/*
	 * Update applicationstatus
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/buyerapplication/updateapplicationstatus")
	public ResponseEntity<Object> updateBuyerApplicationBuyerApplicationstatus(@RequestBody BuyerApplication buyerapplication) {
		Optional<BuyerApplication> BuyerApplicationOptional = BuyerApplicationRepository
				.findById(buyerapplication.getBuyerapplicationid());
		if (!BuyerApplicationOptional.isPresent())
			return ResponseEntity.notFound().build();
		buyerapplication.setApplicationstatus(buyerapplication.getApplicationstatus());
		BuyerApplicationRepository.save(buyerapplication);
		return ResponseEntity.noContent().build();

	}
	
	/*
	 * Update supportingdocumentslink
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/buyerapplication/updatesupportingdocumentslink")
	public ResponseEntity<Object> updateBuyerApplicationBuyerSupportingdocumentslink(@RequestBody BuyerApplication buyerapplication) {
		Optional<BuyerApplication> BuyerApplicationOptional = BuyerApplicationRepository
				.findById(buyerapplication.getBuyerapplicationid());
		if (!BuyerApplicationOptional.isPresent())
			return ResponseEntity.notFound().build();
		buyerapplication.setSupportingdocumentslink(buyerapplication.getSupportingdocumentslink());
		BuyerApplicationRepository.save(buyerapplication);
		return ResponseEntity.noContent().build();

	}
	
	/*
	 * Update offerprice
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/buyerapplication/updateofferprice")
	public ResponseEntity<Object> updateBuyerApplicationOfferprice(@RequestBody BuyerApplication buyerapplication) {
		Optional<BuyerApplication> BuyerApplicationOptional = BuyerApplicationRepository
				.findById(buyerapplication.getBuyerapplicationid());
		if (!BuyerApplicationOptional.isPresent())
			return ResponseEntity.notFound().build();
		buyerapplication.setOfferprice(buyerapplication.getOfferprice());
		BuyerApplicationRepository.save(buyerapplication);
		return ResponseEntity.noContent().build();

	}
	

	/*
	 * Delete by ID
	 */
	@RequestMapping("/buyerapplication/delete/{id}")
	public String delete(@PathVariable String id) {
		buyerApplicationServices.delete(Long.valueOf(id));
		return "delete successful";
	}
}
