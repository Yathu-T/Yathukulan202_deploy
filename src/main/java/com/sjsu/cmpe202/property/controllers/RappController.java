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

import com.sjsu.cmpe202.property.repositories.RappRepository;
import com.sjsu.cmpe202.search.retail.listing.model.Rapp;
import com.sjsu.cmpe202.search.retail.listing.services.RappServices;
/*
 * Yathukulan
 */
@Repository
@RestController
public class RappController {
	private RappServices rappServices;
	@Autowired
	EntityManager em;

	@Autowired
	RappRepository rappRepository;

	@Autowired
	public void setRappService(RappServices rappServices) {
		this.rappServices = rappServices;
	}

	/*
	 * Shows all users
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/Rapp/list")
	public List<Rapp> listRapp(Model model){

		ArrayList<Rapp> arrlist = new ArrayList<Rapp>();

		model.addAttribute("rapp", rappServices.listAll());

		Map<String, Object> modelMap = model.asMap();
		arrlist  = (ArrayList<Rapp>) modelMap.get("rapp");
		return arrlist;
	}
	
	@RequestMapping("Rapp/show/{id}")
	public Rapp getRapp(@PathVariable String id, Model model) {
		model.addAttribute("rapp", rappServices.getById(Long.valueOf(id)));
		ArrayList<Rapp> arrlist = new ArrayList<Rapp>();
		Map<String, Object> modelMap = model.asMap();
		arrlist = (ArrayList<Rapp>) modelMap.get("rapp");
		return arrlist.get(0);

	}
	
	/*
	 * Delete by ID
	 */
	@RequestMapping("/Rapp/delete/{id}")
	public String delete(@PathVariable String id) {
		rappServices.delete(Long.valueOf(id));
		return "delete successful";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "Rapp/add")
	public void addRapp(@RequestBody Rapp rapp)
	{
		rappServices.saveThis(rapp);
	}
	
	/*
	 * Search by various parameters
	 */
	@RequestMapping(method = RequestMethod.GET, value = "Rapp/search")
	public List<Rapp> getRapp(@RequestParam Map<String, String> customQuery) {
		return rappServices.constructQuery(customQuery).getResultList();
	}
	
	/*
	 * Update propertyid
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/Rapp/update/propertyid")
	public ResponseEntity<Object> updateRappPropertyid(@RequestBody Rapp rapp) {
		Optional<Rapp> myoptional = rappRepository.findById(rapp.getRappid());
		if (!myoptional.isPresent())
			return ResponseEntity.notFound().build();
		
		rapp.setPropertyid(rapp.getPropertyid());
		rappRepository.save(rapp);
		return ResponseEntity.noContent().build();
	}
	
	/*
	 * Update renterapplicantid
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/Rapp/update/renterapplicantid")
	public ResponseEntity<Object> updateRappRenterapplicantid(@RequestBody Rapp rapp) {
		Optional<Rapp> myoptional = rappRepository.findById(rapp.getRappid());
		if (!myoptional.isPresent())
			return ResponseEntity.notFound().build();
		
		rapp.setRenterapplicantid(rapp.getRenterapplicantid());
		rappRepository.save(rapp);
		return ResponseEntity.noContent().build();
	}
	
	/*
	 * Update rappstatus
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/Rapp/update/rappstatus")
	public ResponseEntity<Object> updateRappRappstatus(@RequestBody Rapp rapp) {
		Optional<Rapp> myoptional = rappRepository.findById(rapp.getRappid());
		if (!myoptional.isPresent())
			return ResponseEntity.notFound().build();
		
		rapp.setRappstatus(rapp.getRappstatus());
		rappRepository.save(rapp);
		return ResponseEntity.noContent().build();
	}
	
	/*
	 * Update supportingdocumentslink
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/Rapp/update/supportingdocumentslink")
	public ResponseEntity<Object> updateRappSupportingdocumentslink(@RequestBody Rapp rapp) {
		Optional<Rapp> myoptional = rappRepository.findById(rapp.getRappid());
		if (!myoptional.isPresent())
			return ResponseEntity.notFound().build();
		
		rapp.setSupportingdocumentslink(rapp.getSupportingdocumentslink());
		rappRepository.save(rapp);
		return ResponseEntity.noContent().build();
	}
	
	/*
	 * Update applicantcreditscore
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/Rapp/update/applicantcreditscore")
	public ResponseEntity<Object> updateRappApplicantcreditscore(@RequestBody Rapp rapp) {
		Optional<Rapp> myoptional = rappRepository.findById(rapp.getRappid());
		if (!myoptional.isPresent())
			return ResponseEntity.notFound().build();
		
		rapp.setApplicantcreditscore(rapp.getApplicantcreditscore());
		rappRepository.save(rapp);
		return ResponseEntity.noContent().build();
	}
	
	/*
	 * Update applicantemployment
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/Rapp/update/applicantemployment")
	public ResponseEntity<Object> updateRappApplicantemployment(@RequestBody Rapp rapp) {
		Optional<Rapp> myoptional = rappRepository.findById(rapp.getRappid());
		if (!myoptional.isPresent())
			return ResponseEntity.notFound().build();
		
		rapp.setApplicantemployment(rapp.getApplicantemployment());
		rappRepository.save(rapp);
		return ResponseEntity.noContent().build();
	}
	
}
