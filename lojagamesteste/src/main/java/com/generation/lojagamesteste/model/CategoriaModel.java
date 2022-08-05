package com.generation.lojagamesteste.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_categoria")
public class CategoriaModel {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@NotBlank
	@Size (min=3, max=100, message= "insira pelo menos um nome para sua categoria")
	private String categoria;
	
	@OneToMany (mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties ("categoria")
	private List<ProdutoModel> produto;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	

}
