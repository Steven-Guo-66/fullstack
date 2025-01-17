package com.iiht.emark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.emark.entity.UserEntity;
import com.iiht.emark.service.UserService;
import com.iiht.emark.vo.UserModel;

@RestController
@RequestMapping("/api/user")
//@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * @return
	 */
	@GetMapping
	public List<UserEntity> findAllUsers(){
		
		return userService.findAllUsers();
	}
	
	@PostMapping
	public ResponseEntity<UserEntity> regist(UserEntity user){
		UserEntity userEntity = userService.registUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userEntity); 
	}
	
	@PutMapping
	public ResponseEntity<UserEntity> update(UserEntity user){
		UserEntity userEntity = userService.updateUser(user);
		return ResponseEntity.ok(userEntity); 
	}
	
	@GetMapping("/active/{id}")
	public ResponseEntity<UserEntity> active(@PathVariable Integer id){
		UserEntity user = userService.activeUser(id);
		return ResponseEntity.ok(user); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		userService.delete(id);
		return ResponseEntity.ok("Delete user successfully.");
	}
}
