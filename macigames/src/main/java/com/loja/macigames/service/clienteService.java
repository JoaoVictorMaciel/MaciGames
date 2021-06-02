package com.loja.macigames.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja.macigames.model.clienteModel;
import com.loja.macigames.repository.clienteRepository;

@Service
public class clienteService {
	
	private @Autowired clienteRepository repository;
	
	public Optional<Object> cadastrarCliente(clienteModel novoCliente){
		Optional<Object> usuarioExistente = repository.findByNome(clienteModel.getUsuario());
		if(usuarioExistente.isPresent()) {
			return Optional.empty();
		}
		else {
			return Optional.ofNullable(repository.save(novoCliente));
		}
	}
}

