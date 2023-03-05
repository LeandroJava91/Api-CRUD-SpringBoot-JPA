package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.UsuarioModel;
import com.example.demo.repository.UsuarioRepository;

@Service 
public class serviceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository repo;

	@Override
	@Transactional(readOnly=false)
	public UsuarioModel save(UsuarioModel usuario) {
	
		return repo.save(usuario);
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(Long id) {
		
		repo.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public UsuarioModel findById(Long id) {
	
		return repo.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public List<UsuarioModel> findAll() {
		
		return  repo.findAll();
	}

}
