package com.mariasilva.cursomc.services;

import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mariasilva.cursomc.domain.Categoria;
import com.mariasilva.cursomc.domain.Cliente;
import com.mariasilva.cursomc.dto.CategoriaDTO;
import com.mariasilva.cursomc.repositories.CategoriaRepository;
import com.mariasilva.cursomc.services.Exceptions.DataIntegrityException;
import com.mariasilva.cursomc.services.Exceptions.ObjectNotFoundException;

import ch.qos.logback.classic.pattern.LineSeparatorConverter;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Categoria obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+id +", Tipo "+Categoria.class.getName());
		}
		return obj;
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		Categoria newObj = find(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Nao é Possível excluir uma categoria que possui produtos"); 
		}		
	}
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}
	
	public Page<Categoria> findPage(Integer page,Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = new PageRequest(page, linesPerPage,Direction.valueOf(direction),  orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Categoria fromDTO(CategoriaDTO objetoDto) {
		return new Categoria(objetoDto.getId(), objetoDto.getNome());
				
	}
	
	private void updateData(Categoria newObjt, Categoria obj) {
		newObjt.setNome(obj.getNome());
	}
}
