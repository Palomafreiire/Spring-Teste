package com.generation.lojagamesteste.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.lojagamesteste.model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
	
	public List<ProdutoModel> findAllByNomeContainingIgnoreCase (@Param ("nome") String nome);
	
	public List<ProdutoModel> findAllByPrecoBetween (@Param ("inicio") BigDecimal inicio, @Param ("fim") BigDecimal fim);
	

}
