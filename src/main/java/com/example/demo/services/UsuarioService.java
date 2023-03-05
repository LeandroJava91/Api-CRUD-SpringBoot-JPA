package com.example.demo.services;

import java.util.List;

import com.example.demo.model.UsuarioModel;

public interface UsuarioService {
	
	public UsuarioModel save(UsuarioModel usuario);
	public void delete(Long id);
	public UsuarioModel findById(Long id);
	public List<UsuarioModel>findAll();

}
