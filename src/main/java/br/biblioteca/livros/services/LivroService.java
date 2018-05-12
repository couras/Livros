package br.biblioteca.livros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.beans.Autor;
import br.biblioteca.livros.beans.Livro;
import br.biblioteca.livros.repository.AutorRepository;
import br.biblioteca.livros.repository.LivroRepository;

@Service
public class LivroService {
	@Autowired
	LivroRepository livroRepository;
	
	@Autowired
	AutorRepository autorRepository;
	
	public List<Livro> listaLivros() {
		return livroRepository.findAll();
	}
	
	public Livro salvar(Livro livro) {
		return livroRepository.save(livro);
	}
	
	public Livro findById(long idLivro) {
		return this.livroRepository.findOne(idLivro);
	}
	
	public List<Autor> listAutores() {
		return autorRepository.findAll();
	}

	public Boolean delete(Livro livro) {
		
		try {
			livroRepository.delete(livro);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
}
