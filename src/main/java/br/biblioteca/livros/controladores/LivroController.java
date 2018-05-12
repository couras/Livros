package br.biblioteca.livros.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.beans.Livro;
import br.biblioteca.livros.services.LivroService;
import br.biblioteca.livros.util.FileSaver;

@Controller
@RequestMapping(LivroController.PATH_LIVRO)
public class LivroController {

	public static final String  PATH_LIVRO = "/livro";
	public static final String PATH_LIVRO_LIST = "/livros";
	public static final String PATH_LIVRO_UPDATE = "/alterar/{idLivro}";
	public static final String PATH_LIVRO_DELETE = "/excluir/{idLivro}";
	
	@Autowired
	LivroService livroService;
	
	@Autowired
	FileSaver fileSaver;
	
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
		
		ModelAndView md = new ModelAndView("livros/form");
		
		md.addObject("autores", livroService.listAutores());
		
		return md;
	} 
	
	@PostMapping(value="/gravar")
	public ModelAndView create(@RequestParam("capaUrl") MultipartFile capaUrl, 
			@ModelAttribute("livro") @Valid Livro livro, BindingResult bindingResult, Model model) {	
		
		if(capaUrl.getOriginalFilename().equals("")) {
			model.addAttribute("message", "A capa não pode ser vazia");
			return new ModelAndView("livros/form");
		}else {
			if(capaUrl.getContentType().equals("image/jpeg")){
				String webPath = fileSaver.write("uploaded-images",capaUrl);
				livro.setFoto(webPath);
			}else{
				model.addAttribute("message", "Arquivo em formato errado. Permitido apenas jpg");
				return new ModelAndView("livros/form");
			}
		}

		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("livros/form");
			modelAndView.addObject("autores", livroService.listAutores());
			return modelAndView;
		}

		livroService.salvar(livro);
		return new ModelAndView("redirect:/livro/livros");
	}

	@GetMapping(PATH_LIVRO_UPDATE)
	public ModelAndView alterar(@PathVariable("idLivro") Long id) {
		Livro livro = this.livroService.findById(id);
		
		if(livro.getFoto() != null) {
			livro.setFoto("/" + livro.getFoto());
		}
		
		ModelAndView md = new ModelAndView("livros/form");
		md.addObject("livro", livro);
		md.addObject("autores", livroService.listAutores());
		return md; //new ModelAndView("livros/form", "livro", livro);
	}

	@GetMapping(PATH_LIVRO_DELETE)
	public ModelAndView excluir(@PathVariable("idLivro") Long idLivro) {
		Livro livro = this.livroService.findById(idLivro);
		
		if(this.livroService.delete(livro)) {
			return new ModelAndView("redirect:/livro/livros");
		} else {
			return new ModelAndView("redirect:/livro/livros");
		}
	}
}
