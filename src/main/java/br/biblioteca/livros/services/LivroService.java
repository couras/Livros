package br.biblioteca.livros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.beans.Livro;
import br.biblioteca.livros.repository.LivroRepository;

@Service
public class LivroService {
	@Autowired
	LivroRepository livrorepository;
	
	public List<Livro> listaLivros() {
		return livrorepository.findAll();
	}
}
