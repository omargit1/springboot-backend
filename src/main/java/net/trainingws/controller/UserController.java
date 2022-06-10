package net.trainingws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.trainingws.model.Booking;
import net.trainingws.repository.UserRepository;
 
@RestController
@RequestMapping("api/bookings")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("")
	public List<Booking> getUsers() {
		return this.userRepository.findAll();
	}
	
	@PostMapping("add")
	public Booking addUser(@RequestBody Booking user) {
		return this.userRepository.save(user);
	}
	
	@PutMapping("{id}")
	public Booking addUser(@PathVariable Long id, @RequestBody Booking data) {
		 Booking e = this.userRepository.getById(id);
		 
		 e.setFirstName(data.getFirstName());
		 e.setLastName(data.getLastName());
		 e.setEmail(data.getEmail());
		 e.setDateIn(data.getDateIn());
		 e.setDateOut(data.getDateOut());
		 e.setTypeBooking(data.getTypeBooking());
		 e.setAmount(data.getAmount());
		 e = userRepository.save(e);
		  
		 return e; 
	}
	
	@DeleteMapping("{id}")
	public void deleteUser(@PathVariable Long id) {
		this.userRepository.deleteById(id);
	}
}
