package com.example.tech;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	private RoleRepository roleRepository;
	
	private UserRepository userRepository;

	public RoleService(RoleRepository roleRepository, UserRepository userRepository) {

		this.roleRepository = roleRepository;

		this.userRepository = userRepository;

	}

	/**
	 * 
	 * Create a new role along with users
	 * 
	 */

	@Transactional

	public ResponseEntity<Object> addRole(Role role) {

		Role newRole = new Role();

		newRole.setName(role.getName());

		newRole.setDescription(role.getDescription());

		newRole.setUsers(role.getUsers());

		Role savedRole = roleRepository.save(newRole);

		if (roleRepository.findById(savedRole.getId()).isPresent()) {

			return ResponseEntity.accepted().body("Successfully Created Role and Users");

		} else

			return ResponseEntity.unprocessableEntity().body("Failed to Create specified Role");

	}

	/**
	 * 42 Delete a specified role given the id
	 * 
	 */

	public ResponseEntity<Object> deleteRole(Long id) {

		if (roleRepository.findById(id).isPresent()) {

			roleRepository.deleteById(id);

			if (roleRepository.findById(id).isPresent()) {

				return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");

			} else
				return ResponseEntity.ok().body("Successfully deleted specified record");

		} else
			return ResponseEntity.unprocessableEntity().body("No Records Found");

	}
	public ResponseEntity<Object> getRole(Long id) {

		if (userRepository.findById(id).isPresent()) {

			User user = userRepository.getById(id);

			//if (userRepository.findById(id).isPresent()) {

				return ResponseEntity.ok().body(user);

			//} 
		} else
			return ResponseEntity.unprocessableEntity().body("No Records Found");
		//return null;

	}

}
