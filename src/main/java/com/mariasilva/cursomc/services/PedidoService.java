package com.mariasilva.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mariasilva.cursomc.domain.Pedido;
import com.mariasilva.cursomc.repositories.PedidoRepository;
import com.mariasilva.cursomc.services.Exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Pedido obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+id +", Tipo "+Pedido.class.getName());
		}
		return obj;
	}
}
