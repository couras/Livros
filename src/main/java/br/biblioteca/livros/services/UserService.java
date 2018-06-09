package br.biblioteca.livros.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.biblioteca.livros.beans.Usuario;

@Service
public interface UserService {
	
	void save(Usuario user);

	Usuario findByUsername(String username);

	List<Usuario> findAll();
}