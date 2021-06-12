package com.example.tech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class RoleController {
	@Autowired
	private RoleService roleService;

	/*
	 * public RoleController(RoleService roleService) {
	 * 
	 * this.roleService = roleService;
	 * 
	 * }
	 */
	@PostMapping("/role/create")

	public ResponseEntity<Object> createRole(@RequestBody Role role) {

		return roleService.addRole(role);

	}

	@DeleteMapping("/role/delete/{id}")

	public ResponseEntity<Object> deleteRole(@PathVariable Long id) {

		return roleService.deleteRole(id);

	}
	@GetMapping("/role/get/{id}")

	public ResponseEntity<Object> getRole(@PathVariable Long id) {

		return roleService.getRole(id);

	}
}
