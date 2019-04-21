package com.mariasilva.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mariasilva.cursomc.domain.Cliente;
import com.mariasilva.cursomc.repositories.ClienteRepository;
import com.mariasilva.cursomc.services.Exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Cliente obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+id +", Tipo "+Cliente.class.getName());
		}
		return obj;
	}
}
