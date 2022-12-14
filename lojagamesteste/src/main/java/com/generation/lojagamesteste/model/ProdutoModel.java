package com.generation.lojagamesteste.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_produto")
public class ProdutoModel {
	
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotBlank 
		@Size (min=2, max=100, message = "Insira pelo menos um nome para seu jogo!")
		private String nome;
		
		@NotBlank
		@Size (min=5, max=1000, message = "Insira pelo menos do que se trata o jogo!")
		private String descricao;
		
		
		@NotNull
		private BigDecimal preco;
		
		private int quantidade;
		
		@ManyToOne
		@JsonIgnoreProperties ("produto")
		private CategoriaModel categoria;
		
		@ManyToOne
		@JsonIgnoreProperties ("produto")
		private UsuarioModel usuario;
		

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public BigDecimal getPreco() {
			return preco;
		}

		public void setPreco(BigDecimal preco) {
			this.preco = preco;
		}

		public int getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}

		public CategoriaModel getCategoria() {
			return categoria;
		}

		public void setCategoria(CategoriaModel categoria) {
			this.categoria = categoria;
		}

		public UsuarioModel getUsuario() {
			return usuario;
		}

		public void setUsuario(UsuarioModel usuario) {
			this.usuario = usuario;
		}
		
		
		
		

}
