package com.loja.macigames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.loja.macigames.model.jogos;

public interface jogosRepository extends JpaRepository<jogos, Long> {
	public List<jogos> findAllByNomeContainingIgnoreCase(String nome);
}
