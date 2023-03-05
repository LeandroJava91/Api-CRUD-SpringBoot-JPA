package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UsuarioModel;
import com.example.demo.services.UsuarioService;

@RestController
@RequestMapping("/home")
public class Controller {
	
	@Autowired
	private UsuarioService usu;
	
	@PostMapping("/usuarios")
	public UsuarioModel save(@RequestBody UsuarioModel usuarioModel) {
		return usu.save(usuarioModel);
	}
	
	@GetMapping("/usuarios")
		public List<UsuarioModel>usuarios(){
		return usu.findAll();
	}
	
	@GetMapping("/usuarios/{id}")
	public UsuarioModel mostrar(@PathVariable Long id){
	return usu.findById(id);
}
	
	@PutMapping("/usuarios/{id}")
	public UsuarioModel actualizar(@RequestBody UsuarioModel usuarioModel,@PathVariable Long id ) {
		UsuarioModel usuMo= usu.findById(id);
		usuMo.setNombre(usuarioModel.getNombre());
		usuMo.setEmail(usuarioModel.getEmail());
		usuMo.setPrioridad(usuarioModel.getPrioridad());
		return usu.save(usuMo);
	}
	
   
	@DeleteMapping("/usuarios/{id}")
	public void eliminar(@PathVariable Long id) {
		usu.delete(id);
	}
}
