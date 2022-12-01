package com.backend.pixel.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.pixel.model.Erro;
import com.backend.pixel.model.Success;
import com.backend.pixel.model.User;
import com.backend.pixel.repository.UserRepository;

@RestController
@CrossOrigin
@RequestMapping("api/user")
public class UserRest {

	@Autowired
	private UserRepository repositoryUser;

	// POST
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> postUser(@RequestBody User user, HttpServletRequest request) {
		if (user != null) {
			repositoryUser.save(user);
			Success success = new Success(HttpStatus.OK, "Sucesso ao salvar o usuário");

			return new ResponseEntity<Object>(success, HttpStatus.OK);
		} else {
			Erro erro = new Erro(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao cadastra o usuário", null);

			return new ResponseEntity<Object>(erro, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	// GET
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Iterable<User> getUsers() {
		return repositoryUser.findAll();
	}

	// DELETE
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteUser(@PathVariable("id") Long id, User user, HttpServletRequest request) {
		if (user.getId() == id) {
			repositoryUser.delete(user);
			Success success = new Success(HttpStatus.OK, "Sucesso ao deletar usuário");
			return new ResponseEntity<Object>(success, HttpStatus.OK);
		} else {
			Erro erro = new Erro(HttpStatus.INTERNAL_SERVER_ERROR, "Não foi possivel deletar o usuário, verifique o id",
					null);
			return new ResponseEntity<Object>(erro, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// PUT
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> changeUser(@PathVariable("id") Long id, @RequestBody User user,
			HttpServletRequest request) {
		if (user.getId() != id) {
			Erro erro = new Erro(HttpStatus.INTERNAL_SERVER_ERROR, "Id inválido", null);
			return new ResponseEntity<Object>(erro, HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
			repositoryUser.save(user);
			Success success = new Success(HttpStatus.OK, "Sucesso ao alterar o usuário");
			return new ResponseEntity<Object>(success, HttpStatus.OK);
		}
	}
}
