package br.biblioteca.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.biblioteca.livros.beans.Usuario;
import java.lang.String;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	List<Usuario> findByUserName(String username);
}
