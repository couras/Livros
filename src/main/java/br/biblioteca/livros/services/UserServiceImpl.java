package br.biblioteca.livros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.beans.Role;
import br.biblioteca.livros.beans.Usuario;
import br.biblioteca.livros.repository.UsuarioRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UsuarioRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(Usuario user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.getRoles().add(new Role("ROLE_BASIC"));
		userRepository.save(user);
	}

	@Override
	public Usuario findByUsername(String username) {
		List<Usuario> list = userRepository.findByUserName(username);

		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	@Override
	public List<Usuario> findAll() {
		return userRepository.findAll();
	}
}