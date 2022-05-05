package com.algamoney.api.categoria.dto;

import com.algamoney.api.entities.Categoria;

public class CategoriaDTO {

	private Long codigo;
	private String nome;

	public CategoriaDTO() {
	}

	public CategoriaDTO(Long codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public CategoriaDTO(Categoria categoria) {
		this.codigo = categoria.getCodigo();
		this.nome = categoria.getNome();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
