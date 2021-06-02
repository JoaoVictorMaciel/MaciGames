package com.loja.macigames.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "Cliente")
public class clienteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size (min = 5, max = 45, message = "Erro tamanho nome usuário")
	private String nome;
	
	@NotNull
	@Size(min = 5, max = 50, message = "Entre 5 e 50 caracteres")
	private static String usuario;
	
	@Size ()
	private String email;
	
	@Size (min = 8, message = "Erro tamanho senha usuário")
	private String senha;
	
	@NotNull
	private String endereco;
	
	@Size(min = 8, max= 8, message = "Erro tamanho cep usuário")
	private String cep;
	
	@OneToMany(mappedBy = "comprador", cascade = CascadeType.ALL)
	
	//Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	//Nome
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

	public static String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	//Email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//Senha
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	//Endereço
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	//CEP
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
