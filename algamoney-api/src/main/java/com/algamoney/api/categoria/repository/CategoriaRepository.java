package com.algamoney.api.categoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algamoney.api.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
