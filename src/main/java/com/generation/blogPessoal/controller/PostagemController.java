package com.generation.blogPessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogPessoal.model.Postagem;
import com.generation.blogPessoal.repository.PostagemRepository;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins="*", allowedHeaders="*") 
// o cross origin informa qual origem tem permissão para acesar essas aplicação
// e o * é como o . do git e o proprio * do sql, q significa 'all'

public class PostagemController {
	
	// injeção de dependencia
	// isso vai deixar as dependencias automaticas 
	@Autowired
	private PostagemRepository postagemRepository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> getAll(){
		
		// respostas no fromato http
		return ResponseEntity.ok(postagemRepository.findAll());
		
		// metodo find all =
		// select * from tabela
	}
	
	@GetMapping("/exemplo")
	public ResponseEntity<String> exemplo(){
		String ola = "Ola mundo";
		return ResponseEntity.ok(ola);
//	    return ResponseEntity.badRequest().build();
//	    return ResponseEntity.noContent().build();
	}

}
