package com.loja.macigames.controller;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import com.loja.macigames.model.clienteModel;
import com.loja.macigames.repository.clienteRepository;
import com.loja.macigames.service.clienteService;


@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class clienteController {
	
	@Autowired
	private clienteService services;
	
	@Autowired
	private clienteRepository repository;
	
	@GetMapping
	public ResponseEntity<List<clienteModel>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<clienteModel> findById(@PathVariable Long id) {
		Optional<clienteModel> opt = repository.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(opt.get());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<clienteModel>> GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<clienteModel> post(@RequestBody clienteModel cliente){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cliente));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Object> salvarUsuario(@Valid @RequestBody clienteModel novoUsuario) {
		return services.cadastrarCliente(novoUsuario)
				.map(usuarioExistente -> ResponseEntity.status(201).body(usuarioExistente))
				.orElse(ResponseEntity.status(400).body("Usuário já cadastrado."));
	}
	
	@PutMapping
	public ResponseEntity<clienteModel> put(@RequestBody clienteModel cliente){
		return ResponseEntity.status(200).body(repository.save(cliente));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	
	

	
}
