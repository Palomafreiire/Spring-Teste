package com.generation.farmaciateste.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.farmaciateste.model.CategoriaModel;
import com.generation.farmaciateste.repository.CategoriaRepository;

@RestController
@RequestMapping ("/Categoria")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> Getall(){
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<CategoriaModel> getById (@PathVariable Long id){
		return categoriaRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping ("/tipo/{tipo}")
	public ResponseEntity<List<CategoriaModel>> getByTipo (@PathVariable String tipo){
		return ResponseEntity.ok(categoriaRepository.findAllBytipoContainingIgnoreCase(tipo));
	}
	
	@PostMapping
	public ResponseEntity<CategoriaModel> post (@Valid @RequestBody CategoriaModel categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<CategoriaModel> put (@Valid @RequestBody CategoriaModel categoria){
		return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoria));
	}
	
	@DeleteMapping ("/{id}")
	public void deleteTipo (@PathVariable Long id) {
		categoriaRepository.deleteById(id);
	}
	
	
	
	
	
}
