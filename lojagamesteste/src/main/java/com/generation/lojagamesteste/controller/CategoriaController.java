package com.generation.lojagamesteste.controller;

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

import com.generation.lojagamesteste.model.CategoriaModel;
import com.generation.lojagamesteste.repository.CategoriaRepository;

@RestController
@RequestMapping ("/categoriaGame")
@CrossOrigin (origins=("*"), allowedHeaders = ("*"))
public class CategoriaController {
	
	@Autowired CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<CategoriaModel> getById (@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/categoria/{categoria}")
	public ResponseEntity<List<CategoriaModel>> getByCategoria (@PathVariable String categoria){
		return ResponseEntity.ok(repository.findAllByCategoriaContainingIgnoreCase(categoria));
	}

	@PostMapping
	public ResponseEntity<CategoriaModel> post (@Valid @RequestBody CategoriaModel categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<CategoriaModel> put (@Valid @RequestBody CategoriaModel categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
	
	@DeleteMapping ("{id}")
	public void deleteCategoria (@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	
	
	
	
	
	
}
