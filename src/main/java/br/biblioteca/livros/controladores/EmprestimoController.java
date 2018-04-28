package br.biblioteca.livros.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.beans.Emprestimo;
import br.biblioteca.livros.services.EmprestimoService;

@Controller
@RequestMapping(EmprestimoController.PATH_EMPRESTIMO)
public class EmprestimoController {
	public static final String  PATH_EMPRESTIMO = "/emprestimo";
	public static final String PATH_EMPRESTIMO_LIST = "/emprestimos";
	
	@Autowired
	EmprestimoService emprestinoService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
	}

	@RequestMapping(PATH_EMPRESTIMO_LIST)
	public ModelAndView emprestimos() {
		List<Emprestimo> listaEmprestimos = emprestinoService.listaEmprestimos();
		return new ModelAndView("emprestimo/emprestimos", "emprestimos", listaEmprestimos);
	}
}
