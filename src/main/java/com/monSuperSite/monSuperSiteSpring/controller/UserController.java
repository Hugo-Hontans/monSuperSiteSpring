package com.monSuperSite.monSuperSiteSpring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monSuperSite.monSuperSiteSpring.repo.UserRepository;
import com.monSuperSite.monSuperSiteSpring.model.User;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserRepository repository;
	
	@GetMapping("/users")
	public List<User> getAllCustomers() {

		List<User> customers = new ArrayList<>();
		repository.findAll().forEach(customers::add);

		return customers;
	}
	
	@PostMapping(value = "/users/create")
	public User postCustomer(@RequestBody User user) {

		User _customer = repository.save(new User(user.getNom(), user.getPrenom(), user.geteMail(), user.getMotDePasse()));
		return _customer;
	}
	
	@CrossOrigin
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateCustomer(@PathVariable("id") long id, @RequestBody User customer) {

		Optional<User> userData = repository.findById(id);

		if (userData.isPresent()) {
			User _customer = userData.get();
			if (_customer.getMotDePasse().equals(customer.getMotDePasseActuel())) {
				String nom = this.isNull(customer.getNom()) ? _customer.getNom() : customer.getNom();
				String prenom = this.isNull(customer.getPrenom()) ? _customer.getPrenom() : customer.getPrenom();
				String email = this.isNull(customer.geteMail()) ? _customer.geteMail() : customer.geteMail();
				String motDePasse = this.isNull(customer.getMotDePasse()) ? _customer.getMotDePasse() : customer.getMotDePasse();
				
				_customer.setNom(nom);
				_customer.setPrenom(prenom);
				_customer.seteMail(email);
				_customer.setMotDePasse(motDePasse);
				
				return new ResponseEntity<>(repository.save(_customer), HttpStatus.OK);
			}
			else { return new ResponseEntity<>(HttpStatus.FORBIDDEN); }
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id) {

		repository.deleteById(id);

		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}

	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean isNull(String valeur) {
		return valeur == null || valeur == "";
	}
	

}
