package com.loja.macigames.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.loja.macigames.model.clienteModel;

@Repository
public interface clienteRepository extends JpaRepository<clienteModel, Long>{
	public List<clienteModel> findAllByNomeContainingIgnoreCase(String nome);
	public Optional<Object> findByNome(String nome);
}

