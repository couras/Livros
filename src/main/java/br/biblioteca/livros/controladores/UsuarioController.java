package br.biblioteca.livros.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.beans.Usuario;
import br.biblioteca.livros.services.UsuarioService;

@Controller
@RequestMapping(UsuarioController.PATH_USUARIO)
public class UsuarioController {
	public static final String  PATH_USUARIO = "/usuario";
	public static final String PATH_USUARIO_LIST = "/usuarios";
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
	}

	@RequestMapping(PATH_USUARIO_LIST)
	public ModelAndView usuarios() {
		List<Usuario> listaUsuarios = usuarioService.listaUsuarios();
		return new ModelAndView("usuario/usuarios", "usuarios", listaUsuarios);
	}
}
