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
import org.springframework.web.bind.annotation.RestController;
import com.sjsu.cmpe202.property.repositories.UserRepository;
import com.sjsu.cmpe202.search.retail.listing.model.User;
import com.sjsu.cmpe202.search.retail.listing.services.UserServices;

/*
 * Author: Atanu Ghosh
 */

@Repository
@RestController
public class UserController {
	private UserServices userServices;
	@Autowired
	EntityManager em;

	@Autowired
	UserRepository userRepository;

	@Autowired
	public void setUserService(UserServices userService) {
		this.userServices = userService;
	}

	/*
	 * Shows all users
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/user/list")
	public List<User> listUsers(Model model){

		ArrayList<User> listOfUser = new ArrayList<User>();

		model.addAttribute("user", userServices.listAll());

		Map<String, Object> modelMap = model.asMap();
		listOfUser  = (ArrayList<User>) modelMap.get("user");
		return listOfUser;
	}

	/*
	 * Shows property by userID
	 */
	@RequestMapping("user/show/{id}")
	public User getUser(@PathVariable String id, Model model){
		model.addAttribute("user", userServices.getById(Long.valueOf(id)));
		ArrayList<User> listOfUser = new ArrayList<User>();        
		Map<String, Object> modelMap = model.asMap();
		listOfUser=(ArrayList<User>) modelMap.get("user");
		return listOfUser.get(0);
	}


	/*
	 * Add new users to the table
	 */
	@RequestMapping(method = RequestMethod.POST, value = "user/add")
	public void addUser(@RequestBody User user)
	{
		userServices.saveUser(user);
	}


	/*
	 * Update user status from "Pending" to Approved/Reject
	 */
	@RequestMapping(method = RequestMethod.PUT, value="/user/update")
	public ResponseEntity<Object> updateUser(@RequestBody User user)
	{
		Optional<User> userOptional = userRepository.findById(user.getUserid());
		if (!userOptional.isPresent())
			return ResponseEntity.notFound().build();
		user.setStatus(user.getStatus());
		userRepository.save(user);
		return ResponseEntity.noContent().build();

	}

	/*
	 * Delete property by ID
	 */
	@RequestMapping("/user/delete/{id}")
	public String delete(@PathVariable String id){
		userServices.delete(Long.valueOf(id));
		return "delete successful";
	}

}
