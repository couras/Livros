package br.biblioteca.livros.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Livro {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	private int quantidadePaginas;

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

	public int getQuantidadePaginas() {
		return quantidadePaginas;
	}

	public void setQuantidadePaginas(int quantidadePaginas) {
		this.quantidadePaginas = quantidadePaginas;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", nome=" + nome + ", quantidadePaginas=" + quantidadePaginas + "]";
	}

}