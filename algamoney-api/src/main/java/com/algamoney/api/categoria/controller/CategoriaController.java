package com.algamoney.api.categoria.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.algamoney.api.categoria.dto.CategoriaDTO;
import com.algamoney.api.categoria.service.CategoriaService;
import com.algamoney.api.exception.DefaultException;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/buscar")
	public ResponseEntity<List<CategoriaDTO>> buscarTodas() {
		List<CategoriaDTO> categoriasDTO = categoriaService.findAll();
		return ResponseEntity.ok(categoriasDTO);
	}

	@GetMapping("/buscar/{codigo}")
	public ResponseEntity<CategoriaDTO> buscaPorId(@PathVariable Long codigo) throws DefaultException {
		CategoriaDTO categoriaDTO = categoriaService.buscaPorId(codigo);
		return ResponseEntity.ok().body(categoriaDTO);

	}

	@PostMapping
	public ResponseEntity<CategoriaDTO> save(@RequestBody CategoriaDTO categoriaDTO,
			UriComponentsBuilder uriComponentsBuilder) {
		URI uri = uriComponentsBuilder.path("/categorias/{codigo}").buildAndExpand(categoriaDTO.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(categoriaService.save(categoriaDTO));

	}

}
