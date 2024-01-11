package com.generation.blogPessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// a classe model tem a função de modelar o banco de dados
// ou seja, modelar as tabelas e os atributos

// criar uma tabela tb_postagens
@Entity
@Table(name="tb_postagens")
public class Postagem {
	
	// criar o primeiro atributo ID
	
	@Id // torna o atributo uma chave primaria
	@GeneratedValue(strategy=GenerationType.IDENTITY) // adiciona o id como auto incremento
	private Long id;
	
	// criar o segundo atributo
	
	@Size(min=5, max=100, message="O titulo deve ter no min 5 e no max 100")
	@NotBlank(message="O titulo é obrigatorio")
	private String titulo;
	
	@Size(min=1, max=1000, message="O texto deve ter no min 1 e no max 1000")
	@NotBlank(message="O texto é obrigatorio")
	private String texto;
	
	@UpdateTimestamp // atualiza o date time para o tempo da maquina
	private LocalDateTime data;

	// ----------------------------------------------------------------------
	// GETTERS e SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

}
