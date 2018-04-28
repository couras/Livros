package br.biblioteca.livros.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.beans.Livro;
import br.biblioteca.livros.services.LivroService;


@Controller
@RequestMapping(LivroController.PATH_LIVRO)
public class LivroController {

	public static final String  PATH_LIVRO = "/livros";
	public static final String PATH_LIVRO_LIST = "/livros";
	
	@Autowired
	LivroService livroService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
	}

	@RequestMapping(PATH_LIVRO_LIST)
	public ModelAndView livros() {
		String titulo = "Lista de Livros";
		List<Livro> listaLivros = livroService.listaLivros();
		return new ModelAndView("livros/livros", "livros", listaLivros);
	}

}
