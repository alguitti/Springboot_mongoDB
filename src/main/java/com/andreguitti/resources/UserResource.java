package com.andreguitti.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andreguitti.domain.Post;
import com.andreguitti.domain.User;
import com.andreguitti.dto.UserDTO;
import com.andreguitti.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {

		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);

	}

	// @Pathvariable diz que o Id da URL casa com o atributo recebido
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		UserDTO uDTO = new UserDTO(service.findById(id));
		return ResponseEntity.ok().body(uDTO);
	}

	// @RequestBody atrela o atributo recebido com o corpo da mensagem Json
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> insert(@RequestBody UserDTO objDto) {
		User user = service.insert(objDto.fromDTO());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build(); // código 204 nada retorna
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@RequestBody UserDTO uDTO, @PathVariable String id) {
		User user = uDTO.fromDTO();
		user.setId(id);
		user = service.update(user);
		return ResponseEntity.ok().body(user);

	}

	@RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
		User user = service.findById(id);
		return ResponseEntity.ok().body(user.getPosts());
	}

}
