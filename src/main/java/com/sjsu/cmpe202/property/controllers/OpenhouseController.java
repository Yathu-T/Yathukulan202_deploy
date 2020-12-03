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

import com.sjsu.cmpe202.property.repositories.OpenhouseRepository;
import com.sjsu.cmpe202.search.retail.listing.model.Openhouse;
import com.sjsu.cmpe202.search.retail.listing.services.OpenhouseServices;
/*
 * Yathukulan
 */
@Repository
@RestController
public class OpenhouseController {
	private OpenhouseServices openhouseServices;
	@Autowired
	EntityManager em;

	@Autowired
	OpenhouseRepository openhouseRepository;

	@Autowired
	public void setOpenhouseService(OpenhouseServices openhouseServices) {
		this.openhouseServices = openhouseServices;
	}

	/*
	 * Shows all users
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/Openhouse/list")
	public List<Openhouse> listOpenhouse(Model model){

		ArrayList<Openhouse> arrlist = new ArrayList<Openhouse>();

		model.addAttribute("openhouse", openhouseServices.listAll());

		Map<String, Object> modelMap = model.asMap();
		arrlist  = (ArrayList<Openhouse>) modelMap.get("openhouse");
		return arrlist;
	}
	
	@RequestMapping("Openhouse/show/{id}")
	public Openhouse getOpenhouse(@PathVariable String id, Model model) {
		model.addAttribute("openhouse", openhouseServices.getById(Long.valueOf(id)));
		ArrayList<Openhouse> arrlist = new ArrayList<Openhouse>();
		Map<String, Object> modelMap = model.asMap();
		arrlist = (ArrayList<Openhouse>) modelMap.get("openhouse");
		return arrlist.get(0);

	}
	
	/*
	 * Delete by ID
	 */
	@RequestMapping("/Openhouse/delete/{id}")
	public String delete(@PathVariable String id) {
		openhouseServices.delete(Long.valueOf(id));
		return "delete successful";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "Openhouse/add")
	public void addOpenhouse(@RequestBody Openhouse openhouse)
	{
		openhouseServices.saveThis(openhouse);
	}
	
	/*
	 * Search by various parameters
	 */
	@RequestMapping(method = RequestMethod.GET, value = "Openhouse/search")
	public List<Openhouse> getOpenhouse(@RequestParam Map<String, String> customQuery) {
		return openhouseServices.constructQuery(customQuery).getResultList();
	}
	
	/*
	 * Update propertyid
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/Openhouse/update/propertyid")
	public ResponseEntity<Object> updateOpenhousePropertyid(@RequestBody Openhouse openhouse) {
		Optional<Openhouse> myoptional = openhouseRepository.findById(openhouse.getOpenhouseid());
		if (!myoptional.isPresent())
			return ResponseEntity.notFound().build();
		
		openhouse.setPropertyid(openhouse.getPropertyid());
		openhouseRepository.save(openhouse);
		return ResponseEntity.noContent().build();
	}
	
	/*
	 * Update visitorid
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/Openhouse/update/visitorid")
	public ResponseEntity<Object> updateOpenhouseVisitorid(@RequestBody Openhouse openhouse) {
		Optional<Openhouse> myoptional = openhouseRepository.findById(openhouse.getOpenhouseid());
		if (!myoptional.isPresent())
			return ResponseEntity.notFound().build();
		
		openhouse.setVisitorid(openhouse.getVisitorid());
		openhouseRepository.save(openhouse);
		return ResponseEntity.noContent().build();
	}
	
	/*
	 * Update fromdatetime
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/Openhouse/update/fromdatetime")
	public ResponseEntity<Object> updateOpenhouseFromdatetime(@RequestBody Openhouse openhouse) {
		Optional<Openhouse> myoptional = openhouseRepository.findById(openhouse.getOpenhouseid());
		if (!myoptional.isPresent())
			return ResponseEntity.notFound().build();
		
		openhouse.setFromdatetime(openhouse.getFromdatetime());
		openhouseRepository.save(openhouse);
		return ResponseEntity.noContent().build();
	}
	
	/*
	 * Update todatetime
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/Openhouse/update/todatetime")
	public ResponseEntity<Object> updateOpenhouseTodatetime(@RequestBody Openhouse openhouse) {
		Optional<Openhouse> myoptional = openhouseRepository.findById(openhouse.getOpenhouseid());
		if (!myoptional.isPresent())
			return ResponseEntity.notFound().build();
		
		openhouse.setTodatetime(openhouse.getTodatetime());
		openhouseRepository.save(openhouse);
		return ResponseEntity.noContent().build();
	}
	

	
	
}
