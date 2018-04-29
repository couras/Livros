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
import br.biblioteca.livros.repository.AutorRepository;
import br.biblioteca.livros.services.LivroService;


@Controller
@RequestMapping(LivroController.PATH_LIVRO)
public class LivroController {

	public static final String  PATH_LIVRO = "/livro";
	public static final String PATH_LIVRO_LIST = "/livros";
	
	@Autowired
	LivroService livroService;
	
	@Autowired
	private AutorRepository autorRepository;

	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
	}

	@RequestMapping(PATH_LIVRO_LIST)
	public ModelAndView livros() {
		List<Livro> listaLivros = livroService.listaLivros();
		return new ModelAndView("livros/livros", "livros", listaLivros);
	}

	@GetMapping("/novo")
	public ModelAndView  createForm(@ModelAttribute Livro livro) {
		
		ModelAndView modelAndView = new ModelAndView("livros/form");
		
		Iterable<Autor> autores = autorRepository.findAll();
		modelAndView.addObject("autores", autores);
		
		return modelAndView;
	} 
	
	@PostMapping(value="/gravar")
	public ModelAndView create(Livro livro) {	
		livroService.salvar(livro);
		return new ModelAndView("redirect:/livro/livros");

		/*List<Livro> listaLivros = livroService.listaLivros();
		return new ModelAndView("livros/livros", "livros", listaLivros);*/
	}

}
