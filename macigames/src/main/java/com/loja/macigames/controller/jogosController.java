package com.loja.macigames.controller;

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


import com.loja.macigames.model.jogos;
import com.loja.macigames.repository.jogosRepository;

@RestController
@RequestMapping("/jogos")
@CrossOrigin("*")
public class jogosController {

	
	@Autowired
	private jogosRepository repository;
	
	@GetMapping
	public ResponseEntity<List<jogos>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<jogos> findById(@PathVariable Long id) {
		Optional<jogos> opt = repository.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(opt.get());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<jogos>> GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<jogos> post(@RequestBody jogos jogos){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(jogos));
	}
	
	@PutMapping
	public ResponseEntity<jogos> put(@RequestBody jogos jogos){
		return ResponseEntity.status(200).body(repository.save(jogos));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
