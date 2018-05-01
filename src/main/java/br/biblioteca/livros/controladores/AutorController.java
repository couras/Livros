package br.biblioteca.livros.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.beans.Autor;
import br.biblioteca.livros.beans.Livro;
import br.biblioteca.livros.services.AutorService;

@Controller
@RequestMapping(AutorController.PATH_AUTOR)
public class AutorController {

	public static final String  PATH_AUTOR = "/autor";
	public static final String PATH_AUTOR_LIST = "/autores";
	
	@Autowired
	AutorService autorService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
	}

	@RequestMapping(PATH_AUTOR_LIST)
	public ModelAndView autores() {
		List<Autor> listaAutores = autorService.listaAutores();
		return new ModelAndView("autor/autores", "autores", listaAutores);
	}
	
	@GetMapping("/novo")
	public ModelAndView  createForm(@ModelAttribute Autor autor) {
		ModelAndView modelAndView = new ModelAndView("autor/formAutor");
		return modelAndView;
	} 
	
	@PostMapping(value="/gravar")
	public ModelAndView create(Autor autor) {	
		autorService.salvar(autor);
		return new ModelAndView("redirect:/autor/autores");
	}
}
