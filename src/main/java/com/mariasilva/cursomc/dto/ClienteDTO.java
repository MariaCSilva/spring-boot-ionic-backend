package com.mariasilva.cursomc.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.mariasilva.cursomc.domain.Cliente;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "Preenchimento Obrigatório")
	@Length(min=5,max=120,message = "O tamanho entre 5 e 120 caracters")
	private String nome;
	@NotEmpty(message = "Preenchimento Obrigatório")
	@Email(message = "Email Inválido")
	private String email;
	public ClienteDTO() {
		
	}
	public ClienteDTO(Cliente obj) {
		
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
 
	
	
}
