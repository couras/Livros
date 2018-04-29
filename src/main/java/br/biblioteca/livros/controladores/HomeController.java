package br.biblioteca.livros.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class HomeController {
	@RequestMapping("/")
	public ModelAndView index() {
		System.out.print("Bobby vai pra casa...");
		return new ModelAndView("index");
    }
}
